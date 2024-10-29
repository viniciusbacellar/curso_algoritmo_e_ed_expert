package org.example.model;

public class VideoData {

    private final String id;
    private final String title;
    private final Integer duration;

    public VideoData(String video) {
        String[] videoParser = video.split(",");
        this.id = videoParser[0];
        this.title = formatNameVideo(videoParser[1]);
        this.duration = Integer.parseInt(videoParser[2]);
    }

    private String formatNameVideo(String name) {
        return name.substring(6,name.length()-4);
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public Integer getDuration() {
        return duration;
    }

    public static String converterCsvToJson(VideoData[] videoDataList) {
        StringBuilder sb = new StringBuilder();
        sb.append("[").append("\n").append(doubleIndentation(false));
        for(int i=0; i<videoDataList.length; i++) {
            boolean isFinal = i == videoDataList.length-1;
            sb
                .append("{").append("\n").append(fourIndentation())
                    .append("\"id\": ").append(formatValue(videoDataList[i].getId())).append(addComma(false)).append("\n").append(fourIndentation())
                    .append("\"title\": ").append(formatValue(videoDataList[i].getTitle())).append(addComma(false)).append("\n").append(fourIndentation())
                    .append("\"duration\": ").append(videoDataList[i].getDuration()).append("\n").append(doubleIndentation(false))
                .append("}").append(addComma(isFinal)).append("\n").append(doubleIndentation(isFinal));
        }
        sb.append("]");
        return sb.toString();
    }

    private static String addComma(boolean flag) {
        return flag ? "" : ",";
    }

    private static String doubleIndentation(boolean flag) {
        return flag ? "" : "  ";
    }

    private static String fourIndentation() {
        return "    ";
    }

    private static String formatValue(String stringValue) {
        return String.format("\"%s\"", stringValue);
    }
}

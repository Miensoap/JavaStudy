package org.example;

import java.util.Map;

public abstract class NaverNewsConsts {
    public static final String BASE_URL = "https://news.naver.com/breakingnews/section";

    public static final Map<String, String> TOPICS = Map.of(
            "사회", "102"
    );

    public static final Map<String, Map<String, String>> DETAIL_TOPICS = Map.of(
        "사회", Map.of("사건사고", "249")
    );
}

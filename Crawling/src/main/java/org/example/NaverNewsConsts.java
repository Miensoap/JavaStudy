package org.example;

import java.util.Map;

public abstract class NaverNewsConsts {
    public static final String BASE_URL = "https://news.naver.com/breakingnews/section";
    public static final String ARTICLE_CSS = "div.section_article div.sa_text";
    public static final String ARTICLE_PRESS_CSS = "div.sa_text_press";
    public static final String ARTICLE_LEDE_CSS = "div.sa_text_lede";
    public static final String ARTICLE_LINK_CSS = "a.sa_text_title";
    public static final String ARTICLE_TITLE_CSS = "a.sa_text_title strong.sa_text_strong";

    public static final Map<String, String> TOPICS = Map.of(
            "사회", "102"
    );

    public static final Map<String, Map<String, String>> DETAIL_TOPICS = Map.of(
        "사회", Map.of("사건사고", "249")
    );
}

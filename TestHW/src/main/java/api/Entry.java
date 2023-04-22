package api;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
public class Entry{
        @JsonProperty("API")
        public String aPI;
        @JsonProperty("Description")
        public String description;
        @JsonProperty("Auth")
        public String auth;
        @JsonProperty("HTTPS")
        public boolean hTTPS;
        @JsonProperty("Cors")
        public String cors;
        @JsonProperty("Link")
        public String link;
        @JsonProperty("Category")
        public String category;

        public Entry(){}
        public Entry(String aPI, String description, String auth, boolean hTTPS, String cors, String link, String category) {
                this.aPI = aPI;
                this.description = description;
                this.auth = auth;
                this.hTTPS = hTTPS;
                this.cors = cors;
                this.link = link;
                this.category = category;
        }

        public String getaPI() {
                return aPI;
        }

        public String getDescription() {
                return description;
        }

        public String getAuth() {
                return auth;
        }

        public boolean ishTTPS() {
                return hTTPS;
        }

        public String getCors() {
                return cors;
        }

        public String getLink() {
                return link;
        }

        public String getCategory() {
                return category;
        }
}

package cat.wars.foodie.framework.model.enums;

public enum CommentLevelEnum {
  GOOD("1"),
  NORMAL("2"),
  LOW("3");

  CommentLevelEnum(String value) {
    this.value = value;
  }

  private String value;
}

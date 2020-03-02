package cat.wars.foodie.framework.model.enums;

public enum CommentLevelEnum {
  GOOD(1),
  NORMAL(2),
  LOW(3);

  public final int value;

  CommentLevelEnum(int value) {
    this.value = value;
  }
}

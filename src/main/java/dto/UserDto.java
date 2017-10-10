package dto;

import po.User;

public class UserDto {
    private User user;
    private Double amount;

    public UserDto(User user, Double amount) {
        this.user = user;
        this.amount = amount;
    }

    public UserDto() {
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }
}

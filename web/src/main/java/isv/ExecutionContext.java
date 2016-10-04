package isv;

import isv.entity.User;
import org.zkoss.zk.ui.Executions;

/**
 * <p>An utility class representing the current execution context. Provides various methods for managing the state of
 * current execution context in consistent way by various parties.</p>
 *
 * @author isv
 * @version 1.0
 */
public class ExecutionContext {

    /**
     * <p>Constructs new <code>ExecutionContext</code> instance. This implementation does nothing.</p>
     */
    private ExecutionContext() {
    }

    /**
     * <p>Sets the specified selected user to current execution context.</p>
     *
     * @param user a currently selected user.
     */
    public static void setSelectedUser(User user) {
        Executions.getCurrent().setAttribute(AttributeName.USER.toString(), user);
    }

    /**
     * <p>Gets the selected user from current execution context.</p>
     *
     * @return  user a currently selected user.
     */
    @SuppressWarnings("unchecked")
    public static User getSelectedUser() {
        return (User) Executions.getCurrent().getAttribute(AttributeName.USER.toString());
    }

    /**
     * <p>An enumeration over the names for various attributes which may be bound to current execution context.</p>
     */
    private enum AttributeName {
        USER;

        /**
         * <p>Gets the textual representation of ths enum item.</p>
         *
         * @return a textual representation of this item.
         */
        @Override
        public String toString() {
            return "test-work-" + super.toString();
        }
    }
}

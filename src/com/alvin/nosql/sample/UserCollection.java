package com.alvin.nosql.sample;

import java.util.LinkedList;
import java.util.List;

import com.alvin.nosql.api.Collection;
import com.alvin.nosql.api.ItemFilter;

/**
 * The implementation class for Collection<User>.
 * @author Alvin
 *
 */
public class UserCollection implements Collection<User> {

	/**
	 * User collection list.
	 */
	private List<User> userList;

	/**
	 * Default constructor.
	 */
	public UserCollection() {
		userList = new LinkedList<User>();
	}

	@Override
	public ItemFilter<User> getDataFilter() {
		return new UserFilter();
	}

	@Override
	public User[] applyFilter(ItemFilter<User> filter) {
		List<User> results = new LinkedList<User>();
		for (User user : userList) {
			boolean isMatch = filter.match(user);
			if (isMatch) {
				results.add(user);
			}
		}
		return results.toArray(new User[results.size()]);
	}

}

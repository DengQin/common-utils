package com.dengqin.utils.base;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

import static java.util.stream.Collectors.toList;


/**
 * 参数转换
 * <p>
 * Created by dq on 2020/5/11
 */
public interface Converter<A, B> {

    default B to(A a) {
        if (a == null) {
            return null;
        }
        return null;
    }

    default A from(B b) {
        if (b == null) {
            return null;
        }
        return null;
    }

    default List<B> to(Collection<A> a) {
        return (a != null ? a : Collections.<A>emptyList()).stream().filter(Objects::nonNull).map(this::to).filter(Objects::nonNull).collect(toList());
    }

    default List<A> from(Collection<B> b) {
        return (b != null ? b : Collections.<B>emptyList()).stream().filter(Objects::nonNull).map(this::from).filter(Objects::nonNull).collect(toList());
    }
}

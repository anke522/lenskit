package org.grouplens.lenskit.knn.user;

import org.grouplens.lenskit.knn.VectorSimilarity;
import org.grouplens.lenskit.vectors.SparseVector;

import javax.inject.Inject;

/**
 * Implementation of {@link UserSimilarity} that delegates to a vector similarity.
 * @author Michael Ekstrand
 * @since 0.11
 */
public class UserVectorSimilarity implements UserSimilarity {
    private VectorSimilarity delegate;

    @Inject
    public UserVectorSimilarity(VectorSimilarity sim) {
        delegate = sim;
    }

    @Override
    public double similarity(long i1, SparseVector v1, long i2, SparseVector v2) {
        return delegate.similarity(v1, v2);
    }

    @Override
    public boolean isSparse() {
        return delegate.isSparse();
    }

    @Override
    public boolean isSymmetric() {
        return delegate.isSymmetric();
    }
}

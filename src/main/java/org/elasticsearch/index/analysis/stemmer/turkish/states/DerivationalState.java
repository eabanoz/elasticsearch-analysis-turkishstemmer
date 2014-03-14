package org.elasticsearch.index.analysis.stemmer.turkish.states;

import org.elasticsearch.index.analysis.stemmer.turkish.suffixes.DerivationalSuffix;
import java.util.EnumSet;

public enum DerivationalState {
  A(true, false, EnumSet.of(DerivationalSuffix.S1)) {
    @Override
    public DerivationalState nextState(final DerivationalSuffix suffix) {
      switch(suffix) {
        case S1:
          return B;
        default:
          return null;
      }
    }
  },

  B(false, true, EnumSet.noneOf(DerivationalSuffix.class)) {
    @Override
    public DerivationalState nextState(final DerivationalSuffix suffix) {
      return null;
    }
  };

  private boolean initialState;
  private boolean finalState;
  private EnumSet<DerivationalSuffix> suffixes;

  private DerivationalState(final boolean initialState,
                            final boolean finalState,
                            final EnumSet<DerivationalSuffix> suffixes) {
    this.initialState = initialState;
    this.finalState = finalState;
    this.suffixes = suffixes;
  }

  public boolean initialState() {
    return this.initialState;
  }

  public boolean finalState() {
    return this.finalState;
  }


  public EnumSet<DerivationalSuffix> suffixes() {
    return this.suffixes;
  }

  public abstract DerivationalState nextState(DerivationalSuffix suffix);

}

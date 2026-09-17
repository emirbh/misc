package fpml.consolidated.loan;

import com.google.common.collect.ImmutableList;
import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.Accessor;
import com.rosetta.model.lib.annotations.AccessorType;
import com.rosetta.model.lib.annotations.Multi;
import com.rosetta.model.lib.annotations.Required;
import com.rosetta.model.lib.annotations.RosettaAttribute;
import com.rosetta.model.lib.annotations.RosettaDataType;
import com.rosetta.model.lib.annotations.RuneAttribute;
import com.rosetta.model.lib.annotations.RuneDataType;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.process.BuilderMerger;
import com.rosetta.model.lib.process.BuilderProcessor;
import com.rosetta.model.lib.process.Processor;
import com.rosetta.util.ListEquals;
import fpml.consolidated.loan.meta.LoanCovenantObligationMetricCalculationDetailsMeta;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision A structure to describe the detail of the calculation of the target criteria of a covenant obligation metric.
 *
 */
@RosettaDataType(value="LoanCovenantObligationMetricCalculationDetails", builder=LoanCovenantObligationMetricCalculationDetails.LoanCovenantObligationMetricCalculationDetailsBuilderImpl.class, version="2.1.1")
@RuneDataType(value="LoanCovenantObligationMetricCalculationDetails", model="fpml", builder=LoanCovenantObligationMetricCalculationDetails.LoanCovenantObligationMetricCalculationDetailsBuilderImpl.class, version="2.1.1")
public interface LoanCovenantObligationMetricCalculationDetails extends RosettaModelObject {

	LoanCovenantObligationMetricCalculationDetailsMeta metaData = new LoanCovenantObligationMetricCalculationDetailsMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The covenant obligation metric numerator type, based on a financial statement or balance sheet value.
	 *
	 */
	List<? extends FinancialMetric> getNumeratorType();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The covenant obligation metric denominator type, based on a financial statement or balance sheet value.
	 *
	 */
	List<? extends FinancialMetric> getDenominatorType();

	/*********************** Build Methods  ***********************/
	LoanCovenantObligationMetricCalculationDetails build();
	
	LoanCovenantObligationMetricCalculationDetails.LoanCovenantObligationMetricCalculationDetailsBuilder toBuilder();
	
	static LoanCovenantObligationMetricCalculationDetails.LoanCovenantObligationMetricCalculationDetailsBuilder builder() {
		return new LoanCovenantObligationMetricCalculationDetails.LoanCovenantObligationMetricCalculationDetailsBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends LoanCovenantObligationMetricCalculationDetails> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends LoanCovenantObligationMetricCalculationDetails> getType() {
		return LoanCovenantObligationMetricCalculationDetails.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("numeratorType"), processor, FinancialMetric.class, getNumeratorType());
		processRosetta(path.newSubPath("denominatorType"), processor, FinancialMetric.class, getDenominatorType());
	}
	

	/*********************** Builder Interface  ***********************/
	interface LoanCovenantObligationMetricCalculationDetailsBuilder extends LoanCovenantObligationMetricCalculationDetails, RosettaModelObjectBuilder {
		FinancialMetric.FinancialMetricBuilder getOrCreateNumeratorType(int index);
		@Override
		List<? extends FinancialMetric.FinancialMetricBuilder> getNumeratorType();
		FinancialMetric.FinancialMetricBuilder getOrCreateDenominatorType(int index);
		@Override
		List<? extends FinancialMetric.FinancialMetricBuilder> getDenominatorType();
		LoanCovenantObligationMetricCalculationDetails.LoanCovenantObligationMetricCalculationDetailsBuilder addNumeratorType(FinancialMetric numeratorType);
		LoanCovenantObligationMetricCalculationDetails.LoanCovenantObligationMetricCalculationDetailsBuilder addNumeratorType(FinancialMetric numeratorType, int idx);
		LoanCovenantObligationMetricCalculationDetails.LoanCovenantObligationMetricCalculationDetailsBuilder addNumeratorType(List<? extends FinancialMetric> numeratorType);
		LoanCovenantObligationMetricCalculationDetails.LoanCovenantObligationMetricCalculationDetailsBuilder setNumeratorType(List<? extends FinancialMetric> numeratorType);
		LoanCovenantObligationMetricCalculationDetails.LoanCovenantObligationMetricCalculationDetailsBuilder addDenominatorType(FinancialMetric denominatorType);
		LoanCovenantObligationMetricCalculationDetails.LoanCovenantObligationMetricCalculationDetailsBuilder addDenominatorType(FinancialMetric denominatorType, int idx);
		LoanCovenantObligationMetricCalculationDetails.LoanCovenantObligationMetricCalculationDetailsBuilder addDenominatorType(List<? extends FinancialMetric> denominatorType);
		LoanCovenantObligationMetricCalculationDetails.LoanCovenantObligationMetricCalculationDetailsBuilder setDenominatorType(List<? extends FinancialMetric> denominatorType);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("numeratorType"), processor, FinancialMetric.FinancialMetricBuilder.class, getNumeratorType());
			processRosetta(path.newSubPath("denominatorType"), processor, FinancialMetric.FinancialMetricBuilder.class, getDenominatorType());
		}
		

		LoanCovenantObligationMetricCalculationDetails.LoanCovenantObligationMetricCalculationDetailsBuilder prune();
	}

	/*********************** Immutable Implementation of LoanCovenantObligationMetricCalculationDetails  ***********************/
	class LoanCovenantObligationMetricCalculationDetailsImpl implements LoanCovenantObligationMetricCalculationDetails {
		private final List<? extends FinancialMetric> numeratorType;
		private final List<? extends FinancialMetric> denominatorType;
		
		protected LoanCovenantObligationMetricCalculationDetailsImpl(LoanCovenantObligationMetricCalculationDetails.LoanCovenantObligationMetricCalculationDetailsBuilder builder) {
			this.numeratorType = ofNullable(builder.getNumeratorType()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.denominatorType = ofNullable(builder.getDenominatorType()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		@RosettaAttribute("numeratorType")
		@Accessor(AccessorType.GETTER)
		@Required
		@Multi
		@RuneAttribute("numeratorType")
		public List<? extends FinancialMetric> getNumeratorType() {
			return numeratorType;
		}
		
		@Override
		@RosettaAttribute("denominatorType")
		@Accessor(AccessorType.GETTER)
		@Required
		@Multi
		@RuneAttribute("denominatorType")
		public List<? extends FinancialMetric> getDenominatorType() {
			return denominatorType;
		}
		
		@Override
		public LoanCovenantObligationMetricCalculationDetails build() {
			return this;
		}
		
		@Override
		public LoanCovenantObligationMetricCalculationDetails.LoanCovenantObligationMetricCalculationDetailsBuilder toBuilder() {
			LoanCovenantObligationMetricCalculationDetails.LoanCovenantObligationMetricCalculationDetailsBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(LoanCovenantObligationMetricCalculationDetails.LoanCovenantObligationMetricCalculationDetailsBuilder builder) {
			ofNullable(getNumeratorType()).ifPresent(builder::setNumeratorType);
			ofNullable(getDenominatorType()).ifPresent(builder::setDenominatorType);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			LoanCovenantObligationMetricCalculationDetails _that = getType().cast(o);
		
			if (!ListEquals.listEquals(numeratorType, _that.getNumeratorType())) return false;
			if (!ListEquals.listEquals(denominatorType, _that.getDenominatorType())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (numeratorType != null ? numeratorType.hashCode() : 0);
			_result = 31 * _result + (denominatorType != null ? denominatorType.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "LoanCovenantObligationMetricCalculationDetails {" +
				"numeratorType=" + this.numeratorType + ", " +
				"denominatorType=" + this.denominatorType +
			'}';
		}
	}

	/*********************** Builder Implementation of LoanCovenantObligationMetricCalculationDetails  ***********************/
	class LoanCovenantObligationMetricCalculationDetailsBuilderImpl implements LoanCovenantObligationMetricCalculationDetails.LoanCovenantObligationMetricCalculationDetailsBuilder {
	
		protected List<FinancialMetric.FinancialMetricBuilder> numeratorType = new ArrayList<>();
		protected List<FinancialMetric.FinancialMetricBuilder> denominatorType = new ArrayList<>();
		
		@Override
		@RosettaAttribute("numeratorType")
		@Accessor(AccessorType.GETTER)
		@Required
		@Multi
		@RuneAttribute("numeratorType")
		public List<? extends FinancialMetric.FinancialMetricBuilder> getNumeratorType() {
			return numeratorType;
		}
		
		@Override
		public FinancialMetric.FinancialMetricBuilder getOrCreateNumeratorType(int index) {
			if (numeratorType==null) {
				this.numeratorType = new ArrayList<>();
			}
			return getIndex(numeratorType, index, () -> {
						FinancialMetric.FinancialMetricBuilder newNumeratorType = FinancialMetric.builder();
						return newNumeratorType;
					});
		}
		
		@Override
		@RosettaAttribute("denominatorType")
		@Accessor(AccessorType.GETTER)
		@Required
		@Multi
		@RuneAttribute("denominatorType")
		public List<? extends FinancialMetric.FinancialMetricBuilder> getDenominatorType() {
			return denominatorType;
		}
		
		@Override
		public FinancialMetric.FinancialMetricBuilder getOrCreateDenominatorType(int index) {
			if (denominatorType==null) {
				this.denominatorType = new ArrayList<>();
			}
			return getIndex(denominatorType, index, () -> {
						FinancialMetric.FinancialMetricBuilder newDenominatorType = FinancialMetric.builder();
						return newDenominatorType;
					});
		}
		
		@RosettaAttribute("numeratorType")
		@Accessor(AccessorType.ADDER)
		@Required
		@Multi
		@RuneAttribute("numeratorType")
		@Override
		public LoanCovenantObligationMetricCalculationDetails.LoanCovenantObligationMetricCalculationDetailsBuilder addNumeratorType(FinancialMetric _numeratorType) {
			if (_numeratorType != null) {
				this.numeratorType.add(_numeratorType.toBuilder());
			}
			return this;
		}
		
		@Override
		public LoanCovenantObligationMetricCalculationDetails.LoanCovenantObligationMetricCalculationDetailsBuilder addNumeratorType(FinancialMetric _numeratorType, int idx) {
			getIndex(this.numeratorType, idx, () -> _numeratorType.toBuilder());
			return this;
		}
		
		@Override
		public LoanCovenantObligationMetricCalculationDetails.LoanCovenantObligationMetricCalculationDetailsBuilder addNumeratorType(List<? extends FinancialMetric> numeratorTypes) {
			if (numeratorTypes != null) {
				for (final FinancialMetric toAdd : numeratorTypes) {
					this.numeratorType.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("numeratorType")
		@Accessor(AccessorType.SETTER)
		@Required
		@Multi
		@RuneAttribute("numeratorType")
		@Override
		public LoanCovenantObligationMetricCalculationDetails.LoanCovenantObligationMetricCalculationDetailsBuilder setNumeratorType(List<? extends FinancialMetric> numeratorTypes) {
			if (numeratorTypes == null) {
				this.numeratorType = new ArrayList<>();
			} else {
				this.numeratorType = numeratorTypes.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("denominatorType")
		@Accessor(AccessorType.ADDER)
		@Required
		@Multi
		@RuneAttribute("denominatorType")
		@Override
		public LoanCovenantObligationMetricCalculationDetails.LoanCovenantObligationMetricCalculationDetailsBuilder addDenominatorType(FinancialMetric _denominatorType) {
			if (_denominatorType != null) {
				this.denominatorType.add(_denominatorType.toBuilder());
			}
			return this;
		}
		
		@Override
		public LoanCovenantObligationMetricCalculationDetails.LoanCovenantObligationMetricCalculationDetailsBuilder addDenominatorType(FinancialMetric _denominatorType, int idx) {
			getIndex(this.denominatorType, idx, () -> _denominatorType.toBuilder());
			return this;
		}
		
		@Override
		public LoanCovenantObligationMetricCalculationDetails.LoanCovenantObligationMetricCalculationDetailsBuilder addDenominatorType(List<? extends FinancialMetric> denominatorTypes) {
			if (denominatorTypes != null) {
				for (final FinancialMetric toAdd : denominatorTypes) {
					this.denominatorType.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("denominatorType")
		@Accessor(AccessorType.SETTER)
		@Required
		@Multi
		@RuneAttribute("denominatorType")
		@Override
		public LoanCovenantObligationMetricCalculationDetails.LoanCovenantObligationMetricCalculationDetailsBuilder setDenominatorType(List<? extends FinancialMetric> denominatorTypes) {
			if (denominatorTypes == null) {
				this.denominatorType = new ArrayList<>();
			} else {
				this.denominatorType = denominatorTypes.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		public LoanCovenantObligationMetricCalculationDetails build() {
			return new LoanCovenantObligationMetricCalculationDetails.LoanCovenantObligationMetricCalculationDetailsImpl(this);
		}
		
		@Override
		public LoanCovenantObligationMetricCalculationDetails.LoanCovenantObligationMetricCalculationDetailsBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public LoanCovenantObligationMetricCalculationDetails.LoanCovenantObligationMetricCalculationDetailsBuilder prune() {
			numeratorType = numeratorType.stream().filter(b->b!=null).<FinancialMetric.FinancialMetricBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			denominatorType = denominatorType.stream().filter(b->b!=null).<FinancialMetric.FinancialMetricBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getNumeratorType()!=null && getNumeratorType().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getDenominatorType()!=null && getDenominatorType().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public LoanCovenantObligationMetricCalculationDetails.LoanCovenantObligationMetricCalculationDetailsBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			LoanCovenantObligationMetricCalculationDetails.LoanCovenantObligationMetricCalculationDetailsBuilder o = (LoanCovenantObligationMetricCalculationDetails.LoanCovenantObligationMetricCalculationDetailsBuilder) other;
			
			merger.mergeRosetta(getNumeratorType(), o.getNumeratorType(), this::getOrCreateNumeratorType);
			merger.mergeRosetta(getDenominatorType(), o.getDenominatorType(), this::getOrCreateDenominatorType);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			LoanCovenantObligationMetricCalculationDetails _that = getType().cast(o);
		
			if (!ListEquals.listEquals(numeratorType, _that.getNumeratorType())) return false;
			if (!ListEquals.listEquals(denominatorType, _that.getDenominatorType())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (numeratorType != null ? numeratorType.hashCode() : 0);
			_result = 31 * _result + (denominatorType != null ? denominatorType.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "LoanCovenantObligationMetricCalculationDetailsBuilder {" +
				"numeratorType=" + this.numeratorType + ", " +
				"denominatorType=" + this.denominatorType +
			'}';
		}
	}
}

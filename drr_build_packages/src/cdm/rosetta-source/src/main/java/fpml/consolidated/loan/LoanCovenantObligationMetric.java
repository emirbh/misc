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
import fpml.consolidated.loan.meta.LoanCovenantObligationMetricMeta;
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
 * Provision A structure to describe the metric of target criteria of a covenant obligation.
 *
 */
@RosettaDataType(value="LoanCovenantObligationMetric", builder=LoanCovenantObligationMetric.LoanCovenantObligationMetricBuilderImpl.class, version="2.1.1")
@RuneDataType(value="LoanCovenantObligationMetric", model="fpml", builder=LoanCovenantObligationMetric.LoanCovenantObligationMetricBuilderImpl.class, version="2.1.1")
public interface LoanCovenantObligationMetric extends RosettaModelObject {

	LoanCovenantObligationMetricMeta metaData = new LoanCovenantObligationMetricMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision 
	 *
	 */
	List<? extends LoanCovenantObligationMetricSequence> getLoanCovenantObligationMetricSequence();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A structure used to describe a loan covenant obligation metric type, described by a scheme.
	 *
	 */
	LoanCovenantObligationMetricType getMetricType();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A structure to optionally describe an adjustment or modification consideration for the metric type described.
	 *
	 */
	LoanCovenantObligationMetricAdjustment getMetricAdjustment();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A structure to describe the detail of the calculation of the target criteria of a covenant obligation (based on financial statement and/or balance sheet value types).
	 *
	 */
	LoanCovenantObligationMetricCalculationDetails getCalculationDetails();

	/*********************** Build Methods  ***********************/
	LoanCovenantObligationMetric build();
	
	LoanCovenantObligationMetric.LoanCovenantObligationMetricBuilder toBuilder();
	
	static LoanCovenantObligationMetric.LoanCovenantObligationMetricBuilder builder() {
		return new LoanCovenantObligationMetric.LoanCovenantObligationMetricBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends LoanCovenantObligationMetric> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends LoanCovenantObligationMetric> getType() {
		return LoanCovenantObligationMetric.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("loanCovenantObligationMetricSequence"), processor, LoanCovenantObligationMetricSequence.class, getLoanCovenantObligationMetricSequence());
		processRosetta(path.newSubPath("metricType"), processor, LoanCovenantObligationMetricType.class, getMetricType());
		processRosetta(path.newSubPath("metricAdjustment"), processor, LoanCovenantObligationMetricAdjustment.class, getMetricAdjustment());
		processRosetta(path.newSubPath("calculationDetails"), processor, LoanCovenantObligationMetricCalculationDetails.class, getCalculationDetails());
	}
	

	/*********************** Builder Interface  ***********************/
	interface LoanCovenantObligationMetricBuilder extends LoanCovenantObligationMetric, RosettaModelObjectBuilder {
		LoanCovenantObligationMetricSequence.LoanCovenantObligationMetricSequenceBuilder getOrCreateLoanCovenantObligationMetricSequence(int index);
		@Override
		List<? extends LoanCovenantObligationMetricSequence.LoanCovenantObligationMetricSequenceBuilder> getLoanCovenantObligationMetricSequence();
		LoanCovenantObligationMetricType.LoanCovenantObligationMetricTypeBuilder getOrCreateMetricType();
		@Override
		LoanCovenantObligationMetricType.LoanCovenantObligationMetricTypeBuilder getMetricType();
		LoanCovenantObligationMetricAdjustment.LoanCovenantObligationMetricAdjustmentBuilder getOrCreateMetricAdjustment();
		@Override
		LoanCovenantObligationMetricAdjustment.LoanCovenantObligationMetricAdjustmentBuilder getMetricAdjustment();
		LoanCovenantObligationMetricCalculationDetails.LoanCovenantObligationMetricCalculationDetailsBuilder getOrCreateCalculationDetails();
		@Override
		LoanCovenantObligationMetricCalculationDetails.LoanCovenantObligationMetricCalculationDetailsBuilder getCalculationDetails();
		LoanCovenantObligationMetric.LoanCovenantObligationMetricBuilder addLoanCovenantObligationMetricSequence(LoanCovenantObligationMetricSequence loanCovenantObligationMetricSequence);
		LoanCovenantObligationMetric.LoanCovenantObligationMetricBuilder addLoanCovenantObligationMetricSequence(LoanCovenantObligationMetricSequence loanCovenantObligationMetricSequence, int idx);
		LoanCovenantObligationMetric.LoanCovenantObligationMetricBuilder addLoanCovenantObligationMetricSequence(List<? extends LoanCovenantObligationMetricSequence> loanCovenantObligationMetricSequence);
		LoanCovenantObligationMetric.LoanCovenantObligationMetricBuilder setLoanCovenantObligationMetricSequence(List<? extends LoanCovenantObligationMetricSequence> loanCovenantObligationMetricSequence);
		LoanCovenantObligationMetric.LoanCovenantObligationMetricBuilder setMetricType(LoanCovenantObligationMetricType metricType);
		LoanCovenantObligationMetric.LoanCovenantObligationMetricBuilder setMetricAdjustment(LoanCovenantObligationMetricAdjustment metricAdjustment);
		LoanCovenantObligationMetric.LoanCovenantObligationMetricBuilder setCalculationDetails(LoanCovenantObligationMetricCalculationDetails calculationDetails);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("loanCovenantObligationMetricSequence"), processor, LoanCovenantObligationMetricSequence.LoanCovenantObligationMetricSequenceBuilder.class, getLoanCovenantObligationMetricSequence());
			processRosetta(path.newSubPath("metricType"), processor, LoanCovenantObligationMetricType.LoanCovenantObligationMetricTypeBuilder.class, getMetricType());
			processRosetta(path.newSubPath("metricAdjustment"), processor, LoanCovenantObligationMetricAdjustment.LoanCovenantObligationMetricAdjustmentBuilder.class, getMetricAdjustment());
			processRosetta(path.newSubPath("calculationDetails"), processor, LoanCovenantObligationMetricCalculationDetails.LoanCovenantObligationMetricCalculationDetailsBuilder.class, getCalculationDetails());
		}
		

		LoanCovenantObligationMetric.LoanCovenantObligationMetricBuilder prune();
	}

	/*********************** Immutable Implementation of LoanCovenantObligationMetric  ***********************/
	class LoanCovenantObligationMetricImpl implements LoanCovenantObligationMetric {
		private final List<? extends LoanCovenantObligationMetricSequence> loanCovenantObligationMetricSequence;
		private final LoanCovenantObligationMetricType metricType;
		private final LoanCovenantObligationMetricAdjustment metricAdjustment;
		private final LoanCovenantObligationMetricCalculationDetails calculationDetails;
		
		protected LoanCovenantObligationMetricImpl(LoanCovenantObligationMetric.LoanCovenantObligationMetricBuilder builder) {
			this.loanCovenantObligationMetricSequence = ofNullable(builder.getLoanCovenantObligationMetricSequence()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.metricType = ofNullable(builder.getMetricType()).map(f->f.build()).orElse(null);
			this.metricAdjustment = ofNullable(builder.getMetricAdjustment()).map(f->f.build()).orElse(null);
			this.calculationDetails = ofNullable(builder.getCalculationDetails()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("loanCovenantObligationMetricSequence")
		@Accessor(AccessorType.GETTER)
		@Required
		@Multi
		@RuneAttribute("loanCovenantObligationMetricSequence")
		public List<? extends LoanCovenantObligationMetricSequence> getLoanCovenantObligationMetricSequence() {
			return loanCovenantObligationMetricSequence;
		}
		
		@Override
		@RosettaAttribute("metricType")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("metricType")
		public LoanCovenantObligationMetricType getMetricType() {
			return metricType;
		}
		
		@Override
		@RosettaAttribute("metricAdjustment")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("metricAdjustment")
		public LoanCovenantObligationMetricAdjustment getMetricAdjustment() {
			return metricAdjustment;
		}
		
		@Override
		@RosettaAttribute("calculationDetails")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("calculationDetails")
		public LoanCovenantObligationMetricCalculationDetails getCalculationDetails() {
			return calculationDetails;
		}
		
		@Override
		public LoanCovenantObligationMetric build() {
			return this;
		}
		
		@Override
		public LoanCovenantObligationMetric.LoanCovenantObligationMetricBuilder toBuilder() {
			LoanCovenantObligationMetric.LoanCovenantObligationMetricBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(LoanCovenantObligationMetric.LoanCovenantObligationMetricBuilder builder) {
			ofNullable(getLoanCovenantObligationMetricSequence()).ifPresent(builder::setLoanCovenantObligationMetricSequence);
			ofNullable(getMetricType()).ifPresent(builder::setMetricType);
			ofNullable(getMetricAdjustment()).ifPresent(builder::setMetricAdjustment);
			ofNullable(getCalculationDetails()).ifPresent(builder::setCalculationDetails);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			LoanCovenantObligationMetric _that = getType().cast(o);
		
			if (!ListEquals.listEquals(loanCovenantObligationMetricSequence, _that.getLoanCovenantObligationMetricSequence())) return false;
			if (!Objects.equals(metricType, _that.getMetricType())) return false;
			if (!Objects.equals(metricAdjustment, _that.getMetricAdjustment())) return false;
			if (!Objects.equals(calculationDetails, _that.getCalculationDetails())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (loanCovenantObligationMetricSequence != null ? loanCovenantObligationMetricSequence.hashCode() : 0);
			_result = 31 * _result + (metricType != null ? metricType.hashCode() : 0);
			_result = 31 * _result + (metricAdjustment != null ? metricAdjustment.hashCode() : 0);
			_result = 31 * _result + (calculationDetails != null ? calculationDetails.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "LoanCovenantObligationMetric {" +
				"loanCovenantObligationMetricSequence=" + this.loanCovenantObligationMetricSequence + ", " +
				"metricType=" + this.metricType + ", " +
				"metricAdjustment=" + this.metricAdjustment + ", " +
				"calculationDetails=" + this.calculationDetails +
			'}';
		}
	}

	/*********************** Builder Implementation of LoanCovenantObligationMetric  ***********************/
	class LoanCovenantObligationMetricBuilderImpl implements LoanCovenantObligationMetric.LoanCovenantObligationMetricBuilder {
	
		protected List<LoanCovenantObligationMetricSequence.LoanCovenantObligationMetricSequenceBuilder> loanCovenantObligationMetricSequence = new ArrayList<>();
		protected LoanCovenantObligationMetricType.LoanCovenantObligationMetricTypeBuilder metricType;
		protected LoanCovenantObligationMetricAdjustment.LoanCovenantObligationMetricAdjustmentBuilder metricAdjustment;
		protected LoanCovenantObligationMetricCalculationDetails.LoanCovenantObligationMetricCalculationDetailsBuilder calculationDetails;
		
		@Override
		@RosettaAttribute("loanCovenantObligationMetricSequence")
		@Accessor(AccessorType.GETTER)
		@Required
		@Multi
		@RuneAttribute("loanCovenantObligationMetricSequence")
		public List<? extends LoanCovenantObligationMetricSequence.LoanCovenantObligationMetricSequenceBuilder> getLoanCovenantObligationMetricSequence() {
			return loanCovenantObligationMetricSequence;
		}
		
		@Override
		public LoanCovenantObligationMetricSequence.LoanCovenantObligationMetricSequenceBuilder getOrCreateLoanCovenantObligationMetricSequence(int index) {
			if (loanCovenantObligationMetricSequence==null) {
				this.loanCovenantObligationMetricSequence = new ArrayList<>();
			}
			return getIndex(loanCovenantObligationMetricSequence, index, () -> {
						LoanCovenantObligationMetricSequence.LoanCovenantObligationMetricSequenceBuilder newLoanCovenantObligationMetricSequence = LoanCovenantObligationMetricSequence.builder();
						return newLoanCovenantObligationMetricSequence;
					});
		}
		
		@Override
		@RosettaAttribute("metricType")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("metricType")
		public LoanCovenantObligationMetricType.LoanCovenantObligationMetricTypeBuilder getMetricType() {
			return metricType;
		}
		
		@Override
		public LoanCovenantObligationMetricType.LoanCovenantObligationMetricTypeBuilder getOrCreateMetricType() {
			LoanCovenantObligationMetricType.LoanCovenantObligationMetricTypeBuilder result;
			if (metricType!=null) {
				result = metricType;
			}
			else {
				result = metricType = LoanCovenantObligationMetricType.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("metricAdjustment")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("metricAdjustment")
		public LoanCovenantObligationMetricAdjustment.LoanCovenantObligationMetricAdjustmentBuilder getMetricAdjustment() {
			return metricAdjustment;
		}
		
		@Override
		public LoanCovenantObligationMetricAdjustment.LoanCovenantObligationMetricAdjustmentBuilder getOrCreateMetricAdjustment() {
			LoanCovenantObligationMetricAdjustment.LoanCovenantObligationMetricAdjustmentBuilder result;
			if (metricAdjustment!=null) {
				result = metricAdjustment;
			}
			else {
				result = metricAdjustment = LoanCovenantObligationMetricAdjustment.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("calculationDetails")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("calculationDetails")
		public LoanCovenantObligationMetricCalculationDetails.LoanCovenantObligationMetricCalculationDetailsBuilder getCalculationDetails() {
			return calculationDetails;
		}
		
		@Override
		public LoanCovenantObligationMetricCalculationDetails.LoanCovenantObligationMetricCalculationDetailsBuilder getOrCreateCalculationDetails() {
			LoanCovenantObligationMetricCalculationDetails.LoanCovenantObligationMetricCalculationDetailsBuilder result;
			if (calculationDetails!=null) {
				result = calculationDetails;
			}
			else {
				result = calculationDetails = LoanCovenantObligationMetricCalculationDetails.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("loanCovenantObligationMetricSequence")
		@Accessor(AccessorType.ADDER)
		@Required
		@Multi
		@RuneAttribute("loanCovenantObligationMetricSequence")
		@Override
		public LoanCovenantObligationMetric.LoanCovenantObligationMetricBuilder addLoanCovenantObligationMetricSequence(LoanCovenantObligationMetricSequence _loanCovenantObligationMetricSequence) {
			if (_loanCovenantObligationMetricSequence != null) {
				this.loanCovenantObligationMetricSequence.add(_loanCovenantObligationMetricSequence.toBuilder());
			}
			return this;
		}
		
		@Override
		public LoanCovenantObligationMetric.LoanCovenantObligationMetricBuilder addLoanCovenantObligationMetricSequence(LoanCovenantObligationMetricSequence _loanCovenantObligationMetricSequence, int idx) {
			getIndex(this.loanCovenantObligationMetricSequence, idx, () -> _loanCovenantObligationMetricSequence.toBuilder());
			return this;
		}
		
		@Override
		public LoanCovenantObligationMetric.LoanCovenantObligationMetricBuilder addLoanCovenantObligationMetricSequence(List<? extends LoanCovenantObligationMetricSequence> loanCovenantObligationMetricSequences) {
			if (loanCovenantObligationMetricSequences != null) {
				for (final LoanCovenantObligationMetricSequence toAdd : loanCovenantObligationMetricSequences) {
					this.loanCovenantObligationMetricSequence.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("loanCovenantObligationMetricSequence")
		@Accessor(AccessorType.SETTER)
		@Required
		@Multi
		@RuneAttribute("loanCovenantObligationMetricSequence")
		@Override
		public LoanCovenantObligationMetric.LoanCovenantObligationMetricBuilder setLoanCovenantObligationMetricSequence(List<? extends LoanCovenantObligationMetricSequence> loanCovenantObligationMetricSequences) {
			if (loanCovenantObligationMetricSequences == null) {
				this.loanCovenantObligationMetricSequence = new ArrayList<>();
			} else {
				this.loanCovenantObligationMetricSequence = loanCovenantObligationMetricSequences.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("metricType")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("metricType")
		@Override
		public LoanCovenantObligationMetric.LoanCovenantObligationMetricBuilder setMetricType(LoanCovenantObligationMetricType _metricType) {
			this.metricType = _metricType == null ? null : _metricType.toBuilder();
			return this;
		}
		
		@RosettaAttribute("metricAdjustment")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("metricAdjustment")
		@Override
		public LoanCovenantObligationMetric.LoanCovenantObligationMetricBuilder setMetricAdjustment(LoanCovenantObligationMetricAdjustment _metricAdjustment) {
			this.metricAdjustment = _metricAdjustment == null ? null : _metricAdjustment.toBuilder();
			return this;
		}
		
		@RosettaAttribute("calculationDetails")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("calculationDetails")
		@Override
		public LoanCovenantObligationMetric.LoanCovenantObligationMetricBuilder setCalculationDetails(LoanCovenantObligationMetricCalculationDetails _calculationDetails) {
			this.calculationDetails = _calculationDetails == null ? null : _calculationDetails.toBuilder();
			return this;
		}
		
		@Override
		public LoanCovenantObligationMetric build() {
			return new LoanCovenantObligationMetric.LoanCovenantObligationMetricImpl(this);
		}
		
		@Override
		public LoanCovenantObligationMetric.LoanCovenantObligationMetricBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public LoanCovenantObligationMetric.LoanCovenantObligationMetricBuilder prune() {
			loanCovenantObligationMetricSequence = loanCovenantObligationMetricSequence.stream().filter(b->b!=null).<LoanCovenantObligationMetricSequence.LoanCovenantObligationMetricSequenceBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			if (metricType!=null && !metricType.prune().hasData()) metricType = null;
			if (metricAdjustment!=null && !metricAdjustment.prune().hasData()) metricAdjustment = null;
			if (calculationDetails!=null && !calculationDetails.prune().hasData()) calculationDetails = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getLoanCovenantObligationMetricSequence()!=null && getLoanCovenantObligationMetricSequence().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getMetricType()!=null && getMetricType().hasData()) return true;
			if (getMetricAdjustment()!=null && getMetricAdjustment().hasData()) return true;
			if (getCalculationDetails()!=null && getCalculationDetails().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public LoanCovenantObligationMetric.LoanCovenantObligationMetricBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			LoanCovenantObligationMetric.LoanCovenantObligationMetricBuilder o = (LoanCovenantObligationMetric.LoanCovenantObligationMetricBuilder) other;
			
			merger.mergeRosetta(getLoanCovenantObligationMetricSequence(), o.getLoanCovenantObligationMetricSequence(), this::getOrCreateLoanCovenantObligationMetricSequence);
			merger.mergeRosetta(getMetricType(), o.getMetricType(), this::setMetricType);
			merger.mergeRosetta(getMetricAdjustment(), o.getMetricAdjustment(), this::setMetricAdjustment);
			merger.mergeRosetta(getCalculationDetails(), o.getCalculationDetails(), this::setCalculationDetails);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			LoanCovenantObligationMetric _that = getType().cast(o);
		
			if (!ListEquals.listEquals(loanCovenantObligationMetricSequence, _that.getLoanCovenantObligationMetricSequence())) return false;
			if (!Objects.equals(metricType, _that.getMetricType())) return false;
			if (!Objects.equals(metricAdjustment, _that.getMetricAdjustment())) return false;
			if (!Objects.equals(calculationDetails, _that.getCalculationDetails())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (loanCovenantObligationMetricSequence != null ? loanCovenantObligationMetricSequence.hashCode() : 0);
			_result = 31 * _result + (metricType != null ? metricType.hashCode() : 0);
			_result = 31 * _result + (metricAdjustment != null ? metricAdjustment.hashCode() : 0);
			_result = 31 * _result + (calculationDetails != null ? calculationDetails.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "LoanCovenantObligationMetricBuilder {" +
				"loanCovenantObligationMetricSequence=" + this.loanCovenantObligationMetricSequence + ", " +
				"metricType=" + this.metricType + ", " +
				"metricAdjustment=" + this.metricAdjustment + ", " +
				"calculationDetails=" + this.calculationDetails +
			'}';
		}
	}
}

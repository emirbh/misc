package fpml.consolidated.loan;

import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.Accessor;
import com.rosetta.model.lib.annotations.AccessorType;
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
import fpml.consolidated.loan.meta.LoanCovenantObligationMetricAdjustmentMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision A structure to describe adjustments to a covenant obligation metric (e.g. previous quarter, previous month, etc.)
 *
 */
@RosettaDataType(value="LoanCovenantObligationMetricAdjustment", builder=LoanCovenantObligationMetricAdjustment.LoanCovenantObligationMetricAdjustmentBuilderImpl.class, version="2.1.1")
@RuneDataType(value="LoanCovenantObligationMetricAdjustment", model="fpml", builder=LoanCovenantObligationMetricAdjustment.LoanCovenantObligationMetricAdjustmentBuilderImpl.class, version="2.1.1")
public interface LoanCovenantObligationMetricAdjustment extends RosettaModelObject {

	LoanCovenantObligationMetricAdjustmentMeta metaData = new LoanCovenantObligationMetricAdjustmentMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A metric adjustment value type, based on a scheme (e.g. previous quarter(s), previous month(s), rolling month(s), etc.)
	 *
	 */
	MetricAdjustmentType _getType();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision An element to optionally detail the number of units described by the metric adjustment type (e.g. if metric adjustment type is previous quarter, this element describes number of quarters).
	 *
	 */
	Integer getAmount();

	/*********************** Build Methods  ***********************/
	LoanCovenantObligationMetricAdjustment build();
	
	LoanCovenantObligationMetricAdjustment.LoanCovenantObligationMetricAdjustmentBuilder toBuilder();
	
	static LoanCovenantObligationMetricAdjustment.LoanCovenantObligationMetricAdjustmentBuilder builder() {
		return new LoanCovenantObligationMetricAdjustment.LoanCovenantObligationMetricAdjustmentBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends LoanCovenantObligationMetricAdjustment> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends LoanCovenantObligationMetricAdjustment> getType() {
		return LoanCovenantObligationMetricAdjustment.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("type"), processor, MetricAdjustmentType.class, _getType());
		processor.processBasic(path.newSubPath("amount"), Integer.class, getAmount(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface LoanCovenantObligationMetricAdjustmentBuilder extends LoanCovenantObligationMetricAdjustment, RosettaModelObjectBuilder {
		MetricAdjustmentType.MetricAdjustmentTypeBuilder getOrCreateType();
		@Override
		MetricAdjustmentType.MetricAdjustmentTypeBuilder _getType();
		LoanCovenantObligationMetricAdjustment.LoanCovenantObligationMetricAdjustmentBuilder setType(MetricAdjustmentType type);
		LoanCovenantObligationMetricAdjustment.LoanCovenantObligationMetricAdjustmentBuilder setAmount(Integer amount);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("type"), processor, MetricAdjustmentType.MetricAdjustmentTypeBuilder.class, _getType());
			processor.processBasic(path.newSubPath("amount"), Integer.class, getAmount(), this);
		}
		

		LoanCovenantObligationMetricAdjustment.LoanCovenantObligationMetricAdjustmentBuilder prune();
	}

	/*********************** Immutable Implementation of LoanCovenantObligationMetricAdjustment  ***********************/
	class LoanCovenantObligationMetricAdjustmentImpl implements LoanCovenantObligationMetricAdjustment {
		private final MetricAdjustmentType type;
		private final Integer amount;
		
		protected LoanCovenantObligationMetricAdjustmentImpl(LoanCovenantObligationMetricAdjustment.LoanCovenantObligationMetricAdjustmentBuilder builder) {
			this.type = ofNullable(builder._getType()).map(f->f.build()).orElse(null);
			this.amount = builder.getAmount();
		}
		
		@Override
		@RosettaAttribute("type")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("type")
		public MetricAdjustmentType _getType() {
			return type;
		}
		
		@Override
		@RosettaAttribute("amount")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("amount")
		public Integer getAmount() {
			return amount;
		}
		
		@Override
		public LoanCovenantObligationMetricAdjustment build() {
			return this;
		}
		
		@Override
		public LoanCovenantObligationMetricAdjustment.LoanCovenantObligationMetricAdjustmentBuilder toBuilder() {
			LoanCovenantObligationMetricAdjustment.LoanCovenantObligationMetricAdjustmentBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(LoanCovenantObligationMetricAdjustment.LoanCovenantObligationMetricAdjustmentBuilder builder) {
			ofNullable(_getType()).ifPresent(builder::setType);
			ofNullable(getAmount()).ifPresent(builder::setAmount);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			LoanCovenantObligationMetricAdjustment _that = getType().cast(o);
		
			if (!Objects.equals(type, _that._getType())) return false;
			if (!Objects.equals(amount, _that.getAmount())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (type != null ? type.hashCode() : 0);
			_result = 31 * _result + (amount != null ? amount.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "LoanCovenantObligationMetricAdjustment {" +
				"type=" + this.type + ", " +
				"amount=" + this.amount +
			'}';
		}
	}

	/*********************** Builder Implementation of LoanCovenantObligationMetricAdjustment  ***********************/
	class LoanCovenantObligationMetricAdjustmentBuilderImpl implements LoanCovenantObligationMetricAdjustment.LoanCovenantObligationMetricAdjustmentBuilder {
	
		protected MetricAdjustmentType.MetricAdjustmentTypeBuilder type;
		protected Integer amount;
		
		@Override
		@RosettaAttribute("type")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("type")
		public MetricAdjustmentType.MetricAdjustmentTypeBuilder _getType() {
			return type;
		}
		
		@Override
		public MetricAdjustmentType.MetricAdjustmentTypeBuilder getOrCreateType() {
			MetricAdjustmentType.MetricAdjustmentTypeBuilder result;
			if (type!=null) {
				result = type;
			}
			else {
				result = type = MetricAdjustmentType.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("amount")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("amount")
		public Integer getAmount() {
			return amount;
		}
		
		@RosettaAttribute("type")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("type")
		@Override
		public LoanCovenantObligationMetricAdjustment.LoanCovenantObligationMetricAdjustmentBuilder setType(MetricAdjustmentType _type) {
			this.type = _type == null ? null : _type.toBuilder();
			return this;
		}
		
		@RosettaAttribute("amount")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("amount")
		@Override
		public LoanCovenantObligationMetricAdjustment.LoanCovenantObligationMetricAdjustmentBuilder setAmount(Integer _amount) {
			this.amount = _amount == null ? null : _amount;
			return this;
		}
		
		@Override
		public LoanCovenantObligationMetricAdjustment build() {
			return new LoanCovenantObligationMetricAdjustment.LoanCovenantObligationMetricAdjustmentImpl(this);
		}
		
		@Override
		public LoanCovenantObligationMetricAdjustment.LoanCovenantObligationMetricAdjustmentBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public LoanCovenantObligationMetricAdjustment.LoanCovenantObligationMetricAdjustmentBuilder prune() {
			if (type!=null && !type.prune().hasData()) type = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (_getType()!=null && _getType().hasData()) return true;
			if (getAmount()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public LoanCovenantObligationMetricAdjustment.LoanCovenantObligationMetricAdjustmentBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			LoanCovenantObligationMetricAdjustment.LoanCovenantObligationMetricAdjustmentBuilder o = (LoanCovenantObligationMetricAdjustment.LoanCovenantObligationMetricAdjustmentBuilder) other;
			
			merger.mergeRosetta(_getType(), o._getType(), this::setType);
			
			merger.mergeBasic(getAmount(), o.getAmount(), this::setAmount);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			LoanCovenantObligationMetricAdjustment _that = getType().cast(o);
		
			if (!Objects.equals(type, _that._getType())) return false;
			if (!Objects.equals(amount, _that.getAmount())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (type != null ? type.hashCode() : 0);
			_result = 31 * _result + (amount != null ? amount.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "LoanCovenantObligationMetricAdjustmentBuilder {" +
				"type=" + this.type + ", " +
				"amount=" + this.amount +
			'}';
		}
	}
}

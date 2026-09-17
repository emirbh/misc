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
import fpml.consolidated.loan.meta.RateAdjustmentMeta;
import java.math.BigDecimal;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision A structure that represents adjustments to the base rate.
 *
 */
@RosettaDataType(value="RateAdjustment", builder=RateAdjustment.RateAdjustmentBuilderImpl.class, version="2.1.1")
@RuneDataType(value="RateAdjustment", model="fpml", builder=RateAdjustment.RateAdjustmentBuilderImpl.class, version="2.1.1")
public interface RateAdjustment extends RosettaModelObject {

	RateAdjustmentMeta metaData = new RateAdjustmentMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The adjustment to the base rate related to the credit risk of the issuer or borrower. Commonly referred to as the "rate margin" or "margin."
	 *
	 */
	BigDecimal getMargin();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision 
	 *
	 */
	BigDecimal getPikSpread();

	/*********************** Build Methods  ***********************/
	RateAdjustment build();
	
	RateAdjustment.RateAdjustmentBuilder toBuilder();
	
	static RateAdjustment.RateAdjustmentBuilder builder() {
		return new RateAdjustment.RateAdjustmentBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends RateAdjustment> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends RateAdjustment> getType() {
		return RateAdjustment.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("margin"), BigDecimal.class, getMargin(), this);
		processor.processBasic(path.newSubPath("pikSpread"), BigDecimal.class, getPikSpread(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface RateAdjustmentBuilder extends RateAdjustment, RosettaModelObjectBuilder {
		RateAdjustment.RateAdjustmentBuilder setMargin(BigDecimal margin);
		RateAdjustment.RateAdjustmentBuilder setPikSpread(BigDecimal pikSpread);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("margin"), BigDecimal.class, getMargin(), this);
			processor.processBasic(path.newSubPath("pikSpread"), BigDecimal.class, getPikSpread(), this);
		}
		

		RateAdjustment.RateAdjustmentBuilder prune();
	}

	/*********************** Immutable Implementation of RateAdjustment  ***********************/
	class RateAdjustmentImpl implements RateAdjustment {
		private final BigDecimal margin;
		private final BigDecimal pikSpread;
		
		protected RateAdjustmentImpl(RateAdjustment.RateAdjustmentBuilder builder) {
			this.margin = builder.getMargin();
			this.pikSpread = builder.getPikSpread();
		}
		
		@Override
		@RosettaAttribute("margin")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("margin")
		public BigDecimal getMargin() {
			return margin;
		}
		
		@Override
		@RosettaAttribute("pikSpread")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("pikSpread")
		public BigDecimal getPikSpread() {
			return pikSpread;
		}
		
		@Override
		public RateAdjustment build() {
			return this;
		}
		
		@Override
		public RateAdjustment.RateAdjustmentBuilder toBuilder() {
			RateAdjustment.RateAdjustmentBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(RateAdjustment.RateAdjustmentBuilder builder) {
			ofNullable(getMargin()).ifPresent(builder::setMargin);
			ofNullable(getPikSpread()).ifPresent(builder::setPikSpread);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			RateAdjustment _that = getType().cast(o);
		
			if (!Objects.equals(margin, _that.getMargin())) return false;
			if (!Objects.equals(pikSpread, _that.getPikSpread())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (margin != null ? margin.hashCode() : 0);
			_result = 31 * _result + (pikSpread != null ? pikSpread.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "RateAdjustment {" +
				"margin=" + this.margin + ", " +
				"pikSpread=" + this.pikSpread +
			'}';
		}
	}

	/*********************** Builder Implementation of RateAdjustment  ***********************/
	class RateAdjustmentBuilderImpl implements RateAdjustment.RateAdjustmentBuilder {
	
		protected BigDecimal margin;
		protected BigDecimal pikSpread;
		
		@Override
		@RosettaAttribute("margin")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("margin")
		public BigDecimal getMargin() {
			return margin;
		}
		
		@Override
		@RosettaAttribute("pikSpread")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("pikSpread")
		public BigDecimal getPikSpread() {
			return pikSpread;
		}
		
		@RosettaAttribute("margin")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("margin")
		@Override
		public RateAdjustment.RateAdjustmentBuilder setMargin(BigDecimal _margin) {
			this.margin = _margin == null ? null : _margin;
			return this;
		}
		
		@RosettaAttribute("pikSpread")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("pikSpread")
		@Override
		public RateAdjustment.RateAdjustmentBuilder setPikSpread(BigDecimal _pikSpread) {
			this.pikSpread = _pikSpread == null ? null : _pikSpread;
			return this;
		}
		
		@Override
		public RateAdjustment build() {
			return new RateAdjustment.RateAdjustmentImpl(this);
		}
		
		@Override
		public RateAdjustment.RateAdjustmentBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public RateAdjustment.RateAdjustmentBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getMargin()!=null) return true;
			if (getPikSpread()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public RateAdjustment.RateAdjustmentBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			RateAdjustment.RateAdjustmentBuilder o = (RateAdjustment.RateAdjustmentBuilder) other;
			
			
			merger.mergeBasic(getMargin(), o.getMargin(), this::setMargin);
			merger.mergeBasic(getPikSpread(), o.getPikSpread(), this::setPikSpread);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			RateAdjustment _that = getType().cast(o);
		
			if (!Objects.equals(margin, _that.getMargin())) return false;
			if (!Objects.equals(pikSpread, _that.getPikSpread())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (margin != null ? margin.hashCode() : 0);
			_result = 31 * _result + (pikSpread != null ? pikSpread.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "RateAdjustmentBuilder {" +
				"margin=" + this.margin + ", " +
				"pikSpread=" + this.pikSpread +
			'}';
		}
	}
}

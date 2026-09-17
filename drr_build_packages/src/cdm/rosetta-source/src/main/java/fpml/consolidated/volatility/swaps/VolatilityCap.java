package fpml.consolidated.volatility.swaps;

import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.Accessor;
import com.rosetta.model.lib.annotations.AccessorType;
import com.rosetta.model.lib.annotations.RosettaAttribute;
import com.rosetta.model.lib.annotations.RosettaDataType;
import com.rosetta.model.lib.annotations.RuneAttribute;
import com.rosetta.model.lib.annotations.RuneDataType;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.process.BuilderMerger;
import com.rosetta.model.lib.process.BuilderProcessor;
import com.rosetta.model.lib.process.Processor;
import fpml.consolidated.volatility.swaps.meta.VolatilityCapMeta;
import java.math.BigDecimal;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "recordkeeping-5.13"
 *
 * Provision 
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision 
 *
 */
@RosettaDataType(value="VolatilityCap", builder=VolatilityCap.VolatilityCapBuilderImpl.class, version="2.1.1")
@RuneDataType(value="VolatilityCap", model="fpml", builder=VolatilityCap.VolatilityCapBuilderImpl.class, version="2.1.1")
public interface VolatilityCap extends RosettaModelObject {

	VolatilityCapMeta metaData = new VolatilityCapMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Indicates whether the volatility cap is applicable in accordance with the ISDA 2011 Equity Derivatives Definitions. Setting the element 'applicable' to 'False' - means No Volatility Cap and no 'totalVolatilityCap' or 'volatilityCapFactor' should be provided. Setting the element 'applicable' to 'True' - means Volatility Cap election, then 'totalVolatilityCap' or 'volatilityCapFactor' should be provided, otherwise it defaults to volatilityCapFactor=2.5.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Indicates whether the volatility cap is applicable in accordance with the ISDA 2011 Equity Derivatives Definitions. Setting the element 'applicable' to 'False' - means No Volatility Cap and no 'totalVolatilityCap' or 'volatilityCapFactor' should be provided. Setting the element 'applicable' to 'True' - means Volatility Cap election, then 'totalVolatilityCap' or 'volatilityCapFactor' should be provided, otherwise it defaults to volatilityCapFactor=2.5.
	 *
	 */
	Boolean getApplicable();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Volatility Cap Amount in accordance with the ISDA 2011 Equity Derivatives Definitions. This means the Volatility Cap Amount election is a number.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Volatility Cap Amount in accordance with the ISDA 2011 Equity Derivatives Definitions. This means the Volatility Cap Amount election is a number.
	 *
	 */
	BigDecimal getTotalVolatilityCap();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Volatility Cap Factor in accordance with the ISDA 2011 Equity Derivatives Definitions. This means the Volatility Cap Amount election is Calculated VolCapAmt ('volatilityCapFactor' * 'volatilityStrikePrice'). By specifying a decimal for 'volatilityCapFactor', means the default value of 2.5 does not apply.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Volatility Cap Factor in accordance with the ISDA 2011 Equity Derivatives Definitions. This means the Volatility Cap Amount election is Calculated VolCapAmt ('volatilityCapFactor' * 'volatilityStrikePrice'). By specifying a decimal for 'volatilityCapFactor', means the default value of 2.5 does not apply.
	 *
	 */
	BigDecimal getVolatilityCapFactor();

	/*********************** Build Methods  ***********************/
	VolatilityCap build();
	
	VolatilityCap.VolatilityCapBuilder toBuilder();
	
	static VolatilityCap.VolatilityCapBuilder builder() {
		return new VolatilityCap.VolatilityCapBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends VolatilityCap> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends VolatilityCap> getType() {
		return VolatilityCap.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("applicable"), Boolean.class, getApplicable(), this);
		processor.processBasic(path.newSubPath("totalVolatilityCap"), BigDecimal.class, getTotalVolatilityCap(), this);
		processor.processBasic(path.newSubPath("volatilityCapFactor"), BigDecimal.class, getVolatilityCapFactor(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface VolatilityCapBuilder extends VolatilityCap, RosettaModelObjectBuilder {
		VolatilityCap.VolatilityCapBuilder setApplicable(Boolean applicable);
		VolatilityCap.VolatilityCapBuilder setTotalVolatilityCap(BigDecimal totalVolatilityCap);
		VolatilityCap.VolatilityCapBuilder setVolatilityCapFactor(BigDecimal volatilityCapFactor);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("applicable"), Boolean.class, getApplicable(), this);
			processor.processBasic(path.newSubPath("totalVolatilityCap"), BigDecimal.class, getTotalVolatilityCap(), this);
			processor.processBasic(path.newSubPath("volatilityCapFactor"), BigDecimal.class, getVolatilityCapFactor(), this);
		}
		

		VolatilityCap.VolatilityCapBuilder prune();
	}

	/*********************** Immutable Implementation of VolatilityCap  ***********************/
	class VolatilityCapImpl implements VolatilityCap {
		private final Boolean applicable;
		private final BigDecimal totalVolatilityCap;
		private final BigDecimal volatilityCapFactor;
		
		protected VolatilityCapImpl(VolatilityCap.VolatilityCapBuilder builder) {
			this.applicable = builder.getApplicable();
			this.totalVolatilityCap = builder.getTotalVolatilityCap();
			this.volatilityCapFactor = builder.getVolatilityCapFactor();
		}
		
		@Override
		@RosettaAttribute("applicable")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("applicable")
		public Boolean getApplicable() {
			return applicable;
		}
		
		@Override
		@RosettaAttribute("totalVolatilityCap")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("totalVolatilityCap")
		public BigDecimal getTotalVolatilityCap() {
			return totalVolatilityCap;
		}
		
		@Override
		@RosettaAttribute("volatilityCapFactor")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("volatilityCapFactor")
		public BigDecimal getVolatilityCapFactor() {
			return volatilityCapFactor;
		}
		
		@Override
		public VolatilityCap build() {
			return this;
		}
		
		@Override
		public VolatilityCap.VolatilityCapBuilder toBuilder() {
			VolatilityCap.VolatilityCapBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(VolatilityCap.VolatilityCapBuilder builder) {
			ofNullable(getApplicable()).ifPresent(builder::setApplicable);
			ofNullable(getTotalVolatilityCap()).ifPresent(builder::setTotalVolatilityCap);
			ofNullable(getVolatilityCapFactor()).ifPresent(builder::setVolatilityCapFactor);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			VolatilityCap _that = getType().cast(o);
		
			if (!Objects.equals(applicable, _that.getApplicable())) return false;
			if (!Objects.equals(totalVolatilityCap, _that.getTotalVolatilityCap())) return false;
			if (!Objects.equals(volatilityCapFactor, _that.getVolatilityCapFactor())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (applicable != null ? applicable.hashCode() : 0);
			_result = 31 * _result + (totalVolatilityCap != null ? totalVolatilityCap.hashCode() : 0);
			_result = 31 * _result + (volatilityCapFactor != null ? volatilityCapFactor.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "VolatilityCap {" +
				"applicable=" + this.applicable + ", " +
				"totalVolatilityCap=" + this.totalVolatilityCap + ", " +
				"volatilityCapFactor=" + this.volatilityCapFactor +
			'}';
		}
	}

	/*********************** Builder Implementation of VolatilityCap  ***********************/
	class VolatilityCapBuilderImpl implements VolatilityCap.VolatilityCapBuilder {
	
		protected Boolean applicable;
		protected BigDecimal totalVolatilityCap;
		protected BigDecimal volatilityCapFactor;
		
		@Override
		@RosettaAttribute("applicable")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("applicable")
		public Boolean getApplicable() {
			return applicable;
		}
		
		@Override
		@RosettaAttribute("totalVolatilityCap")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("totalVolatilityCap")
		public BigDecimal getTotalVolatilityCap() {
			return totalVolatilityCap;
		}
		
		@Override
		@RosettaAttribute("volatilityCapFactor")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("volatilityCapFactor")
		public BigDecimal getVolatilityCapFactor() {
			return volatilityCapFactor;
		}
		
		@RosettaAttribute("applicable")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("applicable")
		@Override
		public VolatilityCap.VolatilityCapBuilder setApplicable(Boolean _applicable) {
			this.applicable = _applicable == null ? null : _applicable;
			return this;
		}
		
		@RosettaAttribute("totalVolatilityCap")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("totalVolatilityCap")
		@Override
		public VolatilityCap.VolatilityCapBuilder setTotalVolatilityCap(BigDecimal _totalVolatilityCap) {
			this.totalVolatilityCap = _totalVolatilityCap == null ? null : _totalVolatilityCap;
			return this;
		}
		
		@RosettaAttribute("volatilityCapFactor")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("volatilityCapFactor")
		@Override
		public VolatilityCap.VolatilityCapBuilder setVolatilityCapFactor(BigDecimal _volatilityCapFactor) {
			this.volatilityCapFactor = _volatilityCapFactor == null ? null : _volatilityCapFactor;
			return this;
		}
		
		@Override
		public VolatilityCap build() {
			return new VolatilityCap.VolatilityCapImpl(this);
		}
		
		@Override
		public VolatilityCap.VolatilityCapBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public VolatilityCap.VolatilityCapBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getApplicable()!=null) return true;
			if (getTotalVolatilityCap()!=null) return true;
			if (getVolatilityCapFactor()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public VolatilityCap.VolatilityCapBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			VolatilityCap.VolatilityCapBuilder o = (VolatilityCap.VolatilityCapBuilder) other;
			
			
			merger.mergeBasic(getApplicable(), o.getApplicable(), this::setApplicable);
			merger.mergeBasic(getTotalVolatilityCap(), o.getTotalVolatilityCap(), this::setTotalVolatilityCap);
			merger.mergeBasic(getVolatilityCapFactor(), o.getVolatilityCapFactor(), this::setVolatilityCapFactor);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			VolatilityCap _that = getType().cast(o);
		
			if (!Objects.equals(applicable, _that.getApplicable())) return false;
			if (!Objects.equals(totalVolatilityCap, _that.getTotalVolatilityCap())) return false;
			if (!Objects.equals(volatilityCapFactor, _that.getVolatilityCapFactor())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (applicable != null ? applicable.hashCode() : 0);
			_result = 31 * _result + (totalVolatilityCap != null ? totalVolatilityCap.hashCode() : 0);
			_result = 31 * _result + (volatilityCapFactor != null ? volatilityCapFactor.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "VolatilityCapBuilder {" +
				"applicable=" + this.applicable + ", " +
				"totalVolatilityCap=" + this.totalVolatilityCap + ", " +
				"volatilityCapFactor=" + this.volatilityCapFactor +
			'}';
		}
	}
}

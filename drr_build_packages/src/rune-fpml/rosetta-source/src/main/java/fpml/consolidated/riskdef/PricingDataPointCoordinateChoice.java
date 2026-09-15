package fpml.consolidated.riskdef;

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
import fpml.consolidated.riskdef.meta.PricingDataPointCoordinateChoiceMeta;
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
@RosettaDataType(value="PricingDataPointCoordinateChoice", builder=PricingDataPointCoordinateChoice.PricingDataPointCoordinateChoiceBuilderImpl.class, version="2.1.1")
@RuneDataType(value="PricingDataPointCoordinateChoice", model="fpml", builder=PricingDataPointCoordinateChoice.PricingDataPointCoordinateChoiceBuilderImpl.class, version="2.1.1")
public interface PricingDataPointCoordinateChoice extends RosettaModelObject {

	PricingDataPointCoordinateChoiceMeta metaData = new PricingDataPointCoordinateChoiceMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision A time dimension that represents the term of a financial instrument, e.g. of a zero-coupon bond on a curve, or of an underlying caplet or swap for an option.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A time dimension that represents the term of a financial instrument, e.g. of a zero-coupon bond on a curve, or of an underlying caplet or swap for an option.
	 *
	 */
	TimeDimension getTerm();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision A time dimension that represents the time to expiration of an option.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A time dimension that represents the time to expiration of an option.
	 *
	 */
	TimeDimension getExpiration();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision A numerical dimension that represents the strike rate or price of an option.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A numerical dimension that represents the strike rate or price of an option.
	 *
	 */
	BigDecimal getStrike();
	/**
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
	GenericDimension getGeneric();

	/*********************** Build Methods  ***********************/
	PricingDataPointCoordinateChoice build();
	
	PricingDataPointCoordinateChoice.PricingDataPointCoordinateChoiceBuilder toBuilder();
	
	static PricingDataPointCoordinateChoice.PricingDataPointCoordinateChoiceBuilder builder() {
		return new PricingDataPointCoordinateChoice.PricingDataPointCoordinateChoiceBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends PricingDataPointCoordinateChoice> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends PricingDataPointCoordinateChoice> getType() {
		return PricingDataPointCoordinateChoice.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("term"), processor, TimeDimension.class, getTerm());
		processRosetta(path.newSubPath("expiration"), processor, TimeDimension.class, getExpiration());
		processor.processBasic(path.newSubPath("strike"), BigDecimal.class, getStrike(), this);
		processRosetta(path.newSubPath("generic"), processor, GenericDimension.class, getGeneric());
	}
	

	/*********************** Builder Interface  ***********************/
	interface PricingDataPointCoordinateChoiceBuilder extends PricingDataPointCoordinateChoice, RosettaModelObjectBuilder {
		TimeDimension.TimeDimensionBuilder getOrCreateTerm();
		@Override
		TimeDimension.TimeDimensionBuilder getTerm();
		TimeDimension.TimeDimensionBuilder getOrCreateExpiration();
		@Override
		TimeDimension.TimeDimensionBuilder getExpiration();
		GenericDimension.GenericDimensionBuilder getOrCreateGeneric();
		@Override
		GenericDimension.GenericDimensionBuilder getGeneric();
		PricingDataPointCoordinateChoice.PricingDataPointCoordinateChoiceBuilder setTerm(TimeDimension term);
		PricingDataPointCoordinateChoice.PricingDataPointCoordinateChoiceBuilder setExpiration(TimeDimension expiration);
		PricingDataPointCoordinateChoice.PricingDataPointCoordinateChoiceBuilder setStrike(BigDecimal strike);
		PricingDataPointCoordinateChoice.PricingDataPointCoordinateChoiceBuilder setGeneric(GenericDimension generic);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("term"), processor, TimeDimension.TimeDimensionBuilder.class, getTerm());
			processRosetta(path.newSubPath("expiration"), processor, TimeDimension.TimeDimensionBuilder.class, getExpiration());
			processor.processBasic(path.newSubPath("strike"), BigDecimal.class, getStrike(), this);
			processRosetta(path.newSubPath("generic"), processor, GenericDimension.GenericDimensionBuilder.class, getGeneric());
		}
		

		PricingDataPointCoordinateChoice.PricingDataPointCoordinateChoiceBuilder prune();
	}

	/*********************** Immutable Implementation of PricingDataPointCoordinateChoice  ***********************/
	class PricingDataPointCoordinateChoiceImpl implements PricingDataPointCoordinateChoice {
		private final TimeDimension term;
		private final TimeDimension expiration;
		private final BigDecimal strike;
		private final GenericDimension generic;
		
		protected PricingDataPointCoordinateChoiceImpl(PricingDataPointCoordinateChoice.PricingDataPointCoordinateChoiceBuilder builder) {
			this.term = ofNullable(builder.getTerm()).map(f->f.build()).orElse(null);
			this.expiration = ofNullable(builder.getExpiration()).map(f->f.build()).orElse(null);
			this.strike = builder.getStrike();
			this.generic = ofNullable(builder.getGeneric()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("term")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("term")
		public TimeDimension getTerm() {
			return term;
		}
		
		@Override
		@RosettaAttribute("expiration")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("expiration")
		public TimeDimension getExpiration() {
			return expiration;
		}
		
		@Override
		@RosettaAttribute("strike")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("strike")
		public BigDecimal getStrike() {
			return strike;
		}
		
		@Override
		@RosettaAttribute("generic")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("generic")
		public GenericDimension getGeneric() {
			return generic;
		}
		
		@Override
		public PricingDataPointCoordinateChoice build() {
			return this;
		}
		
		@Override
		public PricingDataPointCoordinateChoice.PricingDataPointCoordinateChoiceBuilder toBuilder() {
			PricingDataPointCoordinateChoice.PricingDataPointCoordinateChoiceBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(PricingDataPointCoordinateChoice.PricingDataPointCoordinateChoiceBuilder builder) {
			ofNullable(getTerm()).ifPresent(builder::setTerm);
			ofNullable(getExpiration()).ifPresent(builder::setExpiration);
			ofNullable(getStrike()).ifPresent(builder::setStrike);
			ofNullable(getGeneric()).ifPresent(builder::setGeneric);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			PricingDataPointCoordinateChoice _that = getType().cast(o);
		
			if (!Objects.equals(term, _that.getTerm())) return false;
			if (!Objects.equals(expiration, _that.getExpiration())) return false;
			if (!Objects.equals(strike, _that.getStrike())) return false;
			if (!Objects.equals(generic, _that.getGeneric())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (term != null ? term.hashCode() : 0);
			_result = 31 * _result + (expiration != null ? expiration.hashCode() : 0);
			_result = 31 * _result + (strike != null ? strike.hashCode() : 0);
			_result = 31 * _result + (generic != null ? generic.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "PricingDataPointCoordinateChoice {" +
				"term=" + this.term + ", " +
				"expiration=" + this.expiration + ", " +
				"strike=" + this.strike + ", " +
				"generic=" + this.generic +
			'}';
		}
	}

	/*********************** Builder Implementation of PricingDataPointCoordinateChoice  ***********************/
	class PricingDataPointCoordinateChoiceBuilderImpl implements PricingDataPointCoordinateChoice.PricingDataPointCoordinateChoiceBuilder {
	
		protected TimeDimension.TimeDimensionBuilder term;
		protected TimeDimension.TimeDimensionBuilder expiration;
		protected BigDecimal strike;
		protected GenericDimension.GenericDimensionBuilder generic;
		
		@Override
		@RosettaAttribute("term")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("term")
		public TimeDimension.TimeDimensionBuilder getTerm() {
			return term;
		}
		
		@Override
		public TimeDimension.TimeDimensionBuilder getOrCreateTerm() {
			TimeDimension.TimeDimensionBuilder result;
			if (term!=null) {
				result = term;
			}
			else {
				result = term = TimeDimension.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("expiration")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("expiration")
		public TimeDimension.TimeDimensionBuilder getExpiration() {
			return expiration;
		}
		
		@Override
		public TimeDimension.TimeDimensionBuilder getOrCreateExpiration() {
			TimeDimension.TimeDimensionBuilder result;
			if (expiration!=null) {
				result = expiration;
			}
			else {
				result = expiration = TimeDimension.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("strike")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("strike")
		public BigDecimal getStrike() {
			return strike;
		}
		
		@Override
		@RosettaAttribute("generic")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("generic")
		public GenericDimension.GenericDimensionBuilder getGeneric() {
			return generic;
		}
		
		@Override
		public GenericDimension.GenericDimensionBuilder getOrCreateGeneric() {
			GenericDimension.GenericDimensionBuilder result;
			if (generic!=null) {
				result = generic;
			}
			else {
				result = generic = GenericDimension.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("term")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("term")
		@Override
		public PricingDataPointCoordinateChoice.PricingDataPointCoordinateChoiceBuilder setTerm(TimeDimension _term) {
			this.term = _term == null ? null : _term.toBuilder();
			return this;
		}
		
		@RosettaAttribute("expiration")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("expiration")
		@Override
		public PricingDataPointCoordinateChoice.PricingDataPointCoordinateChoiceBuilder setExpiration(TimeDimension _expiration) {
			this.expiration = _expiration == null ? null : _expiration.toBuilder();
			return this;
		}
		
		@RosettaAttribute("strike")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("strike")
		@Override
		public PricingDataPointCoordinateChoice.PricingDataPointCoordinateChoiceBuilder setStrike(BigDecimal _strike) {
			this.strike = _strike == null ? null : _strike;
			return this;
		}
		
		@RosettaAttribute("generic")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("generic")
		@Override
		public PricingDataPointCoordinateChoice.PricingDataPointCoordinateChoiceBuilder setGeneric(GenericDimension _generic) {
			this.generic = _generic == null ? null : _generic.toBuilder();
			return this;
		}
		
		@Override
		public PricingDataPointCoordinateChoice build() {
			return new PricingDataPointCoordinateChoice.PricingDataPointCoordinateChoiceImpl(this);
		}
		
		@Override
		public PricingDataPointCoordinateChoice.PricingDataPointCoordinateChoiceBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public PricingDataPointCoordinateChoice.PricingDataPointCoordinateChoiceBuilder prune() {
			if (term!=null && !term.prune().hasData()) term = null;
			if (expiration!=null && !expiration.prune().hasData()) expiration = null;
			if (generic!=null && !generic.prune().hasData()) generic = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getTerm()!=null && getTerm().hasData()) return true;
			if (getExpiration()!=null && getExpiration().hasData()) return true;
			if (getStrike()!=null) return true;
			if (getGeneric()!=null && getGeneric().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public PricingDataPointCoordinateChoice.PricingDataPointCoordinateChoiceBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			PricingDataPointCoordinateChoice.PricingDataPointCoordinateChoiceBuilder o = (PricingDataPointCoordinateChoice.PricingDataPointCoordinateChoiceBuilder) other;
			
			merger.mergeRosetta(getTerm(), o.getTerm(), this::setTerm);
			merger.mergeRosetta(getExpiration(), o.getExpiration(), this::setExpiration);
			merger.mergeRosetta(getGeneric(), o.getGeneric(), this::setGeneric);
			
			merger.mergeBasic(getStrike(), o.getStrike(), this::setStrike);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			PricingDataPointCoordinateChoice _that = getType().cast(o);
		
			if (!Objects.equals(term, _that.getTerm())) return false;
			if (!Objects.equals(expiration, _that.getExpiration())) return false;
			if (!Objects.equals(strike, _that.getStrike())) return false;
			if (!Objects.equals(generic, _that.getGeneric())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (term != null ? term.hashCode() : 0);
			_result = 31 * _result + (expiration != null ? expiration.hashCode() : 0);
			_result = 31 * _result + (strike != null ? strike.hashCode() : 0);
			_result = 31 * _result + (generic != null ? generic.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "PricingDataPointCoordinateChoiceBuilder {" +
				"term=" + this.term + ", " +
				"expiration=" + this.expiration + ", " +
				"strike=" + this.strike + ", " +
				"generic=" + this.generic +
			'}';
		}
	}
}

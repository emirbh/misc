package fpml.consolidated.ird;

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
import fpml.consolidated.fpmlenum.DiscountingTypeEnum;
import fpml.consolidated.ird.meta.DiscountingMeta;
import fpml.consolidated.shared.DayCountFraction;
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
 * Provision A type defining discounting information. The 2000 ISDA definitions, section 8.4. discounting (related to the calculation of a discounted fixed amount or floating amount) apply. This type must only be included if discounting applies.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision A type defining discounting information. The 2000 ISDA definitions, section 8.4. discounting (related to the calculation of a discounted fixed amount or floating amount) apply. This type must only be included if discounting applies.
 *
 */
@RosettaDataType(value="Discounting", builder=Discounting.DiscountingBuilderImpl.class, version="2.1.1")
@RuneDataType(value="Discounting", model="fpml", builder=Discounting.DiscountingBuilderImpl.class, version="2.1.1")
public interface Discounting extends RosettaModelObject {

	DiscountingMeta metaData = new DiscountingMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The discounting method that is applicable.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The discounting method that is applicable.
	 *
	 */
	DiscountingTypeEnum getDiscountingType();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision A discount rate, expressed as a decimal, to be used in the calculation of a discounted amount. A discount amount of 5% would be represented as 0.05.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A discount rate, expressed as a decimal, to be used in the calculation of a discounted amount. A discount amount of 5% would be represented as 0.05.
	 *
	 */
	BigDecimal getDiscountRate();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision A discount day count fraction to be used in the calculation of a discounted amount.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A discount day count fraction to be used in the calculation of a discounted amount.
	 *
	 */
	DayCountFraction getDiscountRateDayCountFraction();

	/*********************** Build Methods  ***********************/
	Discounting build();
	
	Discounting.DiscountingBuilder toBuilder();
	
	static Discounting.DiscountingBuilder builder() {
		return new Discounting.DiscountingBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends Discounting> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends Discounting> getType() {
		return Discounting.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("discountingType"), DiscountingTypeEnum.class, getDiscountingType(), this);
		processor.processBasic(path.newSubPath("discountRate"), BigDecimal.class, getDiscountRate(), this);
		processRosetta(path.newSubPath("discountRateDayCountFraction"), processor, DayCountFraction.class, getDiscountRateDayCountFraction());
	}
	

	/*********************** Builder Interface  ***********************/
	interface DiscountingBuilder extends Discounting, RosettaModelObjectBuilder {
		DayCountFraction.DayCountFractionBuilder getOrCreateDiscountRateDayCountFraction();
		@Override
		DayCountFraction.DayCountFractionBuilder getDiscountRateDayCountFraction();
		Discounting.DiscountingBuilder setDiscountingType(DiscountingTypeEnum discountingType);
		Discounting.DiscountingBuilder setDiscountRate(BigDecimal discountRate);
		Discounting.DiscountingBuilder setDiscountRateDayCountFraction(DayCountFraction discountRateDayCountFraction);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("discountingType"), DiscountingTypeEnum.class, getDiscountingType(), this);
			processor.processBasic(path.newSubPath("discountRate"), BigDecimal.class, getDiscountRate(), this);
			processRosetta(path.newSubPath("discountRateDayCountFraction"), processor, DayCountFraction.DayCountFractionBuilder.class, getDiscountRateDayCountFraction());
		}
		

		Discounting.DiscountingBuilder prune();
	}

	/*********************** Immutable Implementation of Discounting  ***********************/
	class DiscountingImpl implements Discounting {
		private final DiscountingTypeEnum discountingType;
		private final BigDecimal discountRate;
		private final DayCountFraction discountRateDayCountFraction;
		
		protected DiscountingImpl(Discounting.DiscountingBuilder builder) {
			this.discountingType = builder.getDiscountingType();
			this.discountRate = builder.getDiscountRate();
			this.discountRateDayCountFraction = ofNullable(builder.getDiscountRateDayCountFraction()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("discountingType")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("discountingType")
		public DiscountingTypeEnum getDiscountingType() {
			return discountingType;
		}
		
		@Override
		@RosettaAttribute("discountRate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("discountRate")
		public BigDecimal getDiscountRate() {
			return discountRate;
		}
		
		@Override
		@RosettaAttribute("discountRateDayCountFraction")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("discountRateDayCountFraction")
		public DayCountFraction getDiscountRateDayCountFraction() {
			return discountRateDayCountFraction;
		}
		
		@Override
		public Discounting build() {
			return this;
		}
		
		@Override
		public Discounting.DiscountingBuilder toBuilder() {
			Discounting.DiscountingBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(Discounting.DiscountingBuilder builder) {
			ofNullable(getDiscountingType()).ifPresent(builder::setDiscountingType);
			ofNullable(getDiscountRate()).ifPresent(builder::setDiscountRate);
			ofNullable(getDiscountRateDayCountFraction()).ifPresent(builder::setDiscountRateDayCountFraction);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			Discounting _that = getType().cast(o);
		
			if (!Objects.equals(discountingType, _that.getDiscountingType())) return false;
			if (!Objects.equals(discountRate, _that.getDiscountRate())) return false;
			if (!Objects.equals(discountRateDayCountFraction, _that.getDiscountRateDayCountFraction())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (discountingType != null ? discountingType.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (discountRate != null ? discountRate.hashCode() : 0);
			_result = 31 * _result + (discountRateDayCountFraction != null ? discountRateDayCountFraction.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "Discounting {" +
				"discountingType=" + this.discountingType + ", " +
				"discountRate=" + this.discountRate + ", " +
				"discountRateDayCountFraction=" + this.discountRateDayCountFraction +
			'}';
		}
	}

	/*********************** Builder Implementation of Discounting  ***********************/
	class DiscountingBuilderImpl implements Discounting.DiscountingBuilder {
	
		protected DiscountingTypeEnum discountingType;
		protected BigDecimal discountRate;
		protected DayCountFraction.DayCountFractionBuilder discountRateDayCountFraction;
		
		@Override
		@RosettaAttribute("discountingType")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("discountingType")
		public DiscountingTypeEnum getDiscountingType() {
			return discountingType;
		}
		
		@Override
		@RosettaAttribute("discountRate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("discountRate")
		public BigDecimal getDiscountRate() {
			return discountRate;
		}
		
		@Override
		@RosettaAttribute("discountRateDayCountFraction")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("discountRateDayCountFraction")
		public DayCountFraction.DayCountFractionBuilder getDiscountRateDayCountFraction() {
			return discountRateDayCountFraction;
		}
		
		@Override
		public DayCountFraction.DayCountFractionBuilder getOrCreateDiscountRateDayCountFraction() {
			DayCountFraction.DayCountFractionBuilder result;
			if (discountRateDayCountFraction!=null) {
				result = discountRateDayCountFraction;
			}
			else {
				result = discountRateDayCountFraction = DayCountFraction.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("discountingType")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("discountingType")
		@Override
		public Discounting.DiscountingBuilder setDiscountingType(DiscountingTypeEnum _discountingType) {
			this.discountingType = _discountingType == null ? null : _discountingType;
			return this;
		}
		
		@RosettaAttribute("discountRate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("discountRate")
		@Override
		public Discounting.DiscountingBuilder setDiscountRate(BigDecimal _discountRate) {
			this.discountRate = _discountRate == null ? null : _discountRate;
			return this;
		}
		
		@RosettaAttribute("discountRateDayCountFraction")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("discountRateDayCountFraction")
		@Override
		public Discounting.DiscountingBuilder setDiscountRateDayCountFraction(DayCountFraction _discountRateDayCountFraction) {
			this.discountRateDayCountFraction = _discountRateDayCountFraction == null ? null : _discountRateDayCountFraction.toBuilder();
			return this;
		}
		
		@Override
		public Discounting build() {
			return new Discounting.DiscountingImpl(this);
		}
		
		@Override
		public Discounting.DiscountingBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Discounting.DiscountingBuilder prune() {
			if (discountRateDayCountFraction!=null && !discountRateDayCountFraction.prune().hasData()) discountRateDayCountFraction = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getDiscountingType()!=null) return true;
			if (getDiscountRate()!=null) return true;
			if (getDiscountRateDayCountFraction()!=null && getDiscountRateDayCountFraction().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Discounting.DiscountingBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			Discounting.DiscountingBuilder o = (Discounting.DiscountingBuilder) other;
			
			merger.mergeRosetta(getDiscountRateDayCountFraction(), o.getDiscountRateDayCountFraction(), this::setDiscountRateDayCountFraction);
			
			merger.mergeBasic(getDiscountingType(), o.getDiscountingType(), this::setDiscountingType);
			merger.mergeBasic(getDiscountRate(), o.getDiscountRate(), this::setDiscountRate);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			Discounting _that = getType().cast(o);
		
			if (!Objects.equals(discountingType, _that.getDiscountingType())) return false;
			if (!Objects.equals(discountRate, _that.getDiscountRate())) return false;
			if (!Objects.equals(discountRateDayCountFraction, _that.getDiscountRateDayCountFraction())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (discountingType != null ? discountingType.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (discountRate != null ? discountRate.hashCode() : 0);
			_result = 31 * _result + (discountRateDayCountFraction != null ? discountRateDayCountFraction.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "DiscountingBuilder {" +
				"discountingType=" + this.discountingType + ", " +
				"discountRate=" + this.discountRate + ", " +
				"discountRateDayCountFraction=" + this.discountRateDayCountFraction +
			'}';
		}
	}
}

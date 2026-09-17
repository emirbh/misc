package fpml.consolidated.generic;

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
import fpml.consolidated.eq.shared.EquityStrike;
import fpml.consolidated.generic.meta.GenericOptionStrikeMeta;
import fpml.consolidated.shared.AdjustableOrRelativeDate;
import fpml.consolidated.shared.Currency;
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
@RosettaDataType(value="GenericOptionStrike", builder=GenericOptionStrike.GenericOptionStrikeBuilderImpl.class, version="2.1.1")
@RuneDataType(value="GenericOptionStrike", model="fpml", builder=GenericOptionStrike.GenericOptionStrikeBuilderImpl.class, version="2.1.1")
public interface GenericOptionStrike extends EquityStrike {

	GenericOptionStrikeMeta metaData = new GenericOptionStrikeMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The units in which an amount (not monetary) is denominated.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The units in which an amount (not monetary) is denominated.
	 *
	 */
	String getUnits();

	/*********************** Build Methods  ***********************/
	GenericOptionStrike build();
	
	GenericOptionStrike.GenericOptionStrikeBuilder toBuilder();
	
	static GenericOptionStrike.GenericOptionStrikeBuilder builder() {
		return new GenericOptionStrike.GenericOptionStrikeBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends GenericOptionStrike> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends GenericOptionStrike> getType() {
		return GenericOptionStrike.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("strikePrice"), BigDecimal.class, getStrikePrice(), this);
		processor.processBasic(path.newSubPath("strikePercentage"), BigDecimal.class, getStrikePercentage(), this);
		processRosetta(path.newSubPath("strikeDeterminationDate"), processor, AdjustableOrRelativeDate.class, getStrikeDeterminationDate());
		processRosetta(path.newSubPath("currency"), processor, Currency.class, getCurrency());
		processor.processBasic(path.newSubPath("units"), String.class, getUnits(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface GenericOptionStrikeBuilder extends GenericOptionStrike, EquityStrike.EquityStrikeBuilder {
		@Override
		GenericOptionStrike.GenericOptionStrikeBuilder setStrikePrice(BigDecimal strikePrice);
		@Override
		GenericOptionStrike.GenericOptionStrikeBuilder setStrikePercentage(BigDecimal strikePercentage);
		@Override
		GenericOptionStrike.GenericOptionStrikeBuilder setStrikeDeterminationDate(AdjustableOrRelativeDate strikeDeterminationDate);
		@Override
		GenericOptionStrike.GenericOptionStrikeBuilder setCurrency(Currency currency);
		GenericOptionStrike.GenericOptionStrikeBuilder setUnits(String units);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("strikePrice"), BigDecimal.class, getStrikePrice(), this);
			processor.processBasic(path.newSubPath("strikePercentage"), BigDecimal.class, getStrikePercentage(), this);
			processRosetta(path.newSubPath("strikeDeterminationDate"), processor, AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder.class, getStrikeDeterminationDate());
			processRosetta(path.newSubPath("currency"), processor, Currency.CurrencyBuilder.class, getCurrency());
			processor.processBasic(path.newSubPath("units"), String.class, getUnits(), this);
		}
		

		GenericOptionStrike.GenericOptionStrikeBuilder prune();
	}

	/*********************** Immutable Implementation of GenericOptionStrike  ***********************/
	class GenericOptionStrikeImpl extends EquityStrike.EquityStrikeImpl implements GenericOptionStrike {
		private final String units;
		
		protected GenericOptionStrikeImpl(GenericOptionStrike.GenericOptionStrikeBuilder builder) {
			super(builder);
			this.units = builder.getUnits();
		}
		
		@Override
		@RosettaAttribute("units")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("units")
		public String getUnits() {
			return units;
		}
		
		@Override
		public GenericOptionStrike build() {
			return this;
		}
		
		@Override
		public GenericOptionStrike.GenericOptionStrikeBuilder toBuilder() {
			GenericOptionStrike.GenericOptionStrikeBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(GenericOptionStrike.GenericOptionStrikeBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getUnits()).ifPresent(builder::setUnits);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			GenericOptionStrike _that = getType().cast(o);
		
			if (!Objects.equals(units, _that.getUnits())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (units != null ? units.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "GenericOptionStrike {" +
				"units=" + this.units +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of GenericOptionStrike  ***********************/
	class GenericOptionStrikeBuilderImpl extends EquityStrike.EquityStrikeBuilderImpl implements GenericOptionStrike.GenericOptionStrikeBuilder {
	
		protected String units;
		
		@Override
		@RosettaAttribute("units")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("units")
		public String getUnits() {
			return units;
		}
		
		@RosettaAttribute("strikePrice")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("strikePrice")
		@Override
		public GenericOptionStrike.GenericOptionStrikeBuilder setStrikePrice(BigDecimal _strikePrice) {
			this.strikePrice = _strikePrice == null ? null : _strikePrice;
			return this;
		}
		
		@RosettaAttribute("strikePercentage")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("strikePercentage")
		@Override
		public GenericOptionStrike.GenericOptionStrikeBuilder setStrikePercentage(BigDecimal _strikePercentage) {
			this.strikePercentage = _strikePercentage == null ? null : _strikePercentage;
			return this;
		}
		
		@RosettaAttribute("strikeDeterminationDate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("strikeDeterminationDate")
		@Override
		public GenericOptionStrike.GenericOptionStrikeBuilder setStrikeDeterminationDate(AdjustableOrRelativeDate _strikeDeterminationDate) {
			this.strikeDeterminationDate = _strikeDeterminationDate == null ? null : _strikeDeterminationDate.toBuilder();
			return this;
		}
		
		@RosettaAttribute("currency")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("currency")
		@Override
		public GenericOptionStrike.GenericOptionStrikeBuilder setCurrency(Currency _currency) {
			this.currency = _currency == null ? null : _currency.toBuilder();
			return this;
		}
		
		@RosettaAttribute("units")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("units")
		@Override
		public GenericOptionStrike.GenericOptionStrikeBuilder setUnits(String _units) {
			this.units = _units == null ? null : _units;
			return this;
		}
		
		@Override
		public GenericOptionStrike build() {
			return new GenericOptionStrike.GenericOptionStrikeImpl(this);
		}
		
		@Override
		public GenericOptionStrike.GenericOptionStrikeBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public GenericOptionStrike.GenericOptionStrikeBuilder prune() {
			super.prune();
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getUnits()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public GenericOptionStrike.GenericOptionStrikeBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			GenericOptionStrike.GenericOptionStrikeBuilder o = (GenericOptionStrike.GenericOptionStrikeBuilder) other;
			
			
			merger.mergeBasic(getUnits(), o.getUnits(), this::setUnits);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			GenericOptionStrike _that = getType().cast(o);
		
			if (!Objects.equals(units, _that.getUnits())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (units != null ? units.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "GenericOptionStrikeBuilder {" +
				"units=" + this.units +
			'}' + " " + super.toString();
		}
	}
}

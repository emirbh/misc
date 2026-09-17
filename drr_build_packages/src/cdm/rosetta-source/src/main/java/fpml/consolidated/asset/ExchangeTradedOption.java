package fpml.consolidated.asset;

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
import fpml.consolidated.asset.meta.ExchangeTradedOptionMeta;
import fpml.consolidated.fpmlenum.ExerciseStyleEnum;
import fpml.consolidated.fpmlenum.PutCallEnum;
import fpml.consolidated.fpmlenum.SettlementTypeEnum;
import fpml.consolidated.shared.AdjustableOrRelativeDate;
import fpml.consolidated.shared.ClearanceSystem;
import fpml.consolidated.shared.Currency;
import fpml.consolidated.shared.ExchangeId;
import fpml.consolidated.shared.IdentifiedCurrency;
import fpml.consolidated.shared.InstrumentId;
import fpml.consolidated.shared.ProductReference;
import java.math.BigDecimal;
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
 * version "recordkeeping-5.13"
 *
 * Provision An exchange traded option.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision An exchange traded option.
 *
 */
@RosettaDataType(value="ExchangeTradedOption", builder=ExchangeTradedOption.ExchangeTradedOptionBuilderImpl.class, version="2.1.1")
@RuneDataType(value="ExchangeTradedOption", model="fpml", builder=ExchangeTradedOption.ExchangeTradedOptionBuilderImpl.class, version="2.1.1")
public interface ExchangeTradedOption extends ExchangeTradedContract {

	ExchangeTradedOptionMeta metaData = new ExchangeTradedOptionMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Specifies the price at which the option can be exercised.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Specifies the price at which the option can be exercised.
	 *
	 */
	BigDecimal getStrike();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The currency in which the strike of the option is expressed.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The currency in which the strike of the option is expressed.
	 *
	 */
	Currency getStrikeCurrency();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Units in which the option strike is expressed e.g. currency Amount, BasisPoints, Percentage, Rate. Reportable reference data under MiFID RTS 22
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Units in which the option strike is expressed e.g. currency Amount, BasisPoints, Percentage, Rate. Reportable reference data under MiFID RTS 22
	 *
	 */
	PriceQuoteUnits getStrikeUnits();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Specifies whether the option allows the holder to buy or sell tne underlying asset.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Specifies whether the option allows the holder to buy or sell tne underlying asset.
	 *
	 */
	PutCallEnum getOptionType();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Specifies the exercise style of the option {American, Bermuda, European}
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Specifies the exercise style of the option {American, Bermuda, European}
	 *
	 */
	ExerciseStyleEnum getExerciseStyle();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Underlyer of the option e.g. a listed future.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Underlyer of the option e.g. a listed future.
	 *
	 */
	ExchangeTradedContractUnderlyer getUnderlyer();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Settlement method for the contract (Cash, Physical). This value is used to populate the "Delivery Type" field for regulatory reporting (CFTC, ESMA).
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Settlement method for the contract (Cash, Physical). This value is used to populate the "Delivery Type" field for regulatory reporting (CFTC, ESMA).
	 *
	 */
	SettlementTypeEnum getSettlementType();

	/*********************** Build Methods  ***********************/
	ExchangeTradedOption build();
	
	ExchangeTradedOption.ExchangeTradedOptionBuilder toBuilder();
	
	static ExchangeTradedOption.ExchangeTradedOptionBuilder builder() {
		return new ExchangeTradedOption.ExchangeTradedOptionBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends ExchangeTradedOption> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends ExchangeTradedOption> getType() {
		return ExchangeTradedOption.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		processRosetta(path.newSubPath("instrumentId"), processor, InstrumentId.class, getInstrumentId());
		processRosetta(path.newSubPath("instrumentType"), processor, InstrumentType.class, getInstrumentType());
		processor.processBasic(path.newSubPath("description"), String.class, getDescription(), this);
		processRosetta(path.newSubPath("currency"), processor, IdentifiedCurrency.class, getCurrency());
		processRosetta(path.newSubPath("exchangeId"), processor, ExchangeId.class, getExchangeId());
		processRosetta(path.newSubPath("clearanceSystem"), processor, ClearanceSystem.class, getClearanceSystem());
		processRosetta(path.newSubPath("definition"), processor, ProductReference.class, getDefinition());
		processRosetta(path.newSubPath("relatedExchangeId"), processor, ExchangeId.class, getRelatedExchangeId());
		processRosetta(path.newSubPath("optionsExchangeId"), processor, ExchangeId.class, getOptionsExchangeId());
		processRosetta(path.newSubPath("specifiedExchangeId"), processor, ExchangeId.class, getSpecifiedExchangeId());
		processor.processBasic(path.newSubPath("multiplier"), BigDecimal.class, getMultiplier(), this);
		processor.processBasic(path.newSubPath("contractReference"), String.class, getContractReference(), this);
		processRosetta(path.newSubPath("expirationDate"), processor, AdjustableOrRelativeDate.class, getExpirationDate());
		processor.processBasic(path.newSubPath("strike"), BigDecimal.class, getStrike(), this);
		processRosetta(path.newSubPath("strikeCurrency"), processor, Currency.class, getStrikeCurrency());
		processRosetta(path.newSubPath("strikeUnits"), processor, PriceQuoteUnits.class, getStrikeUnits());
		processor.processBasic(path.newSubPath("optionType"), PutCallEnum.class, getOptionType(), this);
		processor.processBasic(path.newSubPath("exerciseStyle"), ExerciseStyleEnum.class, getExerciseStyle(), this);
		processRosetta(path.newSubPath("underlyer"), processor, ExchangeTradedContractUnderlyer.class, getUnderlyer());
		processor.processBasic(path.newSubPath("settlementType"), SettlementTypeEnum.class, getSettlementType(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface ExchangeTradedOptionBuilder extends ExchangeTradedOption, ExchangeTradedContract.ExchangeTradedContractBuilder {
		Currency.CurrencyBuilder getOrCreateStrikeCurrency();
		@Override
		Currency.CurrencyBuilder getStrikeCurrency();
		PriceQuoteUnits.PriceQuoteUnitsBuilder getOrCreateStrikeUnits();
		@Override
		PriceQuoteUnits.PriceQuoteUnitsBuilder getStrikeUnits();
		ExchangeTradedContractUnderlyer.ExchangeTradedContractUnderlyerBuilder getOrCreateUnderlyer();
		@Override
		ExchangeTradedContractUnderlyer.ExchangeTradedContractUnderlyerBuilder getUnderlyer();
		@Override
		ExchangeTradedOption.ExchangeTradedOptionBuilder setId(String id);
		@Override
		ExchangeTradedOption.ExchangeTradedOptionBuilder addInstrumentId(InstrumentId instrumentId);
		@Override
		ExchangeTradedOption.ExchangeTradedOptionBuilder addInstrumentId(InstrumentId instrumentId, int idx);
		@Override
		ExchangeTradedOption.ExchangeTradedOptionBuilder addInstrumentId(List<? extends InstrumentId> instrumentId);
		@Override
		ExchangeTradedOption.ExchangeTradedOptionBuilder setInstrumentId(List<? extends InstrumentId> instrumentId);
		@Override
		ExchangeTradedOption.ExchangeTradedOptionBuilder addInstrumentType(InstrumentType instrumentType);
		@Override
		ExchangeTradedOption.ExchangeTradedOptionBuilder addInstrumentType(InstrumentType instrumentType, int idx);
		@Override
		ExchangeTradedOption.ExchangeTradedOptionBuilder addInstrumentType(List<? extends InstrumentType> instrumentType);
		@Override
		ExchangeTradedOption.ExchangeTradedOptionBuilder setInstrumentType(List<? extends InstrumentType> instrumentType);
		@Override
		ExchangeTradedOption.ExchangeTradedOptionBuilder setDescription(String description);
		@Override
		ExchangeTradedOption.ExchangeTradedOptionBuilder setCurrency(IdentifiedCurrency currency);
		@Override
		ExchangeTradedOption.ExchangeTradedOptionBuilder setExchangeId(ExchangeId exchangeId);
		@Override
		ExchangeTradedOption.ExchangeTradedOptionBuilder setClearanceSystem(ClearanceSystem clearanceSystem);
		@Override
		ExchangeTradedOption.ExchangeTradedOptionBuilder setDefinition(ProductReference definition);
		@Override
		ExchangeTradedOption.ExchangeTradedOptionBuilder addRelatedExchangeId(ExchangeId relatedExchangeId);
		@Override
		ExchangeTradedOption.ExchangeTradedOptionBuilder addRelatedExchangeId(ExchangeId relatedExchangeId, int idx);
		@Override
		ExchangeTradedOption.ExchangeTradedOptionBuilder addRelatedExchangeId(List<? extends ExchangeId> relatedExchangeId);
		@Override
		ExchangeTradedOption.ExchangeTradedOptionBuilder setRelatedExchangeId(List<? extends ExchangeId> relatedExchangeId);
		@Override
		ExchangeTradedOption.ExchangeTradedOptionBuilder addOptionsExchangeId(ExchangeId optionsExchangeId);
		@Override
		ExchangeTradedOption.ExchangeTradedOptionBuilder addOptionsExchangeId(ExchangeId optionsExchangeId, int idx);
		@Override
		ExchangeTradedOption.ExchangeTradedOptionBuilder addOptionsExchangeId(List<? extends ExchangeId> optionsExchangeId);
		@Override
		ExchangeTradedOption.ExchangeTradedOptionBuilder setOptionsExchangeId(List<? extends ExchangeId> optionsExchangeId);
		@Override
		ExchangeTradedOption.ExchangeTradedOptionBuilder addSpecifiedExchangeId(ExchangeId specifiedExchangeId);
		@Override
		ExchangeTradedOption.ExchangeTradedOptionBuilder addSpecifiedExchangeId(ExchangeId specifiedExchangeId, int idx);
		@Override
		ExchangeTradedOption.ExchangeTradedOptionBuilder addSpecifiedExchangeId(List<? extends ExchangeId> specifiedExchangeId);
		@Override
		ExchangeTradedOption.ExchangeTradedOptionBuilder setSpecifiedExchangeId(List<? extends ExchangeId> specifiedExchangeId);
		@Override
		ExchangeTradedOption.ExchangeTradedOptionBuilder setMultiplier(BigDecimal multiplier);
		@Override
		ExchangeTradedOption.ExchangeTradedOptionBuilder setContractReference(String contractReference);
		@Override
		ExchangeTradedOption.ExchangeTradedOptionBuilder setExpirationDate(AdjustableOrRelativeDate expirationDate);
		ExchangeTradedOption.ExchangeTradedOptionBuilder setStrike(BigDecimal strike);
		ExchangeTradedOption.ExchangeTradedOptionBuilder setStrikeCurrency(Currency strikeCurrency);
		ExchangeTradedOption.ExchangeTradedOptionBuilder setStrikeUnits(PriceQuoteUnits strikeUnits);
		ExchangeTradedOption.ExchangeTradedOptionBuilder setOptionType(PutCallEnum optionType);
		ExchangeTradedOption.ExchangeTradedOptionBuilder setExerciseStyle(ExerciseStyleEnum exerciseStyle);
		ExchangeTradedOption.ExchangeTradedOptionBuilder setUnderlyer(ExchangeTradedContractUnderlyer underlyer);
		ExchangeTradedOption.ExchangeTradedOptionBuilder setSettlementType(SettlementTypeEnum settlementType);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
			processRosetta(path.newSubPath("instrumentId"), processor, InstrumentId.InstrumentIdBuilder.class, getInstrumentId());
			processRosetta(path.newSubPath("instrumentType"), processor, InstrumentType.InstrumentTypeBuilder.class, getInstrumentType());
			processor.processBasic(path.newSubPath("description"), String.class, getDescription(), this);
			processRosetta(path.newSubPath("currency"), processor, IdentifiedCurrency.IdentifiedCurrencyBuilder.class, getCurrency());
			processRosetta(path.newSubPath("exchangeId"), processor, ExchangeId.ExchangeIdBuilder.class, getExchangeId());
			processRosetta(path.newSubPath("clearanceSystem"), processor, ClearanceSystem.ClearanceSystemBuilder.class, getClearanceSystem());
			processRosetta(path.newSubPath("definition"), processor, ProductReference.ProductReferenceBuilder.class, getDefinition());
			processRosetta(path.newSubPath("relatedExchangeId"), processor, ExchangeId.ExchangeIdBuilder.class, getRelatedExchangeId());
			processRosetta(path.newSubPath("optionsExchangeId"), processor, ExchangeId.ExchangeIdBuilder.class, getOptionsExchangeId());
			processRosetta(path.newSubPath("specifiedExchangeId"), processor, ExchangeId.ExchangeIdBuilder.class, getSpecifiedExchangeId());
			processor.processBasic(path.newSubPath("multiplier"), BigDecimal.class, getMultiplier(), this);
			processor.processBasic(path.newSubPath("contractReference"), String.class, getContractReference(), this);
			processRosetta(path.newSubPath("expirationDate"), processor, AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder.class, getExpirationDate());
			processor.processBasic(path.newSubPath("strike"), BigDecimal.class, getStrike(), this);
			processRosetta(path.newSubPath("strikeCurrency"), processor, Currency.CurrencyBuilder.class, getStrikeCurrency());
			processRosetta(path.newSubPath("strikeUnits"), processor, PriceQuoteUnits.PriceQuoteUnitsBuilder.class, getStrikeUnits());
			processor.processBasic(path.newSubPath("optionType"), PutCallEnum.class, getOptionType(), this);
			processor.processBasic(path.newSubPath("exerciseStyle"), ExerciseStyleEnum.class, getExerciseStyle(), this);
			processRosetta(path.newSubPath("underlyer"), processor, ExchangeTradedContractUnderlyer.ExchangeTradedContractUnderlyerBuilder.class, getUnderlyer());
			processor.processBasic(path.newSubPath("settlementType"), SettlementTypeEnum.class, getSettlementType(), this);
		}
		

		ExchangeTradedOption.ExchangeTradedOptionBuilder prune();
	}

	/*********************** Immutable Implementation of ExchangeTradedOption  ***********************/
	class ExchangeTradedOptionImpl extends ExchangeTradedContract.ExchangeTradedContractImpl implements ExchangeTradedOption {
		private final BigDecimal strike;
		private final Currency strikeCurrency;
		private final PriceQuoteUnits strikeUnits;
		private final PutCallEnum optionType;
		private final ExerciseStyleEnum exerciseStyle;
		private final ExchangeTradedContractUnderlyer underlyer;
		private final SettlementTypeEnum settlementType;
		
		protected ExchangeTradedOptionImpl(ExchangeTradedOption.ExchangeTradedOptionBuilder builder) {
			super(builder);
			this.strike = builder.getStrike();
			this.strikeCurrency = ofNullable(builder.getStrikeCurrency()).map(f->f.build()).orElse(null);
			this.strikeUnits = ofNullable(builder.getStrikeUnits()).map(f->f.build()).orElse(null);
			this.optionType = builder.getOptionType();
			this.exerciseStyle = builder.getExerciseStyle();
			this.underlyer = ofNullable(builder.getUnderlyer()).map(f->f.build()).orElse(null);
			this.settlementType = builder.getSettlementType();
		}
		
		@Override
		@RosettaAttribute("strike")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("strike")
		public BigDecimal getStrike() {
			return strike;
		}
		
		@Override
		@RosettaAttribute("strikeCurrency")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("strikeCurrency")
		public Currency getStrikeCurrency() {
			return strikeCurrency;
		}
		
		@Override
		@RosettaAttribute("strikeUnits")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("strikeUnits")
		public PriceQuoteUnits getStrikeUnits() {
			return strikeUnits;
		}
		
		@Override
		@RosettaAttribute("optionType")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("optionType")
		public PutCallEnum getOptionType() {
			return optionType;
		}
		
		@Override
		@RosettaAttribute("exerciseStyle")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("exerciseStyle")
		public ExerciseStyleEnum getExerciseStyle() {
			return exerciseStyle;
		}
		
		@Override
		@RosettaAttribute("underlyer")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("underlyer")
		public ExchangeTradedContractUnderlyer getUnderlyer() {
			return underlyer;
		}
		
		@Override
		@RosettaAttribute("settlementType")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("settlementType")
		public SettlementTypeEnum getSettlementType() {
			return settlementType;
		}
		
		@Override
		public ExchangeTradedOption build() {
			return this;
		}
		
		@Override
		public ExchangeTradedOption.ExchangeTradedOptionBuilder toBuilder() {
			ExchangeTradedOption.ExchangeTradedOptionBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(ExchangeTradedOption.ExchangeTradedOptionBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getStrike()).ifPresent(builder::setStrike);
			ofNullable(getStrikeCurrency()).ifPresent(builder::setStrikeCurrency);
			ofNullable(getStrikeUnits()).ifPresent(builder::setStrikeUnits);
			ofNullable(getOptionType()).ifPresent(builder::setOptionType);
			ofNullable(getExerciseStyle()).ifPresent(builder::setExerciseStyle);
			ofNullable(getUnderlyer()).ifPresent(builder::setUnderlyer);
			ofNullable(getSettlementType()).ifPresent(builder::setSettlementType);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			ExchangeTradedOption _that = getType().cast(o);
		
			if (!Objects.equals(strike, _that.getStrike())) return false;
			if (!Objects.equals(strikeCurrency, _that.getStrikeCurrency())) return false;
			if (!Objects.equals(strikeUnits, _that.getStrikeUnits())) return false;
			if (!Objects.equals(optionType, _that.getOptionType())) return false;
			if (!Objects.equals(exerciseStyle, _that.getExerciseStyle())) return false;
			if (!Objects.equals(underlyer, _that.getUnderlyer())) return false;
			if (!Objects.equals(settlementType, _that.getSettlementType())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (strike != null ? strike.hashCode() : 0);
			_result = 31 * _result + (strikeCurrency != null ? strikeCurrency.hashCode() : 0);
			_result = 31 * _result + (strikeUnits != null ? strikeUnits.hashCode() : 0);
			_result = 31 * _result + (optionType != null ? optionType.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (exerciseStyle != null ? exerciseStyle.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (underlyer != null ? underlyer.hashCode() : 0);
			_result = 31 * _result + (settlementType != null ? settlementType.getClass().getName().hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ExchangeTradedOption {" +
				"strike=" + this.strike + ", " +
				"strikeCurrency=" + this.strikeCurrency + ", " +
				"strikeUnits=" + this.strikeUnits + ", " +
				"optionType=" + this.optionType + ", " +
				"exerciseStyle=" + this.exerciseStyle + ", " +
				"underlyer=" + this.underlyer + ", " +
				"settlementType=" + this.settlementType +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of ExchangeTradedOption  ***********************/
	class ExchangeTradedOptionBuilderImpl extends ExchangeTradedContract.ExchangeTradedContractBuilderImpl implements ExchangeTradedOption.ExchangeTradedOptionBuilder {
	
		protected BigDecimal strike;
		protected Currency.CurrencyBuilder strikeCurrency;
		protected PriceQuoteUnits.PriceQuoteUnitsBuilder strikeUnits;
		protected PutCallEnum optionType;
		protected ExerciseStyleEnum exerciseStyle;
		protected ExchangeTradedContractUnderlyer.ExchangeTradedContractUnderlyerBuilder underlyer;
		protected SettlementTypeEnum settlementType;
		
		@Override
		@RosettaAttribute("strike")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("strike")
		public BigDecimal getStrike() {
			return strike;
		}
		
		@Override
		@RosettaAttribute("strikeCurrency")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("strikeCurrency")
		public Currency.CurrencyBuilder getStrikeCurrency() {
			return strikeCurrency;
		}
		
		@Override
		public Currency.CurrencyBuilder getOrCreateStrikeCurrency() {
			Currency.CurrencyBuilder result;
			if (strikeCurrency!=null) {
				result = strikeCurrency;
			}
			else {
				result = strikeCurrency = Currency.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("strikeUnits")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("strikeUnits")
		public PriceQuoteUnits.PriceQuoteUnitsBuilder getStrikeUnits() {
			return strikeUnits;
		}
		
		@Override
		public PriceQuoteUnits.PriceQuoteUnitsBuilder getOrCreateStrikeUnits() {
			PriceQuoteUnits.PriceQuoteUnitsBuilder result;
			if (strikeUnits!=null) {
				result = strikeUnits;
			}
			else {
				result = strikeUnits = PriceQuoteUnits.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("optionType")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("optionType")
		public PutCallEnum getOptionType() {
			return optionType;
		}
		
		@Override
		@RosettaAttribute("exerciseStyle")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("exerciseStyle")
		public ExerciseStyleEnum getExerciseStyle() {
			return exerciseStyle;
		}
		
		@Override
		@RosettaAttribute("underlyer")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("underlyer")
		public ExchangeTradedContractUnderlyer.ExchangeTradedContractUnderlyerBuilder getUnderlyer() {
			return underlyer;
		}
		
		@Override
		public ExchangeTradedContractUnderlyer.ExchangeTradedContractUnderlyerBuilder getOrCreateUnderlyer() {
			ExchangeTradedContractUnderlyer.ExchangeTradedContractUnderlyerBuilder result;
			if (underlyer!=null) {
				result = underlyer;
			}
			else {
				result = underlyer = ExchangeTradedContractUnderlyer.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("settlementType")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("settlementType")
		public SettlementTypeEnum getSettlementType() {
			return settlementType;
		}
		
		@RosettaAttribute("id")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("id")
		@Override
		public ExchangeTradedOption.ExchangeTradedOptionBuilder setId(String _id) {
			this.id = _id == null ? null : _id;
			return this;
		}
		
		@RosettaAttribute("instrumentId")
		@Accessor(AccessorType.ADDER)
		@Required
		@Multi
		@RuneAttribute("instrumentId")
		@Override
		public ExchangeTradedOption.ExchangeTradedOptionBuilder addInstrumentId(InstrumentId _instrumentId) {
			if (_instrumentId != null) {
				this.instrumentId.add(_instrumentId.toBuilder());
			}
			return this;
		}
		
		@Override
		public ExchangeTradedOption.ExchangeTradedOptionBuilder addInstrumentId(InstrumentId _instrumentId, int idx) {
			getIndex(this.instrumentId, idx, () -> _instrumentId.toBuilder());
			return this;
		}
		
		@Override
		public ExchangeTradedOption.ExchangeTradedOptionBuilder addInstrumentId(List<? extends InstrumentId> instrumentIds) {
			if (instrumentIds != null) {
				for (final InstrumentId toAdd : instrumentIds) {
					this.instrumentId.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("instrumentId")
		@Accessor(AccessorType.SETTER)
		@Required
		@Multi
		@RuneAttribute("instrumentId")
		@Override
		public ExchangeTradedOption.ExchangeTradedOptionBuilder setInstrumentId(List<? extends InstrumentId> instrumentIds) {
			if (instrumentIds == null) {
				this.instrumentId = new ArrayList<>();
			} else {
				this.instrumentId = instrumentIds.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("instrumentType")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("instrumentType")
		@Override
		public ExchangeTradedOption.ExchangeTradedOptionBuilder addInstrumentType(InstrumentType _instrumentType) {
			if (_instrumentType != null) {
				this.instrumentType.add(_instrumentType.toBuilder());
			}
			return this;
		}
		
		@Override
		public ExchangeTradedOption.ExchangeTradedOptionBuilder addInstrumentType(InstrumentType _instrumentType, int idx) {
			getIndex(this.instrumentType, idx, () -> _instrumentType.toBuilder());
			return this;
		}
		
		@Override
		public ExchangeTradedOption.ExchangeTradedOptionBuilder addInstrumentType(List<? extends InstrumentType> instrumentTypes) {
			if (instrumentTypes != null) {
				for (final InstrumentType toAdd : instrumentTypes) {
					this.instrumentType.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("instrumentType")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("instrumentType")
		@Override
		public ExchangeTradedOption.ExchangeTradedOptionBuilder setInstrumentType(List<? extends InstrumentType> instrumentTypes) {
			if (instrumentTypes == null) {
				this.instrumentType = new ArrayList<>();
			} else {
				this.instrumentType = instrumentTypes.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("description")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("description")
		@Override
		public ExchangeTradedOption.ExchangeTradedOptionBuilder setDescription(String _description) {
			this.description = _description == null ? null : _description;
			return this;
		}
		
		@RosettaAttribute("currency")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("currency")
		@Override
		public ExchangeTradedOption.ExchangeTradedOptionBuilder setCurrency(IdentifiedCurrency _currency) {
			this.currency = _currency == null ? null : _currency.toBuilder();
			return this;
		}
		
		@RosettaAttribute("exchangeId")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("exchangeId")
		@Override
		public ExchangeTradedOption.ExchangeTradedOptionBuilder setExchangeId(ExchangeId _exchangeId) {
			this.exchangeId = _exchangeId == null ? null : _exchangeId.toBuilder();
			return this;
		}
		
		@RosettaAttribute("clearanceSystem")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("clearanceSystem")
		@Override
		public ExchangeTradedOption.ExchangeTradedOptionBuilder setClearanceSystem(ClearanceSystem _clearanceSystem) {
			this.clearanceSystem = _clearanceSystem == null ? null : _clearanceSystem.toBuilder();
			return this;
		}
		
		@RosettaAttribute("definition")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("definition")
		@Override
		public ExchangeTradedOption.ExchangeTradedOptionBuilder setDefinition(ProductReference _definition) {
			this.definition = _definition == null ? null : _definition.toBuilder();
			return this;
		}
		
		@RosettaAttribute("relatedExchangeId")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("relatedExchangeId")
		@Override
		public ExchangeTradedOption.ExchangeTradedOptionBuilder addRelatedExchangeId(ExchangeId _relatedExchangeId) {
			if (_relatedExchangeId != null) {
				this.relatedExchangeId.add(_relatedExchangeId.toBuilder());
			}
			return this;
		}
		
		@Override
		public ExchangeTradedOption.ExchangeTradedOptionBuilder addRelatedExchangeId(ExchangeId _relatedExchangeId, int idx) {
			getIndex(this.relatedExchangeId, idx, () -> _relatedExchangeId.toBuilder());
			return this;
		}
		
		@Override
		public ExchangeTradedOption.ExchangeTradedOptionBuilder addRelatedExchangeId(List<? extends ExchangeId> relatedExchangeIds) {
			if (relatedExchangeIds != null) {
				for (final ExchangeId toAdd : relatedExchangeIds) {
					this.relatedExchangeId.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("relatedExchangeId")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("relatedExchangeId")
		@Override
		public ExchangeTradedOption.ExchangeTradedOptionBuilder setRelatedExchangeId(List<? extends ExchangeId> relatedExchangeIds) {
			if (relatedExchangeIds == null) {
				this.relatedExchangeId = new ArrayList<>();
			} else {
				this.relatedExchangeId = relatedExchangeIds.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("optionsExchangeId")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("optionsExchangeId")
		@Override
		public ExchangeTradedOption.ExchangeTradedOptionBuilder addOptionsExchangeId(ExchangeId _optionsExchangeId) {
			if (_optionsExchangeId != null) {
				this.optionsExchangeId.add(_optionsExchangeId.toBuilder());
			}
			return this;
		}
		
		@Override
		public ExchangeTradedOption.ExchangeTradedOptionBuilder addOptionsExchangeId(ExchangeId _optionsExchangeId, int idx) {
			getIndex(this.optionsExchangeId, idx, () -> _optionsExchangeId.toBuilder());
			return this;
		}
		
		@Override
		public ExchangeTradedOption.ExchangeTradedOptionBuilder addOptionsExchangeId(List<? extends ExchangeId> optionsExchangeIds) {
			if (optionsExchangeIds != null) {
				for (final ExchangeId toAdd : optionsExchangeIds) {
					this.optionsExchangeId.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("optionsExchangeId")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("optionsExchangeId")
		@Override
		public ExchangeTradedOption.ExchangeTradedOptionBuilder setOptionsExchangeId(List<? extends ExchangeId> optionsExchangeIds) {
			if (optionsExchangeIds == null) {
				this.optionsExchangeId = new ArrayList<>();
			} else {
				this.optionsExchangeId = optionsExchangeIds.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("specifiedExchangeId")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("specifiedExchangeId")
		@Override
		public ExchangeTradedOption.ExchangeTradedOptionBuilder addSpecifiedExchangeId(ExchangeId _specifiedExchangeId) {
			if (_specifiedExchangeId != null) {
				this.specifiedExchangeId.add(_specifiedExchangeId.toBuilder());
			}
			return this;
		}
		
		@Override
		public ExchangeTradedOption.ExchangeTradedOptionBuilder addSpecifiedExchangeId(ExchangeId _specifiedExchangeId, int idx) {
			getIndex(this.specifiedExchangeId, idx, () -> _specifiedExchangeId.toBuilder());
			return this;
		}
		
		@Override
		public ExchangeTradedOption.ExchangeTradedOptionBuilder addSpecifiedExchangeId(List<? extends ExchangeId> specifiedExchangeIds) {
			if (specifiedExchangeIds != null) {
				for (final ExchangeId toAdd : specifiedExchangeIds) {
					this.specifiedExchangeId.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("specifiedExchangeId")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("specifiedExchangeId")
		@Override
		public ExchangeTradedOption.ExchangeTradedOptionBuilder setSpecifiedExchangeId(List<? extends ExchangeId> specifiedExchangeIds) {
			if (specifiedExchangeIds == null) {
				this.specifiedExchangeId = new ArrayList<>();
			} else {
				this.specifiedExchangeId = specifiedExchangeIds.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("multiplier")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("multiplier")
		@Override
		public ExchangeTradedOption.ExchangeTradedOptionBuilder setMultiplier(BigDecimal _multiplier) {
			this.multiplier = _multiplier == null ? null : _multiplier;
			return this;
		}
		
		@RosettaAttribute("contractReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("contractReference")
		@Override
		public ExchangeTradedOption.ExchangeTradedOptionBuilder setContractReference(String _contractReference) {
			this.contractReference = _contractReference == null ? null : _contractReference;
			return this;
		}
		
		@RosettaAttribute("expirationDate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("expirationDate")
		@Override
		public ExchangeTradedOption.ExchangeTradedOptionBuilder setExpirationDate(AdjustableOrRelativeDate _expirationDate) {
			this.expirationDate = _expirationDate == null ? null : _expirationDate.toBuilder();
			return this;
		}
		
		@RosettaAttribute("strike")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("strike")
		@Override
		public ExchangeTradedOption.ExchangeTradedOptionBuilder setStrike(BigDecimal _strike) {
			this.strike = _strike == null ? null : _strike;
			return this;
		}
		
		@RosettaAttribute("strikeCurrency")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("strikeCurrency")
		@Override
		public ExchangeTradedOption.ExchangeTradedOptionBuilder setStrikeCurrency(Currency _strikeCurrency) {
			this.strikeCurrency = _strikeCurrency == null ? null : _strikeCurrency.toBuilder();
			return this;
		}
		
		@RosettaAttribute("strikeUnits")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("strikeUnits")
		@Override
		public ExchangeTradedOption.ExchangeTradedOptionBuilder setStrikeUnits(PriceQuoteUnits _strikeUnits) {
			this.strikeUnits = _strikeUnits == null ? null : _strikeUnits.toBuilder();
			return this;
		}
		
		@RosettaAttribute("optionType")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("optionType")
		@Override
		public ExchangeTradedOption.ExchangeTradedOptionBuilder setOptionType(PutCallEnum _optionType) {
			this.optionType = _optionType == null ? null : _optionType;
			return this;
		}
		
		@RosettaAttribute("exerciseStyle")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("exerciseStyle")
		@Override
		public ExchangeTradedOption.ExchangeTradedOptionBuilder setExerciseStyle(ExerciseStyleEnum _exerciseStyle) {
			this.exerciseStyle = _exerciseStyle == null ? null : _exerciseStyle;
			return this;
		}
		
		@RosettaAttribute("underlyer")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("underlyer")
		@Override
		public ExchangeTradedOption.ExchangeTradedOptionBuilder setUnderlyer(ExchangeTradedContractUnderlyer _underlyer) {
			this.underlyer = _underlyer == null ? null : _underlyer.toBuilder();
			return this;
		}
		
		@RosettaAttribute("settlementType")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("settlementType")
		@Override
		public ExchangeTradedOption.ExchangeTradedOptionBuilder setSettlementType(SettlementTypeEnum _settlementType) {
			this.settlementType = _settlementType == null ? null : _settlementType;
			return this;
		}
		
		@Override
		public ExchangeTradedOption build() {
			return new ExchangeTradedOption.ExchangeTradedOptionImpl(this);
		}
		
		@Override
		public ExchangeTradedOption.ExchangeTradedOptionBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ExchangeTradedOption.ExchangeTradedOptionBuilder prune() {
			super.prune();
			if (strikeCurrency!=null && !strikeCurrency.prune().hasData()) strikeCurrency = null;
			if (strikeUnits!=null && !strikeUnits.prune().hasData()) strikeUnits = null;
			if (underlyer!=null && !underlyer.prune().hasData()) underlyer = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getStrike()!=null) return true;
			if (getStrikeCurrency()!=null && getStrikeCurrency().hasData()) return true;
			if (getStrikeUnits()!=null && getStrikeUnits().hasData()) return true;
			if (getOptionType()!=null) return true;
			if (getExerciseStyle()!=null) return true;
			if (getUnderlyer()!=null && getUnderlyer().hasData()) return true;
			if (getSettlementType()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ExchangeTradedOption.ExchangeTradedOptionBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			ExchangeTradedOption.ExchangeTradedOptionBuilder o = (ExchangeTradedOption.ExchangeTradedOptionBuilder) other;
			
			merger.mergeRosetta(getStrikeCurrency(), o.getStrikeCurrency(), this::setStrikeCurrency);
			merger.mergeRosetta(getStrikeUnits(), o.getStrikeUnits(), this::setStrikeUnits);
			merger.mergeRosetta(getUnderlyer(), o.getUnderlyer(), this::setUnderlyer);
			
			merger.mergeBasic(getStrike(), o.getStrike(), this::setStrike);
			merger.mergeBasic(getOptionType(), o.getOptionType(), this::setOptionType);
			merger.mergeBasic(getExerciseStyle(), o.getExerciseStyle(), this::setExerciseStyle);
			merger.mergeBasic(getSettlementType(), o.getSettlementType(), this::setSettlementType);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			ExchangeTradedOption _that = getType().cast(o);
		
			if (!Objects.equals(strike, _that.getStrike())) return false;
			if (!Objects.equals(strikeCurrency, _that.getStrikeCurrency())) return false;
			if (!Objects.equals(strikeUnits, _that.getStrikeUnits())) return false;
			if (!Objects.equals(optionType, _that.getOptionType())) return false;
			if (!Objects.equals(exerciseStyle, _that.getExerciseStyle())) return false;
			if (!Objects.equals(underlyer, _that.getUnderlyer())) return false;
			if (!Objects.equals(settlementType, _that.getSettlementType())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (strike != null ? strike.hashCode() : 0);
			_result = 31 * _result + (strikeCurrency != null ? strikeCurrency.hashCode() : 0);
			_result = 31 * _result + (strikeUnits != null ? strikeUnits.hashCode() : 0);
			_result = 31 * _result + (optionType != null ? optionType.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (exerciseStyle != null ? exerciseStyle.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (underlyer != null ? underlyer.hashCode() : 0);
			_result = 31 * _result + (settlementType != null ? settlementType.getClass().getName().hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ExchangeTradedOptionBuilder {" +
				"strike=" + this.strike + ", " +
				"strikeCurrency=" + this.strikeCurrency + ", " +
				"strikeUnits=" + this.strikeUnits + ", " +
				"optionType=" + this.optionType + ", " +
				"exerciseStyle=" + this.exerciseStyle + ", " +
				"underlyer=" + this.underlyer + ", " +
				"settlementType=" + this.settlementType +
			'}' + " " + super.toString();
		}
	}
}

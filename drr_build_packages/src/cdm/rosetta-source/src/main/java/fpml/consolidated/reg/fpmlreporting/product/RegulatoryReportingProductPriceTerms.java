package fpml.consolidated.reg.fpmlreporting.product;

import com.google.common.collect.ImmutableList;
import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.Accessor;
import com.rosetta.model.lib.annotations.AccessorType;
import com.rosetta.model.lib.annotations.Multi;
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
import fpml.consolidated.fx.ExchangeRate;
import fpml.consolidated.reg.fpmlreporting.product.meta.RegulatoryReportingProductPriceTermsMeta;
import fpml.consolidated.shared.Currency;
import fpml.consolidated.shared.Schedule;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.Consumer;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "recordkeeping-5.13"
 *
 * Provision All price term information is defined by CPMI-IOSCO CDE. DEPRECATED. Reason: Not used, deprecated parent element. (RPTWG decision 2024-05-30)
 *
 */
@RosettaDataType(value="RegulatoryReportingProductPriceTerms", builder=RegulatoryReportingProductPriceTerms.RegulatoryReportingProductPriceTermsBuilderImpl.class, version="2.1.1")
@RuneDataType(value="RegulatoryReportingProductPriceTerms", model="fpml", builder=RegulatoryReportingProductPriceTerms.RegulatoryReportingProductPriceTermsBuilderImpl.class, version="2.1.1")
public interface RegulatoryReportingProductPriceTerms extends RosettaModelObject {

	RegulatoryReportingProductPriceTermsMeta metaData = new RegulatoryReportingProductPriceTermsMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision DEPRECATED. Reason: Not used, deprecated parent element. (RPTWG decision 2024-05-30)
	 *
	 */
	List<BigDecimal> getFixedRate();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision DEPRECATED. Reason: Not used, deprecated parent element. (RPTWG decision 2024-05-30)
	 *
	 */
	List<String> getFixedRateNotation();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision DEPRECATED. Reason: Not used, deprecated parent element. (RPTWG decision 2024-05-30)
	 *
	 */
	List<? extends Schedule> getFixedRateSchedule();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision DEPRECATED. Reason: Not used, deprecated parent element. (RPTWG decision 2024-05-30)
	 *
	 */
	List<BigDecimal> getSpread();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision DEPRECATED. Reason: Not used, deprecated parent element. (RPTWG decision 2024-05-30)
	 *
	 */
	List<? extends Currency> getSpreadCurrency();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision DEPRECATED. Reason: Not used, deprecated parent element. (RPTWG decision 2024-05-30)
	 *
	 */
	List<String> getSpreadNotation();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision DEPRECATED. Reason: Not used, deprecated parent element. (RPTWG decision 2024-05-30)
	 *
	 */
	List<BigDecimal> getStrikePrice();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision DEPRECATED. Reason: Not used, deprecated parent element. (RPTWG decision 2024-05-30)
	 *
	 */
	List<String> getStrikePriceNotation();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision DEPRECATED. Reason: Not used, deprecated parent element. (RPTWG decision 2024-05-30)
	 *
	 */
	List<? extends Schedule> getStrikePriceSchedule();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision DEPRECATED. Reason: Not used, deprecated parent element. (RPTWG decision 2024-05-30)
	 *
	 */
	List<? extends ExchangeRate> getExchangeRate();

	/*********************** Build Methods  ***********************/
	RegulatoryReportingProductPriceTerms build();
	
	RegulatoryReportingProductPriceTerms.RegulatoryReportingProductPriceTermsBuilder toBuilder();
	
	static RegulatoryReportingProductPriceTerms.RegulatoryReportingProductPriceTermsBuilder builder() {
		return new RegulatoryReportingProductPriceTerms.RegulatoryReportingProductPriceTermsBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends RegulatoryReportingProductPriceTerms> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends RegulatoryReportingProductPriceTerms> getType() {
		return RegulatoryReportingProductPriceTerms.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("fixedRate"), BigDecimal.class, getFixedRate(), this);
		processor.processBasic(path.newSubPath("fixedRateNotation"), String.class, getFixedRateNotation(), this);
		processRosetta(path.newSubPath("fixedRateSchedule"), processor, Schedule.class, getFixedRateSchedule());
		processor.processBasic(path.newSubPath("spread"), BigDecimal.class, getSpread(), this);
		processRosetta(path.newSubPath("spreadCurrency"), processor, Currency.class, getSpreadCurrency());
		processor.processBasic(path.newSubPath("spreadNotation"), String.class, getSpreadNotation(), this);
		processor.processBasic(path.newSubPath("strikePrice"), BigDecimal.class, getStrikePrice(), this);
		processor.processBasic(path.newSubPath("strikePriceNotation"), String.class, getStrikePriceNotation(), this);
		processRosetta(path.newSubPath("strikePriceSchedule"), processor, Schedule.class, getStrikePriceSchedule());
		processRosetta(path.newSubPath("exchangeRate"), processor, ExchangeRate.class, getExchangeRate());
	}
	

	/*********************** Builder Interface  ***********************/
	interface RegulatoryReportingProductPriceTermsBuilder extends RegulatoryReportingProductPriceTerms, RosettaModelObjectBuilder {
		Schedule.ScheduleBuilder getOrCreateFixedRateSchedule(int index);
		@Override
		List<? extends Schedule.ScheduleBuilder> getFixedRateSchedule();
		Currency.CurrencyBuilder getOrCreateSpreadCurrency(int index);
		@Override
		List<? extends Currency.CurrencyBuilder> getSpreadCurrency();
		Schedule.ScheduleBuilder getOrCreateStrikePriceSchedule(int index);
		@Override
		List<? extends Schedule.ScheduleBuilder> getStrikePriceSchedule();
		ExchangeRate.ExchangeRateBuilder getOrCreateExchangeRate(int index);
		@Override
		List<? extends ExchangeRate.ExchangeRateBuilder> getExchangeRate();
		RegulatoryReportingProductPriceTerms.RegulatoryReportingProductPriceTermsBuilder addFixedRate(BigDecimal fixedRate);
		RegulatoryReportingProductPriceTerms.RegulatoryReportingProductPriceTermsBuilder addFixedRate(BigDecimal fixedRate, int idx);
		RegulatoryReportingProductPriceTerms.RegulatoryReportingProductPriceTermsBuilder addFixedRate(List<BigDecimal> fixedRate);
		RegulatoryReportingProductPriceTerms.RegulatoryReportingProductPriceTermsBuilder setFixedRate(List<BigDecimal> fixedRate);
		RegulatoryReportingProductPriceTerms.RegulatoryReportingProductPriceTermsBuilder addFixedRateNotation(String fixedRateNotation);
		RegulatoryReportingProductPriceTerms.RegulatoryReportingProductPriceTermsBuilder addFixedRateNotation(String fixedRateNotation, int idx);
		RegulatoryReportingProductPriceTerms.RegulatoryReportingProductPriceTermsBuilder addFixedRateNotation(List<String> fixedRateNotation);
		RegulatoryReportingProductPriceTerms.RegulatoryReportingProductPriceTermsBuilder setFixedRateNotation(List<String> fixedRateNotation);
		RegulatoryReportingProductPriceTerms.RegulatoryReportingProductPriceTermsBuilder addFixedRateSchedule(Schedule fixedRateSchedule);
		RegulatoryReportingProductPriceTerms.RegulatoryReportingProductPriceTermsBuilder addFixedRateSchedule(Schedule fixedRateSchedule, int idx);
		RegulatoryReportingProductPriceTerms.RegulatoryReportingProductPriceTermsBuilder addFixedRateSchedule(List<? extends Schedule> fixedRateSchedule);
		RegulatoryReportingProductPriceTerms.RegulatoryReportingProductPriceTermsBuilder setFixedRateSchedule(List<? extends Schedule> fixedRateSchedule);
		RegulatoryReportingProductPriceTerms.RegulatoryReportingProductPriceTermsBuilder addSpread(BigDecimal spread);
		RegulatoryReportingProductPriceTerms.RegulatoryReportingProductPriceTermsBuilder addSpread(BigDecimal spread, int idx);
		RegulatoryReportingProductPriceTerms.RegulatoryReportingProductPriceTermsBuilder addSpread(List<BigDecimal> spread);
		RegulatoryReportingProductPriceTerms.RegulatoryReportingProductPriceTermsBuilder setSpread(List<BigDecimal> spread);
		RegulatoryReportingProductPriceTerms.RegulatoryReportingProductPriceTermsBuilder addSpreadCurrency(Currency spreadCurrency);
		RegulatoryReportingProductPriceTerms.RegulatoryReportingProductPriceTermsBuilder addSpreadCurrency(Currency spreadCurrency, int idx);
		RegulatoryReportingProductPriceTerms.RegulatoryReportingProductPriceTermsBuilder addSpreadCurrency(List<? extends Currency> spreadCurrency);
		RegulatoryReportingProductPriceTerms.RegulatoryReportingProductPriceTermsBuilder setSpreadCurrency(List<? extends Currency> spreadCurrency);
		RegulatoryReportingProductPriceTerms.RegulatoryReportingProductPriceTermsBuilder addSpreadNotation(String spreadNotation);
		RegulatoryReportingProductPriceTerms.RegulatoryReportingProductPriceTermsBuilder addSpreadNotation(String spreadNotation, int idx);
		RegulatoryReportingProductPriceTerms.RegulatoryReportingProductPriceTermsBuilder addSpreadNotation(List<String> spreadNotation);
		RegulatoryReportingProductPriceTerms.RegulatoryReportingProductPriceTermsBuilder setSpreadNotation(List<String> spreadNotation);
		RegulatoryReportingProductPriceTerms.RegulatoryReportingProductPriceTermsBuilder addStrikePrice(BigDecimal strikePrice);
		RegulatoryReportingProductPriceTerms.RegulatoryReportingProductPriceTermsBuilder addStrikePrice(BigDecimal strikePrice, int idx);
		RegulatoryReportingProductPriceTerms.RegulatoryReportingProductPriceTermsBuilder addStrikePrice(List<BigDecimal> strikePrice);
		RegulatoryReportingProductPriceTerms.RegulatoryReportingProductPriceTermsBuilder setStrikePrice(List<BigDecimal> strikePrice);
		RegulatoryReportingProductPriceTerms.RegulatoryReportingProductPriceTermsBuilder addStrikePriceNotation(String strikePriceNotation);
		RegulatoryReportingProductPriceTerms.RegulatoryReportingProductPriceTermsBuilder addStrikePriceNotation(String strikePriceNotation, int idx);
		RegulatoryReportingProductPriceTerms.RegulatoryReportingProductPriceTermsBuilder addStrikePriceNotation(List<String> strikePriceNotation);
		RegulatoryReportingProductPriceTerms.RegulatoryReportingProductPriceTermsBuilder setStrikePriceNotation(List<String> strikePriceNotation);
		RegulatoryReportingProductPriceTerms.RegulatoryReportingProductPriceTermsBuilder addStrikePriceSchedule(Schedule strikePriceSchedule);
		RegulatoryReportingProductPriceTerms.RegulatoryReportingProductPriceTermsBuilder addStrikePriceSchedule(Schedule strikePriceSchedule, int idx);
		RegulatoryReportingProductPriceTerms.RegulatoryReportingProductPriceTermsBuilder addStrikePriceSchedule(List<? extends Schedule> strikePriceSchedule);
		RegulatoryReportingProductPriceTerms.RegulatoryReportingProductPriceTermsBuilder setStrikePriceSchedule(List<? extends Schedule> strikePriceSchedule);
		RegulatoryReportingProductPriceTerms.RegulatoryReportingProductPriceTermsBuilder addExchangeRate(ExchangeRate exchangeRate);
		RegulatoryReportingProductPriceTerms.RegulatoryReportingProductPriceTermsBuilder addExchangeRate(ExchangeRate exchangeRate, int idx);
		RegulatoryReportingProductPriceTerms.RegulatoryReportingProductPriceTermsBuilder addExchangeRate(List<? extends ExchangeRate> exchangeRate);
		RegulatoryReportingProductPriceTerms.RegulatoryReportingProductPriceTermsBuilder setExchangeRate(List<? extends ExchangeRate> exchangeRate);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("fixedRate"), BigDecimal.class, getFixedRate(), this);
			processor.processBasic(path.newSubPath("fixedRateNotation"), String.class, getFixedRateNotation(), this);
			processRosetta(path.newSubPath("fixedRateSchedule"), processor, Schedule.ScheduleBuilder.class, getFixedRateSchedule());
			processor.processBasic(path.newSubPath("spread"), BigDecimal.class, getSpread(), this);
			processRosetta(path.newSubPath("spreadCurrency"), processor, Currency.CurrencyBuilder.class, getSpreadCurrency());
			processor.processBasic(path.newSubPath("spreadNotation"), String.class, getSpreadNotation(), this);
			processor.processBasic(path.newSubPath("strikePrice"), BigDecimal.class, getStrikePrice(), this);
			processor.processBasic(path.newSubPath("strikePriceNotation"), String.class, getStrikePriceNotation(), this);
			processRosetta(path.newSubPath("strikePriceSchedule"), processor, Schedule.ScheduleBuilder.class, getStrikePriceSchedule());
			processRosetta(path.newSubPath("exchangeRate"), processor, ExchangeRate.ExchangeRateBuilder.class, getExchangeRate());
		}
		

		RegulatoryReportingProductPriceTerms.RegulatoryReportingProductPriceTermsBuilder prune();
	}

	/*********************** Immutable Implementation of RegulatoryReportingProductPriceTerms  ***********************/
	class RegulatoryReportingProductPriceTermsImpl implements RegulatoryReportingProductPriceTerms {
		private final List<BigDecimal> fixedRate;
		private final List<String> fixedRateNotation;
		private final List<? extends Schedule> fixedRateSchedule;
		private final List<BigDecimal> spread;
		private final List<? extends Currency> spreadCurrency;
		private final List<String> spreadNotation;
		private final List<BigDecimal> strikePrice;
		private final List<String> strikePriceNotation;
		private final List<? extends Schedule> strikePriceSchedule;
		private final List<? extends ExchangeRate> exchangeRate;
		
		protected RegulatoryReportingProductPriceTermsImpl(RegulatoryReportingProductPriceTerms.RegulatoryReportingProductPriceTermsBuilder builder) {
			this.fixedRate = ofNullable(builder.getFixedRate()).filter(_l->!_l.isEmpty()).map(ImmutableList::copyOf).orElse(null);
			this.fixedRateNotation = ofNullable(builder.getFixedRateNotation()).filter(_l->!_l.isEmpty()).map(ImmutableList::copyOf).orElse(null);
			this.fixedRateSchedule = ofNullable(builder.getFixedRateSchedule()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.spread = ofNullable(builder.getSpread()).filter(_l->!_l.isEmpty()).map(ImmutableList::copyOf).orElse(null);
			this.spreadCurrency = ofNullable(builder.getSpreadCurrency()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.spreadNotation = ofNullable(builder.getSpreadNotation()).filter(_l->!_l.isEmpty()).map(ImmutableList::copyOf).orElse(null);
			this.strikePrice = ofNullable(builder.getStrikePrice()).filter(_l->!_l.isEmpty()).map(ImmutableList::copyOf).orElse(null);
			this.strikePriceNotation = ofNullable(builder.getStrikePriceNotation()).filter(_l->!_l.isEmpty()).map(ImmutableList::copyOf).orElse(null);
			this.strikePriceSchedule = ofNullable(builder.getStrikePriceSchedule()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.exchangeRate = ofNullable(builder.getExchangeRate()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		@RosettaAttribute("fixedRate")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("fixedRate")
		public List<BigDecimal> getFixedRate() {
			return fixedRate;
		}
		
		@Override
		@RosettaAttribute("fixedRateNotation")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("fixedRateNotation")
		public List<String> getFixedRateNotation() {
			return fixedRateNotation;
		}
		
		@Override
		@RosettaAttribute("fixedRateSchedule")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("fixedRateSchedule")
		public List<? extends Schedule> getFixedRateSchedule() {
			return fixedRateSchedule;
		}
		
		@Override
		@RosettaAttribute("spread")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("spread")
		public List<BigDecimal> getSpread() {
			return spread;
		}
		
		@Override
		@RosettaAttribute("spreadCurrency")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("spreadCurrency")
		public List<? extends Currency> getSpreadCurrency() {
			return spreadCurrency;
		}
		
		@Override
		@RosettaAttribute("spreadNotation")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("spreadNotation")
		public List<String> getSpreadNotation() {
			return spreadNotation;
		}
		
		@Override
		@RosettaAttribute("strikePrice")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("strikePrice")
		public List<BigDecimal> getStrikePrice() {
			return strikePrice;
		}
		
		@Override
		@RosettaAttribute("strikePriceNotation")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("strikePriceNotation")
		public List<String> getStrikePriceNotation() {
			return strikePriceNotation;
		}
		
		@Override
		@RosettaAttribute("strikePriceSchedule")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("strikePriceSchedule")
		public List<? extends Schedule> getStrikePriceSchedule() {
			return strikePriceSchedule;
		}
		
		@Override
		@RosettaAttribute("exchangeRate")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("exchangeRate")
		public List<? extends ExchangeRate> getExchangeRate() {
			return exchangeRate;
		}
		
		@Override
		public RegulatoryReportingProductPriceTerms build() {
			return this;
		}
		
		@Override
		public RegulatoryReportingProductPriceTerms.RegulatoryReportingProductPriceTermsBuilder toBuilder() {
			RegulatoryReportingProductPriceTerms.RegulatoryReportingProductPriceTermsBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(RegulatoryReportingProductPriceTerms.RegulatoryReportingProductPriceTermsBuilder builder) {
			ofNullable(getFixedRate()).ifPresent(builder::setFixedRate);
			ofNullable(getFixedRateNotation()).ifPresent(builder::setFixedRateNotation);
			ofNullable(getFixedRateSchedule()).ifPresent(builder::setFixedRateSchedule);
			ofNullable(getSpread()).ifPresent(builder::setSpread);
			ofNullable(getSpreadCurrency()).ifPresent(builder::setSpreadCurrency);
			ofNullable(getSpreadNotation()).ifPresent(builder::setSpreadNotation);
			ofNullable(getStrikePrice()).ifPresent(builder::setStrikePrice);
			ofNullable(getStrikePriceNotation()).ifPresent(builder::setStrikePriceNotation);
			ofNullable(getStrikePriceSchedule()).ifPresent(builder::setStrikePriceSchedule);
			ofNullable(getExchangeRate()).ifPresent(builder::setExchangeRate);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			RegulatoryReportingProductPriceTerms _that = getType().cast(o);
		
			if (!ListEquals.listEquals(fixedRate, _that.getFixedRate())) return false;
			if (!ListEquals.listEquals(fixedRateNotation, _that.getFixedRateNotation())) return false;
			if (!ListEquals.listEquals(fixedRateSchedule, _that.getFixedRateSchedule())) return false;
			if (!ListEquals.listEquals(spread, _that.getSpread())) return false;
			if (!ListEquals.listEquals(spreadCurrency, _that.getSpreadCurrency())) return false;
			if (!ListEquals.listEquals(spreadNotation, _that.getSpreadNotation())) return false;
			if (!ListEquals.listEquals(strikePrice, _that.getStrikePrice())) return false;
			if (!ListEquals.listEquals(strikePriceNotation, _that.getStrikePriceNotation())) return false;
			if (!ListEquals.listEquals(strikePriceSchedule, _that.getStrikePriceSchedule())) return false;
			if (!ListEquals.listEquals(exchangeRate, _that.getExchangeRate())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (fixedRate != null ? fixedRate.hashCode() : 0);
			_result = 31 * _result + (fixedRateNotation != null ? fixedRateNotation.hashCode() : 0);
			_result = 31 * _result + (fixedRateSchedule != null ? fixedRateSchedule.hashCode() : 0);
			_result = 31 * _result + (spread != null ? spread.hashCode() : 0);
			_result = 31 * _result + (spreadCurrency != null ? spreadCurrency.hashCode() : 0);
			_result = 31 * _result + (spreadNotation != null ? spreadNotation.hashCode() : 0);
			_result = 31 * _result + (strikePrice != null ? strikePrice.hashCode() : 0);
			_result = 31 * _result + (strikePriceNotation != null ? strikePriceNotation.hashCode() : 0);
			_result = 31 * _result + (strikePriceSchedule != null ? strikePriceSchedule.hashCode() : 0);
			_result = 31 * _result + (exchangeRate != null ? exchangeRate.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "RegulatoryReportingProductPriceTerms {" +
				"fixedRate=" + this.fixedRate + ", " +
				"fixedRateNotation=" + this.fixedRateNotation + ", " +
				"fixedRateSchedule=" + this.fixedRateSchedule + ", " +
				"spread=" + this.spread + ", " +
				"spreadCurrency=" + this.spreadCurrency + ", " +
				"spreadNotation=" + this.spreadNotation + ", " +
				"strikePrice=" + this.strikePrice + ", " +
				"strikePriceNotation=" + this.strikePriceNotation + ", " +
				"strikePriceSchedule=" + this.strikePriceSchedule + ", " +
				"exchangeRate=" + this.exchangeRate +
			'}';
		}
	}

	/*********************** Builder Implementation of RegulatoryReportingProductPriceTerms  ***********************/
	class RegulatoryReportingProductPriceTermsBuilderImpl implements RegulatoryReportingProductPriceTerms.RegulatoryReportingProductPriceTermsBuilder {
	
		protected List<BigDecimal> fixedRate = new ArrayList<>();
		protected List<String> fixedRateNotation = new ArrayList<>();
		protected List<Schedule.ScheduleBuilder> fixedRateSchedule = new ArrayList<>();
		protected List<BigDecimal> spread = new ArrayList<>();
		protected List<Currency.CurrencyBuilder> spreadCurrency = new ArrayList<>();
		protected List<String> spreadNotation = new ArrayList<>();
		protected List<BigDecimal> strikePrice = new ArrayList<>();
		protected List<String> strikePriceNotation = new ArrayList<>();
		protected List<Schedule.ScheduleBuilder> strikePriceSchedule = new ArrayList<>();
		protected List<ExchangeRate.ExchangeRateBuilder> exchangeRate = new ArrayList<>();
		
		@Override
		@RosettaAttribute("fixedRate")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("fixedRate")
		public List<BigDecimal> getFixedRate() {
			return fixedRate;
		}
		
		@Override
		@RosettaAttribute("fixedRateNotation")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("fixedRateNotation")
		public List<String> getFixedRateNotation() {
			return fixedRateNotation;
		}
		
		@Override
		@RosettaAttribute("fixedRateSchedule")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("fixedRateSchedule")
		public List<? extends Schedule.ScheduleBuilder> getFixedRateSchedule() {
			return fixedRateSchedule;
		}
		
		@Override
		public Schedule.ScheduleBuilder getOrCreateFixedRateSchedule(int index) {
			if (fixedRateSchedule==null) {
				this.fixedRateSchedule = new ArrayList<>();
			}
			return getIndex(fixedRateSchedule, index, () -> {
						Schedule.ScheduleBuilder newFixedRateSchedule = Schedule.builder();
						return newFixedRateSchedule;
					});
		}
		
		@Override
		@RosettaAttribute("spread")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("spread")
		public List<BigDecimal> getSpread() {
			return spread;
		}
		
		@Override
		@RosettaAttribute("spreadCurrency")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("spreadCurrency")
		public List<? extends Currency.CurrencyBuilder> getSpreadCurrency() {
			return spreadCurrency;
		}
		
		@Override
		public Currency.CurrencyBuilder getOrCreateSpreadCurrency(int index) {
			if (spreadCurrency==null) {
				this.spreadCurrency = new ArrayList<>();
			}
			return getIndex(spreadCurrency, index, () -> {
						Currency.CurrencyBuilder newSpreadCurrency = Currency.builder();
						return newSpreadCurrency;
					});
		}
		
		@Override
		@RosettaAttribute("spreadNotation")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("spreadNotation")
		public List<String> getSpreadNotation() {
			return spreadNotation;
		}
		
		@Override
		@RosettaAttribute("strikePrice")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("strikePrice")
		public List<BigDecimal> getStrikePrice() {
			return strikePrice;
		}
		
		@Override
		@RosettaAttribute("strikePriceNotation")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("strikePriceNotation")
		public List<String> getStrikePriceNotation() {
			return strikePriceNotation;
		}
		
		@Override
		@RosettaAttribute("strikePriceSchedule")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("strikePriceSchedule")
		public List<? extends Schedule.ScheduleBuilder> getStrikePriceSchedule() {
			return strikePriceSchedule;
		}
		
		@Override
		public Schedule.ScheduleBuilder getOrCreateStrikePriceSchedule(int index) {
			if (strikePriceSchedule==null) {
				this.strikePriceSchedule = new ArrayList<>();
			}
			return getIndex(strikePriceSchedule, index, () -> {
						Schedule.ScheduleBuilder newStrikePriceSchedule = Schedule.builder();
						return newStrikePriceSchedule;
					});
		}
		
		@Override
		@RosettaAttribute("exchangeRate")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("exchangeRate")
		public List<? extends ExchangeRate.ExchangeRateBuilder> getExchangeRate() {
			return exchangeRate;
		}
		
		@Override
		public ExchangeRate.ExchangeRateBuilder getOrCreateExchangeRate(int index) {
			if (exchangeRate==null) {
				this.exchangeRate = new ArrayList<>();
			}
			return getIndex(exchangeRate, index, () -> {
						ExchangeRate.ExchangeRateBuilder newExchangeRate = ExchangeRate.builder();
						return newExchangeRate;
					});
		}
		
		@RosettaAttribute("fixedRate")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("fixedRate")
		@Override
		public RegulatoryReportingProductPriceTerms.RegulatoryReportingProductPriceTermsBuilder addFixedRate(BigDecimal _fixedRate) {
			if (_fixedRate != null) {
				this.fixedRate.add(_fixedRate);
			}
			return this;
		}
		
		@Override
		public RegulatoryReportingProductPriceTerms.RegulatoryReportingProductPriceTermsBuilder addFixedRate(BigDecimal _fixedRate, int idx) {
			getIndex(this.fixedRate, idx, () -> _fixedRate);
			return this;
		}
		
		@Override
		public RegulatoryReportingProductPriceTerms.RegulatoryReportingProductPriceTermsBuilder addFixedRate(List<BigDecimal> fixedRates) {
			if (fixedRates != null) {
				for (final BigDecimal toAdd : fixedRates) {
					this.fixedRate.add(toAdd);
				}
			}
			return this;
		}
		
		@RosettaAttribute("fixedRate")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("fixedRate")
		@Override
		public RegulatoryReportingProductPriceTerms.RegulatoryReportingProductPriceTermsBuilder setFixedRate(List<BigDecimal> fixedRates) {
			if (fixedRates == null) {
				this.fixedRate = new ArrayList<>();
			} else {
				this.fixedRate = fixedRates.stream()
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("fixedRateNotation")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("fixedRateNotation")
		@Override
		public RegulatoryReportingProductPriceTerms.RegulatoryReportingProductPriceTermsBuilder addFixedRateNotation(String _fixedRateNotation) {
			if (_fixedRateNotation != null) {
				this.fixedRateNotation.add(_fixedRateNotation);
			}
			return this;
		}
		
		@Override
		public RegulatoryReportingProductPriceTerms.RegulatoryReportingProductPriceTermsBuilder addFixedRateNotation(String _fixedRateNotation, int idx) {
			getIndex(this.fixedRateNotation, idx, () -> _fixedRateNotation);
			return this;
		}
		
		@Override
		public RegulatoryReportingProductPriceTerms.RegulatoryReportingProductPriceTermsBuilder addFixedRateNotation(List<String> fixedRateNotations) {
			if (fixedRateNotations != null) {
				for (final String toAdd : fixedRateNotations) {
					this.fixedRateNotation.add(toAdd);
				}
			}
			return this;
		}
		
		@RosettaAttribute("fixedRateNotation")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("fixedRateNotation")
		@Override
		public RegulatoryReportingProductPriceTerms.RegulatoryReportingProductPriceTermsBuilder setFixedRateNotation(List<String> fixedRateNotations) {
			if (fixedRateNotations == null) {
				this.fixedRateNotation = new ArrayList<>();
			} else {
				this.fixedRateNotation = fixedRateNotations.stream()
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("fixedRateSchedule")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("fixedRateSchedule")
		@Override
		public RegulatoryReportingProductPriceTerms.RegulatoryReportingProductPriceTermsBuilder addFixedRateSchedule(Schedule _fixedRateSchedule) {
			if (_fixedRateSchedule != null) {
				this.fixedRateSchedule.add(_fixedRateSchedule.toBuilder());
			}
			return this;
		}
		
		@Override
		public RegulatoryReportingProductPriceTerms.RegulatoryReportingProductPriceTermsBuilder addFixedRateSchedule(Schedule _fixedRateSchedule, int idx) {
			getIndex(this.fixedRateSchedule, idx, () -> _fixedRateSchedule.toBuilder());
			return this;
		}
		
		@Override
		public RegulatoryReportingProductPriceTerms.RegulatoryReportingProductPriceTermsBuilder addFixedRateSchedule(List<? extends Schedule> fixedRateSchedules) {
			if (fixedRateSchedules != null) {
				for (final Schedule toAdd : fixedRateSchedules) {
					this.fixedRateSchedule.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("fixedRateSchedule")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("fixedRateSchedule")
		@Override
		public RegulatoryReportingProductPriceTerms.RegulatoryReportingProductPriceTermsBuilder setFixedRateSchedule(List<? extends Schedule> fixedRateSchedules) {
			if (fixedRateSchedules == null) {
				this.fixedRateSchedule = new ArrayList<>();
			} else {
				this.fixedRateSchedule = fixedRateSchedules.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("spread")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("spread")
		@Override
		public RegulatoryReportingProductPriceTerms.RegulatoryReportingProductPriceTermsBuilder addSpread(BigDecimal _spread) {
			if (_spread != null) {
				this.spread.add(_spread);
			}
			return this;
		}
		
		@Override
		public RegulatoryReportingProductPriceTerms.RegulatoryReportingProductPriceTermsBuilder addSpread(BigDecimal _spread, int idx) {
			getIndex(this.spread, idx, () -> _spread);
			return this;
		}
		
		@Override
		public RegulatoryReportingProductPriceTerms.RegulatoryReportingProductPriceTermsBuilder addSpread(List<BigDecimal> spreads) {
			if (spreads != null) {
				for (final BigDecimal toAdd : spreads) {
					this.spread.add(toAdd);
				}
			}
			return this;
		}
		
		@RosettaAttribute("spread")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("spread")
		@Override
		public RegulatoryReportingProductPriceTerms.RegulatoryReportingProductPriceTermsBuilder setSpread(List<BigDecimal> spreads) {
			if (spreads == null) {
				this.spread = new ArrayList<>();
			} else {
				this.spread = spreads.stream()
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("spreadCurrency")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("spreadCurrency")
		@Override
		public RegulatoryReportingProductPriceTerms.RegulatoryReportingProductPriceTermsBuilder addSpreadCurrency(Currency _spreadCurrency) {
			if (_spreadCurrency != null) {
				this.spreadCurrency.add(_spreadCurrency.toBuilder());
			}
			return this;
		}
		
		@Override
		public RegulatoryReportingProductPriceTerms.RegulatoryReportingProductPriceTermsBuilder addSpreadCurrency(Currency _spreadCurrency, int idx) {
			getIndex(this.spreadCurrency, idx, () -> _spreadCurrency.toBuilder());
			return this;
		}
		
		@Override
		public RegulatoryReportingProductPriceTerms.RegulatoryReportingProductPriceTermsBuilder addSpreadCurrency(List<? extends Currency> spreadCurrencys) {
			if (spreadCurrencys != null) {
				for (final Currency toAdd : spreadCurrencys) {
					this.spreadCurrency.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("spreadCurrency")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("spreadCurrency")
		@Override
		public RegulatoryReportingProductPriceTerms.RegulatoryReportingProductPriceTermsBuilder setSpreadCurrency(List<? extends Currency> spreadCurrencys) {
			if (spreadCurrencys == null) {
				this.spreadCurrency = new ArrayList<>();
			} else {
				this.spreadCurrency = spreadCurrencys.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("spreadNotation")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("spreadNotation")
		@Override
		public RegulatoryReportingProductPriceTerms.RegulatoryReportingProductPriceTermsBuilder addSpreadNotation(String _spreadNotation) {
			if (_spreadNotation != null) {
				this.spreadNotation.add(_spreadNotation);
			}
			return this;
		}
		
		@Override
		public RegulatoryReportingProductPriceTerms.RegulatoryReportingProductPriceTermsBuilder addSpreadNotation(String _spreadNotation, int idx) {
			getIndex(this.spreadNotation, idx, () -> _spreadNotation);
			return this;
		}
		
		@Override
		public RegulatoryReportingProductPriceTerms.RegulatoryReportingProductPriceTermsBuilder addSpreadNotation(List<String> spreadNotations) {
			if (spreadNotations != null) {
				for (final String toAdd : spreadNotations) {
					this.spreadNotation.add(toAdd);
				}
			}
			return this;
		}
		
		@RosettaAttribute("spreadNotation")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("spreadNotation")
		@Override
		public RegulatoryReportingProductPriceTerms.RegulatoryReportingProductPriceTermsBuilder setSpreadNotation(List<String> spreadNotations) {
			if (spreadNotations == null) {
				this.spreadNotation = new ArrayList<>();
			} else {
				this.spreadNotation = spreadNotations.stream()
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("strikePrice")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("strikePrice")
		@Override
		public RegulatoryReportingProductPriceTerms.RegulatoryReportingProductPriceTermsBuilder addStrikePrice(BigDecimal _strikePrice) {
			if (_strikePrice != null) {
				this.strikePrice.add(_strikePrice);
			}
			return this;
		}
		
		@Override
		public RegulatoryReportingProductPriceTerms.RegulatoryReportingProductPriceTermsBuilder addStrikePrice(BigDecimal _strikePrice, int idx) {
			getIndex(this.strikePrice, idx, () -> _strikePrice);
			return this;
		}
		
		@Override
		public RegulatoryReportingProductPriceTerms.RegulatoryReportingProductPriceTermsBuilder addStrikePrice(List<BigDecimal> strikePrices) {
			if (strikePrices != null) {
				for (final BigDecimal toAdd : strikePrices) {
					this.strikePrice.add(toAdd);
				}
			}
			return this;
		}
		
		@RosettaAttribute("strikePrice")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("strikePrice")
		@Override
		public RegulatoryReportingProductPriceTerms.RegulatoryReportingProductPriceTermsBuilder setStrikePrice(List<BigDecimal> strikePrices) {
			if (strikePrices == null) {
				this.strikePrice = new ArrayList<>();
			} else {
				this.strikePrice = strikePrices.stream()
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("strikePriceNotation")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("strikePriceNotation")
		@Override
		public RegulatoryReportingProductPriceTerms.RegulatoryReportingProductPriceTermsBuilder addStrikePriceNotation(String _strikePriceNotation) {
			if (_strikePriceNotation != null) {
				this.strikePriceNotation.add(_strikePriceNotation);
			}
			return this;
		}
		
		@Override
		public RegulatoryReportingProductPriceTerms.RegulatoryReportingProductPriceTermsBuilder addStrikePriceNotation(String _strikePriceNotation, int idx) {
			getIndex(this.strikePriceNotation, idx, () -> _strikePriceNotation);
			return this;
		}
		
		@Override
		public RegulatoryReportingProductPriceTerms.RegulatoryReportingProductPriceTermsBuilder addStrikePriceNotation(List<String> strikePriceNotations) {
			if (strikePriceNotations != null) {
				for (final String toAdd : strikePriceNotations) {
					this.strikePriceNotation.add(toAdd);
				}
			}
			return this;
		}
		
		@RosettaAttribute("strikePriceNotation")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("strikePriceNotation")
		@Override
		public RegulatoryReportingProductPriceTerms.RegulatoryReportingProductPriceTermsBuilder setStrikePriceNotation(List<String> strikePriceNotations) {
			if (strikePriceNotations == null) {
				this.strikePriceNotation = new ArrayList<>();
			} else {
				this.strikePriceNotation = strikePriceNotations.stream()
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("strikePriceSchedule")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("strikePriceSchedule")
		@Override
		public RegulatoryReportingProductPriceTerms.RegulatoryReportingProductPriceTermsBuilder addStrikePriceSchedule(Schedule _strikePriceSchedule) {
			if (_strikePriceSchedule != null) {
				this.strikePriceSchedule.add(_strikePriceSchedule.toBuilder());
			}
			return this;
		}
		
		@Override
		public RegulatoryReportingProductPriceTerms.RegulatoryReportingProductPriceTermsBuilder addStrikePriceSchedule(Schedule _strikePriceSchedule, int idx) {
			getIndex(this.strikePriceSchedule, idx, () -> _strikePriceSchedule.toBuilder());
			return this;
		}
		
		@Override
		public RegulatoryReportingProductPriceTerms.RegulatoryReportingProductPriceTermsBuilder addStrikePriceSchedule(List<? extends Schedule> strikePriceSchedules) {
			if (strikePriceSchedules != null) {
				for (final Schedule toAdd : strikePriceSchedules) {
					this.strikePriceSchedule.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("strikePriceSchedule")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("strikePriceSchedule")
		@Override
		public RegulatoryReportingProductPriceTerms.RegulatoryReportingProductPriceTermsBuilder setStrikePriceSchedule(List<? extends Schedule> strikePriceSchedules) {
			if (strikePriceSchedules == null) {
				this.strikePriceSchedule = new ArrayList<>();
			} else {
				this.strikePriceSchedule = strikePriceSchedules.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("exchangeRate")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("exchangeRate")
		@Override
		public RegulatoryReportingProductPriceTerms.RegulatoryReportingProductPriceTermsBuilder addExchangeRate(ExchangeRate _exchangeRate) {
			if (_exchangeRate != null) {
				this.exchangeRate.add(_exchangeRate.toBuilder());
			}
			return this;
		}
		
		@Override
		public RegulatoryReportingProductPriceTerms.RegulatoryReportingProductPriceTermsBuilder addExchangeRate(ExchangeRate _exchangeRate, int idx) {
			getIndex(this.exchangeRate, idx, () -> _exchangeRate.toBuilder());
			return this;
		}
		
		@Override
		public RegulatoryReportingProductPriceTerms.RegulatoryReportingProductPriceTermsBuilder addExchangeRate(List<? extends ExchangeRate> exchangeRates) {
			if (exchangeRates != null) {
				for (final ExchangeRate toAdd : exchangeRates) {
					this.exchangeRate.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("exchangeRate")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("exchangeRate")
		@Override
		public RegulatoryReportingProductPriceTerms.RegulatoryReportingProductPriceTermsBuilder setExchangeRate(List<? extends ExchangeRate> exchangeRates) {
			if (exchangeRates == null) {
				this.exchangeRate = new ArrayList<>();
			} else {
				this.exchangeRate = exchangeRates.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		public RegulatoryReportingProductPriceTerms build() {
			return new RegulatoryReportingProductPriceTerms.RegulatoryReportingProductPriceTermsImpl(this);
		}
		
		@Override
		public RegulatoryReportingProductPriceTerms.RegulatoryReportingProductPriceTermsBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public RegulatoryReportingProductPriceTerms.RegulatoryReportingProductPriceTermsBuilder prune() {
			fixedRateSchedule = fixedRateSchedule.stream().filter(b->b!=null).<Schedule.ScheduleBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			spreadCurrency = spreadCurrency.stream().filter(b->b!=null).<Currency.CurrencyBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			strikePriceSchedule = strikePriceSchedule.stream().filter(b->b!=null).<Schedule.ScheduleBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			exchangeRate = exchangeRate.stream().filter(b->b!=null).<ExchangeRate.ExchangeRateBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getFixedRate()!=null && !getFixedRate().isEmpty()) return true;
			if (getFixedRateNotation()!=null && !getFixedRateNotation().isEmpty()) return true;
			if (getFixedRateSchedule()!=null && getFixedRateSchedule().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getSpread()!=null && !getSpread().isEmpty()) return true;
			if (getSpreadCurrency()!=null && getSpreadCurrency().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getSpreadNotation()!=null && !getSpreadNotation().isEmpty()) return true;
			if (getStrikePrice()!=null && !getStrikePrice().isEmpty()) return true;
			if (getStrikePriceNotation()!=null && !getStrikePriceNotation().isEmpty()) return true;
			if (getStrikePriceSchedule()!=null && getStrikePriceSchedule().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getExchangeRate()!=null && getExchangeRate().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public RegulatoryReportingProductPriceTerms.RegulatoryReportingProductPriceTermsBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			RegulatoryReportingProductPriceTerms.RegulatoryReportingProductPriceTermsBuilder o = (RegulatoryReportingProductPriceTerms.RegulatoryReportingProductPriceTermsBuilder) other;
			
			merger.mergeRosetta(getFixedRateSchedule(), o.getFixedRateSchedule(), this::getOrCreateFixedRateSchedule);
			merger.mergeRosetta(getSpreadCurrency(), o.getSpreadCurrency(), this::getOrCreateSpreadCurrency);
			merger.mergeRosetta(getStrikePriceSchedule(), o.getStrikePriceSchedule(), this::getOrCreateStrikePriceSchedule);
			merger.mergeRosetta(getExchangeRate(), o.getExchangeRate(), this::getOrCreateExchangeRate);
			
			merger.mergeBasic(getFixedRate(), o.getFixedRate(), (Consumer<BigDecimal>) this::addFixedRate);
			merger.mergeBasic(getFixedRateNotation(), o.getFixedRateNotation(), (Consumer<String>) this::addFixedRateNotation);
			merger.mergeBasic(getSpread(), o.getSpread(), (Consumer<BigDecimal>) this::addSpread);
			merger.mergeBasic(getSpreadNotation(), o.getSpreadNotation(), (Consumer<String>) this::addSpreadNotation);
			merger.mergeBasic(getStrikePrice(), o.getStrikePrice(), (Consumer<BigDecimal>) this::addStrikePrice);
			merger.mergeBasic(getStrikePriceNotation(), o.getStrikePriceNotation(), (Consumer<String>) this::addStrikePriceNotation);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			RegulatoryReportingProductPriceTerms _that = getType().cast(o);
		
			if (!ListEquals.listEquals(fixedRate, _that.getFixedRate())) return false;
			if (!ListEquals.listEquals(fixedRateNotation, _that.getFixedRateNotation())) return false;
			if (!ListEquals.listEquals(fixedRateSchedule, _that.getFixedRateSchedule())) return false;
			if (!ListEquals.listEquals(spread, _that.getSpread())) return false;
			if (!ListEquals.listEquals(spreadCurrency, _that.getSpreadCurrency())) return false;
			if (!ListEquals.listEquals(spreadNotation, _that.getSpreadNotation())) return false;
			if (!ListEquals.listEquals(strikePrice, _that.getStrikePrice())) return false;
			if (!ListEquals.listEquals(strikePriceNotation, _that.getStrikePriceNotation())) return false;
			if (!ListEquals.listEquals(strikePriceSchedule, _that.getStrikePriceSchedule())) return false;
			if (!ListEquals.listEquals(exchangeRate, _that.getExchangeRate())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (fixedRate != null ? fixedRate.hashCode() : 0);
			_result = 31 * _result + (fixedRateNotation != null ? fixedRateNotation.hashCode() : 0);
			_result = 31 * _result + (fixedRateSchedule != null ? fixedRateSchedule.hashCode() : 0);
			_result = 31 * _result + (spread != null ? spread.hashCode() : 0);
			_result = 31 * _result + (spreadCurrency != null ? spreadCurrency.hashCode() : 0);
			_result = 31 * _result + (spreadNotation != null ? spreadNotation.hashCode() : 0);
			_result = 31 * _result + (strikePrice != null ? strikePrice.hashCode() : 0);
			_result = 31 * _result + (strikePriceNotation != null ? strikePriceNotation.hashCode() : 0);
			_result = 31 * _result + (strikePriceSchedule != null ? strikePriceSchedule.hashCode() : 0);
			_result = 31 * _result + (exchangeRate != null ? exchangeRate.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "RegulatoryReportingProductPriceTermsBuilder {" +
				"fixedRate=" + this.fixedRate + ", " +
				"fixedRateNotation=" + this.fixedRateNotation + ", " +
				"fixedRateSchedule=" + this.fixedRateSchedule + ", " +
				"spread=" + this.spread + ", " +
				"spreadCurrency=" + this.spreadCurrency + ", " +
				"spreadNotation=" + this.spreadNotation + ", " +
				"strikePrice=" + this.strikePrice + ", " +
				"strikePriceNotation=" + this.strikePriceNotation + ", " +
				"strikePriceSchedule=" + this.strikePriceSchedule + ", " +
				"exchangeRate=" + this.exchangeRate +
			'}';
		}
	}
}

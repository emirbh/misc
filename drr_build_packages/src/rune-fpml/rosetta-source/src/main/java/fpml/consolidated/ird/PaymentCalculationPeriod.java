package fpml.consolidated.ird;

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
import fpml.consolidated.ird.meta.PaymentCalculationPeriodMeta;
import fpml.consolidated.shared.Money;
import java.math.BigDecimal;
import java.time.ZonedDateTime;
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
 * Provision A type defining the adjusted payment date and associated calculation period parameters required to calculate the actual or projected payment amount. This type forms part of the cashflow representation of a swap stream.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision A type defining the adjusted payment date and associated calculation period parameters required to calculate the actual or projected payment amount. This type forms part of the cashflow representation of a swap stream.
 *
 */
@RosettaDataType(value="PaymentCalculationPeriod", builder=PaymentCalculationPeriod.PaymentCalculationPeriodBuilderImpl.class, version="2.1.1")
@RuneDataType(value="PaymentCalculationPeriod", model="fpml", builder=PaymentCalculationPeriod.PaymentCalculationPeriodBuilderImpl.class, version="2.1.1")
public interface PaymentCalculationPeriod extends RosettaModelObject {

	PaymentCalculationPeriodMeta metaData = new PaymentCalculationPeriodMeta();

	/*********************** Getter Methods  ***********************/
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
	String getId();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Attribute that can be used to reference the yield curve used to estimate the discount factor.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Attribute that can be used to reference the yield curve used to estimate the discount factor.
	 *
	 */
	String getHref();
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
	ZonedDateTime getUnadjustedPaymentDate();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The adjusted payment date. This date should already be adjusted for any applicable business day convention. This component is not intended for use in trade confirmation but may be specified to allow the fee structure to also serve as a cashflow type component (all dates the Cashflows type are adjusted payment dates).
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The adjusted payment date. This date should already be adjusted for any applicable business day convention. This component is not intended for use in trade confirmation but may be specified to allow the fee structure to also serve as a cashflow type component (all dates the Cashflows type are adjusted payment dates).
	 *
	 */
	ZonedDateTime getAdjustedPaymentDate();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The parameters used in the calculation of a fixed or floating rate calculation period amount. A list of calculation period elements may be ordered in the document by ascending start date. An FpML document which contains an unordered list of calcularion periods is still regarded as a conformant document.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The parameters used in the calculation of a fixed or floating rate calculation period amount. A list of calculation period elements may be ordered in the document by ascending start date. An FpML document which contains an unordered list of calcularion periods is still regarded as a conformant document.
	 *
	 */
	List<? extends CalculationPeriod> getCalculationPeriod();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision A known fixed payment amount.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A known fixed payment amount.
	 *
	 */
	BigDecimal getFixedPaymentAmount();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision A decimal value representing the discount factor used to calculate the present value of cash flow.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A decimal value representing the discount factor used to calculate the present value of cash flow.
	 *
	 */
	BigDecimal getDiscountFactor();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision A monetary amount representing the forecast of the future value of the payment.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A monetary amount representing the forecast of the future value of the payment.
	 *
	 */
	Money getForecastPaymentAmount();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision A monetary amount representing the present value of the forecast payment.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A monetary amount representing the present value of the forecast payment.
	 *
	 */
	Money getPresentValueAmount();

	/*********************** Build Methods  ***********************/
	PaymentCalculationPeriod build();
	
	PaymentCalculationPeriod.PaymentCalculationPeriodBuilder toBuilder();
	
	static PaymentCalculationPeriod.PaymentCalculationPeriodBuilder builder() {
		return new PaymentCalculationPeriod.PaymentCalculationPeriodBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends PaymentCalculationPeriod> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends PaymentCalculationPeriod> getType() {
		return PaymentCalculationPeriod.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		processor.processBasic(path.newSubPath("href"), String.class, getHref(), this);
		processor.processBasic(path.newSubPath("unadjustedPaymentDate"), ZonedDateTime.class, getUnadjustedPaymentDate(), this);
		processor.processBasic(path.newSubPath("adjustedPaymentDate"), ZonedDateTime.class, getAdjustedPaymentDate(), this);
		processRosetta(path.newSubPath("calculationPeriod"), processor, CalculationPeriod.class, getCalculationPeriod());
		processor.processBasic(path.newSubPath("fixedPaymentAmount"), BigDecimal.class, getFixedPaymentAmount(), this);
		processor.processBasic(path.newSubPath("discountFactor"), BigDecimal.class, getDiscountFactor(), this);
		processRosetta(path.newSubPath("forecastPaymentAmount"), processor, Money.class, getForecastPaymentAmount());
		processRosetta(path.newSubPath("presentValueAmount"), processor, Money.class, getPresentValueAmount());
	}
	

	/*********************** Builder Interface  ***********************/
	interface PaymentCalculationPeriodBuilder extends PaymentCalculationPeriod, RosettaModelObjectBuilder {
		CalculationPeriod.CalculationPeriodBuilder getOrCreateCalculationPeriod(int index);
		@Override
		List<? extends CalculationPeriod.CalculationPeriodBuilder> getCalculationPeriod();
		Money.MoneyBuilder getOrCreateForecastPaymentAmount();
		@Override
		Money.MoneyBuilder getForecastPaymentAmount();
		Money.MoneyBuilder getOrCreatePresentValueAmount();
		@Override
		Money.MoneyBuilder getPresentValueAmount();
		PaymentCalculationPeriod.PaymentCalculationPeriodBuilder setId(String id);
		PaymentCalculationPeriod.PaymentCalculationPeriodBuilder setHref(String href);
		PaymentCalculationPeriod.PaymentCalculationPeriodBuilder setUnadjustedPaymentDate(ZonedDateTime unadjustedPaymentDate);
		PaymentCalculationPeriod.PaymentCalculationPeriodBuilder setAdjustedPaymentDate(ZonedDateTime adjustedPaymentDate);
		PaymentCalculationPeriod.PaymentCalculationPeriodBuilder addCalculationPeriod(CalculationPeriod calculationPeriod);
		PaymentCalculationPeriod.PaymentCalculationPeriodBuilder addCalculationPeriod(CalculationPeriod calculationPeriod, int idx);
		PaymentCalculationPeriod.PaymentCalculationPeriodBuilder addCalculationPeriod(List<? extends CalculationPeriod> calculationPeriod);
		PaymentCalculationPeriod.PaymentCalculationPeriodBuilder setCalculationPeriod(List<? extends CalculationPeriod> calculationPeriod);
		PaymentCalculationPeriod.PaymentCalculationPeriodBuilder setFixedPaymentAmount(BigDecimal fixedPaymentAmount);
		PaymentCalculationPeriod.PaymentCalculationPeriodBuilder setDiscountFactor(BigDecimal discountFactor);
		PaymentCalculationPeriod.PaymentCalculationPeriodBuilder setForecastPaymentAmount(Money forecastPaymentAmount);
		PaymentCalculationPeriod.PaymentCalculationPeriodBuilder setPresentValueAmount(Money presentValueAmount);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
			processor.processBasic(path.newSubPath("href"), String.class, getHref(), this);
			processor.processBasic(path.newSubPath("unadjustedPaymentDate"), ZonedDateTime.class, getUnadjustedPaymentDate(), this);
			processor.processBasic(path.newSubPath("adjustedPaymentDate"), ZonedDateTime.class, getAdjustedPaymentDate(), this);
			processRosetta(path.newSubPath("calculationPeriod"), processor, CalculationPeriod.CalculationPeriodBuilder.class, getCalculationPeriod());
			processor.processBasic(path.newSubPath("fixedPaymentAmount"), BigDecimal.class, getFixedPaymentAmount(), this);
			processor.processBasic(path.newSubPath("discountFactor"), BigDecimal.class, getDiscountFactor(), this);
			processRosetta(path.newSubPath("forecastPaymentAmount"), processor, Money.MoneyBuilder.class, getForecastPaymentAmount());
			processRosetta(path.newSubPath("presentValueAmount"), processor, Money.MoneyBuilder.class, getPresentValueAmount());
		}
		

		PaymentCalculationPeriod.PaymentCalculationPeriodBuilder prune();
	}

	/*********************** Immutable Implementation of PaymentCalculationPeriod  ***********************/
	class PaymentCalculationPeriodImpl implements PaymentCalculationPeriod {
		private final String id;
		private final String href;
		private final ZonedDateTime unadjustedPaymentDate;
		private final ZonedDateTime adjustedPaymentDate;
		private final List<? extends CalculationPeriod> calculationPeriod;
		private final BigDecimal fixedPaymentAmount;
		private final BigDecimal discountFactor;
		private final Money forecastPaymentAmount;
		private final Money presentValueAmount;
		
		protected PaymentCalculationPeriodImpl(PaymentCalculationPeriod.PaymentCalculationPeriodBuilder builder) {
			this.id = builder.getId();
			this.href = builder.getHref();
			this.unadjustedPaymentDate = builder.getUnadjustedPaymentDate();
			this.adjustedPaymentDate = builder.getAdjustedPaymentDate();
			this.calculationPeriod = ofNullable(builder.getCalculationPeriod()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.fixedPaymentAmount = builder.getFixedPaymentAmount();
			this.discountFactor = builder.getDiscountFactor();
			this.forecastPaymentAmount = ofNullable(builder.getForecastPaymentAmount()).map(f->f.build()).orElse(null);
			this.presentValueAmount = ofNullable(builder.getPresentValueAmount()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("id")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("id")
		public String getId() {
			return id;
		}
		
		@Override
		@RosettaAttribute("href")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("href")
		public String getHref() {
			return href;
		}
		
		@Override
		@RosettaAttribute("unadjustedPaymentDate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("unadjustedPaymentDate")
		public ZonedDateTime getUnadjustedPaymentDate() {
			return unadjustedPaymentDate;
		}
		
		@Override
		@RosettaAttribute("adjustedPaymentDate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("adjustedPaymentDate")
		public ZonedDateTime getAdjustedPaymentDate() {
			return adjustedPaymentDate;
		}
		
		@Override
		@RosettaAttribute("calculationPeriod")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("calculationPeriod")
		public List<? extends CalculationPeriod> getCalculationPeriod() {
			return calculationPeriod;
		}
		
		@Override
		@RosettaAttribute("fixedPaymentAmount")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("fixedPaymentAmount")
		public BigDecimal getFixedPaymentAmount() {
			return fixedPaymentAmount;
		}
		
		@Override
		@RosettaAttribute("discountFactor")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("discountFactor")
		public BigDecimal getDiscountFactor() {
			return discountFactor;
		}
		
		@Override
		@RosettaAttribute("forecastPaymentAmount")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("forecastPaymentAmount")
		public Money getForecastPaymentAmount() {
			return forecastPaymentAmount;
		}
		
		@Override
		@RosettaAttribute("presentValueAmount")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("presentValueAmount")
		public Money getPresentValueAmount() {
			return presentValueAmount;
		}
		
		@Override
		public PaymentCalculationPeriod build() {
			return this;
		}
		
		@Override
		public PaymentCalculationPeriod.PaymentCalculationPeriodBuilder toBuilder() {
			PaymentCalculationPeriod.PaymentCalculationPeriodBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(PaymentCalculationPeriod.PaymentCalculationPeriodBuilder builder) {
			ofNullable(getId()).ifPresent(builder::setId);
			ofNullable(getHref()).ifPresent(builder::setHref);
			ofNullable(getUnadjustedPaymentDate()).ifPresent(builder::setUnadjustedPaymentDate);
			ofNullable(getAdjustedPaymentDate()).ifPresent(builder::setAdjustedPaymentDate);
			ofNullable(getCalculationPeriod()).ifPresent(builder::setCalculationPeriod);
			ofNullable(getFixedPaymentAmount()).ifPresent(builder::setFixedPaymentAmount);
			ofNullable(getDiscountFactor()).ifPresent(builder::setDiscountFactor);
			ofNullable(getForecastPaymentAmount()).ifPresent(builder::setForecastPaymentAmount);
			ofNullable(getPresentValueAmount()).ifPresent(builder::setPresentValueAmount);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			PaymentCalculationPeriod _that = getType().cast(o);
		
			if (!Objects.equals(id, _that.getId())) return false;
			if (!Objects.equals(href, _that.getHref())) return false;
			if (!Objects.equals(unadjustedPaymentDate, _that.getUnadjustedPaymentDate())) return false;
			if (!Objects.equals(adjustedPaymentDate, _that.getAdjustedPaymentDate())) return false;
			if (!ListEquals.listEquals(calculationPeriod, _that.getCalculationPeriod())) return false;
			if (!Objects.equals(fixedPaymentAmount, _that.getFixedPaymentAmount())) return false;
			if (!Objects.equals(discountFactor, _that.getDiscountFactor())) return false;
			if (!Objects.equals(forecastPaymentAmount, _that.getForecastPaymentAmount())) return false;
			if (!Objects.equals(presentValueAmount, _that.getPresentValueAmount())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			_result = 31 * _result + (href != null ? href.hashCode() : 0);
			_result = 31 * _result + (unadjustedPaymentDate != null ? unadjustedPaymentDate.hashCode() : 0);
			_result = 31 * _result + (adjustedPaymentDate != null ? adjustedPaymentDate.hashCode() : 0);
			_result = 31 * _result + (calculationPeriod != null ? calculationPeriod.hashCode() : 0);
			_result = 31 * _result + (fixedPaymentAmount != null ? fixedPaymentAmount.hashCode() : 0);
			_result = 31 * _result + (discountFactor != null ? discountFactor.hashCode() : 0);
			_result = 31 * _result + (forecastPaymentAmount != null ? forecastPaymentAmount.hashCode() : 0);
			_result = 31 * _result + (presentValueAmount != null ? presentValueAmount.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "PaymentCalculationPeriod {" +
				"id=" + this.id + ", " +
				"href=" + this.href + ", " +
				"unadjustedPaymentDate=" + this.unadjustedPaymentDate + ", " +
				"adjustedPaymentDate=" + this.adjustedPaymentDate + ", " +
				"calculationPeriod=" + this.calculationPeriod + ", " +
				"fixedPaymentAmount=" + this.fixedPaymentAmount + ", " +
				"discountFactor=" + this.discountFactor + ", " +
				"forecastPaymentAmount=" + this.forecastPaymentAmount + ", " +
				"presentValueAmount=" + this.presentValueAmount +
			'}';
		}
	}

	/*********************** Builder Implementation of PaymentCalculationPeriod  ***********************/
	class PaymentCalculationPeriodBuilderImpl implements PaymentCalculationPeriod.PaymentCalculationPeriodBuilder {
	
		protected String id;
		protected String href;
		protected ZonedDateTime unadjustedPaymentDate;
		protected ZonedDateTime adjustedPaymentDate;
		protected List<CalculationPeriod.CalculationPeriodBuilder> calculationPeriod = new ArrayList<>();
		protected BigDecimal fixedPaymentAmount;
		protected BigDecimal discountFactor;
		protected Money.MoneyBuilder forecastPaymentAmount;
		protected Money.MoneyBuilder presentValueAmount;
		
		@Override
		@RosettaAttribute("id")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("id")
		public String getId() {
			return id;
		}
		
		@Override
		@RosettaAttribute("href")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("href")
		public String getHref() {
			return href;
		}
		
		@Override
		@RosettaAttribute("unadjustedPaymentDate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("unadjustedPaymentDate")
		public ZonedDateTime getUnadjustedPaymentDate() {
			return unadjustedPaymentDate;
		}
		
		@Override
		@RosettaAttribute("adjustedPaymentDate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("adjustedPaymentDate")
		public ZonedDateTime getAdjustedPaymentDate() {
			return adjustedPaymentDate;
		}
		
		@Override
		@RosettaAttribute("calculationPeriod")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("calculationPeriod")
		public List<? extends CalculationPeriod.CalculationPeriodBuilder> getCalculationPeriod() {
			return calculationPeriod;
		}
		
		@Override
		public CalculationPeriod.CalculationPeriodBuilder getOrCreateCalculationPeriod(int index) {
			if (calculationPeriod==null) {
				this.calculationPeriod = new ArrayList<>();
			}
			return getIndex(calculationPeriod, index, () -> {
						CalculationPeriod.CalculationPeriodBuilder newCalculationPeriod = CalculationPeriod.builder();
						return newCalculationPeriod;
					});
		}
		
		@Override
		@RosettaAttribute("fixedPaymentAmount")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("fixedPaymentAmount")
		public BigDecimal getFixedPaymentAmount() {
			return fixedPaymentAmount;
		}
		
		@Override
		@RosettaAttribute("discountFactor")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("discountFactor")
		public BigDecimal getDiscountFactor() {
			return discountFactor;
		}
		
		@Override
		@RosettaAttribute("forecastPaymentAmount")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("forecastPaymentAmount")
		public Money.MoneyBuilder getForecastPaymentAmount() {
			return forecastPaymentAmount;
		}
		
		@Override
		public Money.MoneyBuilder getOrCreateForecastPaymentAmount() {
			Money.MoneyBuilder result;
			if (forecastPaymentAmount!=null) {
				result = forecastPaymentAmount;
			}
			else {
				result = forecastPaymentAmount = Money.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("presentValueAmount")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("presentValueAmount")
		public Money.MoneyBuilder getPresentValueAmount() {
			return presentValueAmount;
		}
		
		@Override
		public Money.MoneyBuilder getOrCreatePresentValueAmount() {
			Money.MoneyBuilder result;
			if (presentValueAmount!=null) {
				result = presentValueAmount;
			}
			else {
				result = presentValueAmount = Money.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("id")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("id")
		@Override
		public PaymentCalculationPeriod.PaymentCalculationPeriodBuilder setId(String _id) {
			this.id = _id == null ? null : _id;
			return this;
		}
		
		@RosettaAttribute("href")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("href")
		@Override
		public PaymentCalculationPeriod.PaymentCalculationPeriodBuilder setHref(String _href) {
			this.href = _href == null ? null : _href;
			return this;
		}
		
		@RosettaAttribute("unadjustedPaymentDate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("unadjustedPaymentDate")
		@Override
		public PaymentCalculationPeriod.PaymentCalculationPeriodBuilder setUnadjustedPaymentDate(ZonedDateTime _unadjustedPaymentDate) {
			this.unadjustedPaymentDate = _unadjustedPaymentDate == null ? null : _unadjustedPaymentDate;
			return this;
		}
		
		@RosettaAttribute("adjustedPaymentDate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("adjustedPaymentDate")
		@Override
		public PaymentCalculationPeriod.PaymentCalculationPeriodBuilder setAdjustedPaymentDate(ZonedDateTime _adjustedPaymentDate) {
			this.adjustedPaymentDate = _adjustedPaymentDate == null ? null : _adjustedPaymentDate;
			return this;
		}
		
		@RosettaAttribute("calculationPeriod")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("calculationPeriod")
		@Override
		public PaymentCalculationPeriod.PaymentCalculationPeriodBuilder addCalculationPeriod(CalculationPeriod _calculationPeriod) {
			if (_calculationPeriod != null) {
				this.calculationPeriod.add(_calculationPeriod.toBuilder());
			}
			return this;
		}
		
		@Override
		public PaymentCalculationPeriod.PaymentCalculationPeriodBuilder addCalculationPeriod(CalculationPeriod _calculationPeriod, int idx) {
			getIndex(this.calculationPeriod, idx, () -> _calculationPeriod.toBuilder());
			return this;
		}
		
		@Override
		public PaymentCalculationPeriod.PaymentCalculationPeriodBuilder addCalculationPeriod(List<? extends CalculationPeriod> calculationPeriods) {
			if (calculationPeriods != null) {
				for (final CalculationPeriod toAdd : calculationPeriods) {
					this.calculationPeriod.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("calculationPeriod")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("calculationPeriod")
		@Override
		public PaymentCalculationPeriod.PaymentCalculationPeriodBuilder setCalculationPeriod(List<? extends CalculationPeriod> calculationPeriods) {
			if (calculationPeriods == null) {
				this.calculationPeriod = new ArrayList<>();
			} else {
				this.calculationPeriod = calculationPeriods.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("fixedPaymentAmount")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("fixedPaymentAmount")
		@Override
		public PaymentCalculationPeriod.PaymentCalculationPeriodBuilder setFixedPaymentAmount(BigDecimal _fixedPaymentAmount) {
			this.fixedPaymentAmount = _fixedPaymentAmount == null ? null : _fixedPaymentAmount;
			return this;
		}
		
		@RosettaAttribute("discountFactor")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("discountFactor")
		@Override
		public PaymentCalculationPeriod.PaymentCalculationPeriodBuilder setDiscountFactor(BigDecimal _discountFactor) {
			this.discountFactor = _discountFactor == null ? null : _discountFactor;
			return this;
		}
		
		@RosettaAttribute("forecastPaymentAmount")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("forecastPaymentAmount")
		@Override
		public PaymentCalculationPeriod.PaymentCalculationPeriodBuilder setForecastPaymentAmount(Money _forecastPaymentAmount) {
			this.forecastPaymentAmount = _forecastPaymentAmount == null ? null : _forecastPaymentAmount.toBuilder();
			return this;
		}
		
		@RosettaAttribute("presentValueAmount")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("presentValueAmount")
		@Override
		public PaymentCalculationPeriod.PaymentCalculationPeriodBuilder setPresentValueAmount(Money _presentValueAmount) {
			this.presentValueAmount = _presentValueAmount == null ? null : _presentValueAmount.toBuilder();
			return this;
		}
		
		@Override
		public PaymentCalculationPeriod build() {
			return new PaymentCalculationPeriod.PaymentCalculationPeriodImpl(this);
		}
		
		@Override
		public PaymentCalculationPeriod.PaymentCalculationPeriodBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public PaymentCalculationPeriod.PaymentCalculationPeriodBuilder prune() {
			calculationPeriod = calculationPeriod.stream().filter(b->b!=null).<CalculationPeriod.CalculationPeriodBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			if (forecastPaymentAmount!=null && !forecastPaymentAmount.prune().hasData()) forecastPaymentAmount = null;
			if (presentValueAmount!=null && !presentValueAmount.prune().hasData()) presentValueAmount = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getId()!=null) return true;
			if (getHref()!=null) return true;
			if (getUnadjustedPaymentDate()!=null) return true;
			if (getAdjustedPaymentDate()!=null) return true;
			if (getCalculationPeriod()!=null && getCalculationPeriod().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getFixedPaymentAmount()!=null) return true;
			if (getDiscountFactor()!=null) return true;
			if (getForecastPaymentAmount()!=null && getForecastPaymentAmount().hasData()) return true;
			if (getPresentValueAmount()!=null && getPresentValueAmount().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public PaymentCalculationPeriod.PaymentCalculationPeriodBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			PaymentCalculationPeriod.PaymentCalculationPeriodBuilder o = (PaymentCalculationPeriod.PaymentCalculationPeriodBuilder) other;
			
			merger.mergeRosetta(getCalculationPeriod(), o.getCalculationPeriod(), this::getOrCreateCalculationPeriod);
			merger.mergeRosetta(getForecastPaymentAmount(), o.getForecastPaymentAmount(), this::setForecastPaymentAmount);
			merger.mergeRosetta(getPresentValueAmount(), o.getPresentValueAmount(), this::setPresentValueAmount);
			
			merger.mergeBasic(getId(), o.getId(), this::setId);
			merger.mergeBasic(getHref(), o.getHref(), this::setHref);
			merger.mergeBasic(getUnadjustedPaymentDate(), o.getUnadjustedPaymentDate(), this::setUnadjustedPaymentDate);
			merger.mergeBasic(getAdjustedPaymentDate(), o.getAdjustedPaymentDate(), this::setAdjustedPaymentDate);
			merger.mergeBasic(getFixedPaymentAmount(), o.getFixedPaymentAmount(), this::setFixedPaymentAmount);
			merger.mergeBasic(getDiscountFactor(), o.getDiscountFactor(), this::setDiscountFactor);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			PaymentCalculationPeriod _that = getType().cast(o);
		
			if (!Objects.equals(id, _that.getId())) return false;
			if (!Objects.equals(href, _that.getHref())) return false;
			if (!Objects.equals(unadjustedPaymentDate, _that.getUnadjustedPaymentDate())) return false;
			if (!Objects.equals(adjustedPaymentDate, _that.getAdjustedPaymentDate())) return false;
			if (!ListEquals.listEquals(calculationPeriod, _that.getCalculationPeriod())) return false;
			if (!Objects.equals(fixedPaymentAmount, _that.getFixedPaymentAmount())) return false;
			if (!Objects.equals(discountFactor, _that.getDiscountFactor())) return false;
			if (!Objects.equals(forecastPaymentAmount, _that.getForecastPaymentAmount())) return false;
			if (!Objects.equals(presentValueAmount, _that.getPresentValueAmount())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			_result = 31 * _result + (href != null ? href.hashCode() : 0);
			_result = 31 * _result + (unadjustedPaymentDate != null ? unadjustedPaymentDate.hashCode() : 0);
			_result = 31 * _result + (adjustedPaymentDate != null ? adjustedPaymentDate.hashCode() : 0);
			_result = 31 * _result + (calculationPeriod != null ? calculationPeriod.hashCode() : 0);
			_result = 31 * _result + (fixedPaymentAmount != null ? fixedPaymentAmount.hashCode() : 0);
			_result = 31 * _result + (discountFactor != null ? discountFactor.hashCode() : 0);
			_result = 31 * _result + (forecastPaymentAmount != null ? forecastPaymentAmount.hashCode() : 0);
			_result = 31 * _result + (presentValueAmount != null ? presentValueAmount.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "PaymentCalculationPeriodBuilder {" +
				"id=" + this.id + ", " +
				"href=" + this.href + ", " +
				"unadjustedPaymentDate=" + this.unadjustedPaymentDate + ", " +
				"adjustedPaymentDate=" + this.adjustedPaymentDate + ", " +
				"calculationPeriod=" + this.calculationPeriod + ", " +
				"fixedPaymentAmount=" + this.fixedPaymentAmount + ", " +
				"discountFactor=" + this.discountFactor + ", " +
				"forecastPaymentAmount=" + this.forecastPaymentAmount + ", " +
				"presentValueAmount=" + this.presentValueAmount +
			'}';
		}
	}
}

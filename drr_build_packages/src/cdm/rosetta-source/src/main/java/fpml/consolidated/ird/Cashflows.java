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
import fpml.consolidated.ird.meta.CashflowsMeta;
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
 * Provision A type defining the cashflow representation of a swap trade.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision A type defining the cashflow representation of a swap trade.
 *
 */
@RosettaDataType(value="Cashflows", builder=Cashflows.CashflowsBuilderImpl.class, version="2.1.1")
@RuneDataType(value="Cashflows", model="fpml", builder=Cashflows.CashflowsBuilderImpl.class, version="2.1.1")
public interface Cashflows extends RosettaModelObject {

	CashflowsMeta metaData = new CashflowsMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision A true/false flag to indicate whether the cashflows match the parametric definition of the stream, i.e. whether the cashflows could be regenerated from the parameters without loss of information.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A true/false flag to indicate whether the cashflows match the parametric definition of the stream, i.e. whether the cashflows could be regenerated from the parameters without loss of information.
	 *
	 */
	Boolean getCashflowsMatchParameters();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The initial, intermediate and final principal exchange amounts. Typically required on cross currency interest rate swaps where actual exchanges of principal occur. A list of principal exchange elements may be ordered in the document by ascending adjusted principal exchange date. An FpML document containing an unordered principal exchange list is still regarded as a conformant document.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The initial, intermediate and final principal exchange amounts. Typically required on cross currency interest rate swaps where actual exchanges of principal occur. A list of principal exchange elements may be ordered in the document by ascending adjusted principal exchange date. An FpML document containing an unordered principal exchange list is still regarded as a conformant document.
	 *
	 */
	List<? extends PrincipalExchange> getPrincipalExchange();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The adjusted payment date and associated calculation period parameters required to calculate the actual or projected payment amount. A list of payment calculation period elements may be ordered in the document by ascending adjusted payment date. An FpML document containing an unordered list of payment calculation periods is still regarded as a conformant document.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The adjusted payment date and associated calculation period parameters required to calculate the actual or projected payment amount. A list of payment calculation period elements may be ordered in the document by ascending adjusted payment date. An FpML document containing an unordered list of payment calculation periods is still regarded as a conformant document.
	 *
	 */
	List<? extends PaymentCalculationPeriod> getPaymentCalculationPeriod();

	/*********************** Build Methods  ***********************/
	Cashflows build();
	
	Cashflows.CashflowsBuilder toBuilder();
	
	static Cashflows.CashflowsBuilder builder() {
		return new Cashflows.CashflowsBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends Cashflows> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends Cashflows> getType() {
		return Cashflows.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("cashflowsMatchParameters"), Boolean.class, getCashflowsMatchParameters(), this);
		processRosetta(path.newSubPath("principalExchange"), processor, PrincipalExchange.class, getPrincipalExchange());
		processRosetta(path.newSubPath("paymentCalculationPeriod"), processor, PaymentCalculationPeriod.class, getPaymentCalculationPeriod());
	}
	

	/*********************** Builder Interface  ***********************/
	interface CashflowsBuilder extends Cashflows, RosettaModelObjectBuilder {
		PrincipalExchange.PrincipalExchangeBuilder getOrCreatePrincipalExchange(int index);
		@Override
		List<? extends PrincipalExchange.PrincipalExchangeBuilder> getPrincipalExchange();
		PaymentCalculationPeriod.PaymentCalculationPeriodBuilder getOrCreatePaymentCalculationPeriod(int index);
		@Override
		List<? extends PaymentCalculationPeriod.PaymentCalculationPeriodBuilder> getPaymentCalculationPeriod();
		Cashflows.CashflowsBuilder setCashflowsMatchParameters(Boolean cashflowsMatchParameters);
		Cashflows.CashflowsBuilder addPrincipalExchange(PrincipalExchange principalExchange);
		Cashflows.CashflowsBuilder addPrincipalExchange(PrincipalExchange principalExchange, int idx);
		Cashflows.CashflowsBuilder addPrincipalExchange(List<? extends PrincipalExchange> principalExchange);
		Cashflows.CashflowsBuilder setPrincipalExchange(List<? extends PrincipalExchange> principalExchange);
		Cashflows.CashflowsBuilder addPaymentCalculationPeriod(PaymentCalculationPeriod paymentCalculationPeriod);
		Cashflows.CashflowsBuilder addPaymentCalculationPeriod(PaymentCalculationPeriod paymentCalculationPeriod, int idx);
		Cashflows.CashflowsBuilder addPaymentCalculationPeriod(List<? extends PaymentCalculationPeriod> paymentCalculationPeriod);
		Cashflows.CashflowsBuilder setPaymentCalculationPeriod(List<? extends PaymentCalculationPeriod> paymentCalculationPeriod);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("cashflowsMatchParameters"), Boolean.class, getCashflowsMatchParameters(), this);
			processRosetta(path.newSubPath("principalExchange"), processor, PrincipalExchange.PrincipalExchangeBuilder.class, getPrincipalExchange());
			processRosetta(path.newSubPath("paymentCalculationPeriod"), processor, PaymentCalculationPeriod.PaymentCalculationPeriodBuilder.class, getPaymentCalculationPeriod());
		}
		

		Cashflows.CashflowsBuilder prune();
	}

	/*********************** Immutable Implementation of Cashflows  ***********************/
	class CashflowsImpl implements Cashflows {
		private final Boolean cashflowsMatchParameters;
		private final List<? extends PrincipalExchange> principalExchange;
		private final List<? extends PaymentCalculationPeriod> paymentCalculationPeriod;
		
		protected CashflowsImpl(Cashflows.CashflowsBuilder builder) {
			this.cashflowsMatchParameters = builder.getCashflowsMatchParameters();
			this.principalExchange = ofNullable(builder.getPrincipalExchange()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.paymentCalculationPeriod = ofNullable(builder.getPaymentCalculationPeriod()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		@RosettaAttribute("cashflowsMatchParameters")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("cashflowsMatchParameters")
		public Boolean getCashflowsMatchParameters() {
			return cashflowsMatchParameters;
		}
		
		@Override
		@RosettaAttribute("principalExchange")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("principalExchange")
		public List<? extends PrincipalExchange> getPrincipalExchange() {
			return principalExchange;
		}
		
		@Override
		@RosettaAttribute("paymentCalculationPeriod")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("paymentCalculationPeriod")
		public List<? extends PaymentCalculationPeriod> getPaymentCalculationPeriod() {
			return paymentCalculationPeriod;
		}
		
		@Override
		public Cashflows build() {
			return this;
		}
		
		@Override
		public Cashflows.CashflowsBuilder toBuilder() {
			Cashflows.CashflowsBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(Cashflows.CashflowsBuilder builder) {
			ofNullable(getCashflowsMatchParameters()).ifPresent(builder::setCashflowsMatchParameters);
			ofNullable(getPrincipalExchange()).ifPresent(builder::setPrincipalExchange);
			ofNullable(getPaymentCalculationPeriod()).ifPresent(builder::setPaymentCalculationPeriod);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			Cashflows _that = getType().cast(o);
		
			if (!Objects.equals(cashflowsMatchParameters, _that.getCashflowsMatchParameters())) return false;
			if (!ListEquals.listEquals(principalExchange, _that.getPrincipalExchange())) return false;
			if (!ListEquals.listEquals(paymentCalculationPeriod, _that.getPaymentCalculationPeriod())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (cashflowsMatchParameters != null ? cashflowsMatchParameters.hashCode() : 0);
			_result = 31 * _result + (principalExchange != null ? principalExchange.hashCode() : 0);
			_result = 31 * _result + (paymentCalculationPeriod != null ? paymentCalculationPeriod.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "Cashflows {" +
				"cashflowsMatchParameters=" + this.cashflowsMatchParameters + ", " +
				"principalExchange=" + this.principalExchange + ", " +
				"paymentCalculationPeriod=" + this.paymentCalculationPeriod +
			'}';
		}
	}

	/*********************** Builder Implementation of Cashflows  ***********************/
	class CashflowsBuilderImpl implements Cashflows.CashflowsBuilder {
	
		protected Boolean cashflowsMatchParameters;
		protected List<PrincipalExchange.PrincipalExchangeBuilder> principalExchange = new ArrayList<>();
		protected List<PaymentCalculationPeriod.PaymentCalculationPeriodBuilder> paymentCalculationPeriod = new ArrayList<>();
		
		@Override
		@RosettaAttribute("cashflowsMatchParameters")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("cashflowsMatchParameters")
		public Boolean getCashflowsMatchParameters() {
			return cashflowsMatchParameters;
		}
		
		@Override
		@RosettaAttribute("principalExchange")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("principalExchange")
		public List<? extends PrincipalExchange.PrincipalExchangeBuilder> getPrincipalExchange() {
			return principalExchange;
		}
		
		@Override
		public PrincipalExchange.PrincipalExchangeBuilder getOrCreatePrincipalExchange(int index) {
			if (principalExchange==null) {
				this.principalExchange = new ArrayList<>();
			}
			return getIndex(principalExchange, index, () -> {
						PrincipalExchange.PrincipalExchangeBuilder newPrincipalExchange = PrincipalExchange.builder();
						return newPrincipalExchange;
					});
		}
		
		@Override
		@RosettaAttribute("paymentCalculationPeriod")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("paymentCalculationPeriod")
		public List<? extends PaymentCalculationPeriod.PaymentCalculationPeriodBuilder> getPaymentCalculationPeriod() {
			return paymentCalculationPeriod;
		}
		
		@Override
		public PaymentCalculationPeriod.PaymentCalculationPeriodBuilder getOrCreatePaymentCalculationPeriod(int index) {
			if (paymentCalculationPeriod==null) {
				this.paymentCalculationPeriod = new ArrayList<>();
			}
			return getIndex(paymentCalculationPeriod, index, () -> {
						PaymentCalculationPeriod.PaymentCalculationPeriodBuilder newPaymentCalculationPeriod = PaymentCalculationPeriod.builder();
						return newPaymentCalculationPeriod;
					});
		}
		
		@RosettaAttribute("cashflowsMatchParameters")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("cashflowsMatchParameters")
		@Override
		public Cashflows.CashflowsBuilder setCashflowsMatchParameters(Boolean _cashflowsMatchParameters) {
			this.cashflowsMatchParameters = _cashflowsMatchParameters == null ? null : _cashflowsMatchParameters;
			return this;
		}
		
		@RosettaAttribute("principalExchange")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("principalExchange")
		@Override
		public Cashflows.CashflowsBuilder addPrincipalExchange(PrincipalExchange _principalExchange) {
			if (_principalExchange != null) {
				this.principalExchange.add(_principalExchange.toBuilder());
			}
			return this;
		}
		
		@Override
		public Cashflows.CashflowsBuilder addPrincipalExchange(PrincipalExchange _principalExchange, int idx) {
			getIndex(this.principalExchange, idx, () -> _principalExchange.toBuilder());
			return this;
		}
		
		@Override
		public Cashflows.CashflowsBuilder addPrincipalExchange(List<? extends PrincipalExchange> principalExchanges) {
			if (principalExchanges != null) {
				for (final PrincipalExchange toAdd : principalExchanges) {
					this.principalExchange.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("principalExchange")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("principalExchange")
		@Override
		public Cashflows.CashflowsBuilder setPrincipalExchange(List<? extends PrincipalExchange> principalExchanges) {
			if (principalExchanges == null) {
				this.principalExchange = new ArrayList<>();
			} else {
				this.principalExchange = principalExchanges.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("paymentCalculationPeriod")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("paymentCalculationPeriod")
		@Override
		public Cashflows.CashflowsBuilder addPaymentCalculationPeriod(PaymentCalculationPeriod _paymentCalculationPeriod) {
			if (_paymentCalculationPeriod != null) {
				this.paymentCalculationPeriod.add(_paymentCalculationPeriod.toBuilder());
			}
			return this;
		}
		
		@Override
		public Cashflows.CashflowsBuilder addPaymentCalculationPeriod(PaymentCalculationPeriod _paymentCalculationPeriod, int idx) {
			getIndex(this.paymentCalculationPeriod, idx, () -> _paymentCalculationPeriod.toBuilder());
			return this;
		}
		
		@Override
		public Cashflows.CashflowsBuilder addPaymentCalculationPeriod(List<? extends PaymentCalculationPeriod> paymentCalculationPeriods) {
			if (paymentCalculationPeriods != null) {
				for (final PaymentCalculationPeriod toAdd : paymentCalculationPeriods) {
					this.paymentCalculationPeriod.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("paymentCalculationPeriod")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("paymentCalculationPeriod")
		@Override
		public Cashflows.CashflowsBuilder setPaymentCalculationPeriod(List<? extends PaymentCalculationPeriod> paymentCalculationPeriods) {
			if (paymentCalculationPeriods == null) {
				this.paymentCalculationPeriod = new ArrayList<>();
			} else {
				this.paymentCalculationPeriod = paymentCalculationPeriods.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		public Cashflows build() {
			return new Cashflows.CashflowsImpl(this);
		}
		
		@Override
		public Cashflows.CashflowsBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Cashflows.CashflowsBuilder prune() {
			principalExchange = principalExchange.stream().filter(b->b!=null).<PrincipalExchange.PrincipalExchangeBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			paymentCalculationPeriod = paymentCalculationPeriod.stream().filter(b->b!=null).<PaymentCalculationPeriod.PaymentCalculationPeriodBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getCashflowsMatchParameters()!=null) return true;
			if (getPrincipalExchange()!=null && getPrincipalExchange().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getPaymentCalculationPeriod()!=null && getPaymentCalculationPeriod().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Cashflows.CashflowsBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			Cashflows.CashflowsBuilder o = (Cashflows.CashflowsBuilder) other;
			
			merger.mergeRosetta(getPrincipalExchange(), o.getPrincipalExchange(), this::getOrCreatePrincipalExchange);
			merger.mergeRosetta(getPaymentCalculationPeriod(), o.getPaymentCalculationPeriod(), this::getOrCreatePaymentCalculationPeriod);
			
			merger.mergeBasic(getCashflowsMatchParameters(), o.getCashflowsMatchParameters(), this::setCashflowsMatchParameters);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			Cashflows _that = getType().cast(o);
		
			if (!Objects.equals(cashflowsMatchParameters, _that.getCashflowsMatchParameters())) return false;
			if (!ListEquals.listEquals(principalExchange, _that.getPrincipalExchange())) return false;
			if (!ListEquals.listEquals(paymentCalculationPeriod, _that.getPaymentCalculationPeriod())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (cashflowsMatchParameters != null ? cashflowsMatchParameters.hashCode() : 0);
			_result = 31 * _result + (principalExchange != null ? principalExchange.hashCode() : 0);
			_result = 31 * _result + (paymentCalculationPeriod != null ? paymentCalculationPeriod.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CashflowsBuilder {" +
				"cashflowsMatchParameters=" + this.cashflowsMatchParameters + ", " +
				"principalExchange=" + this.principalExchange + ", " +
				"paymentCalculationPeriod=" + this.paymentCalculationPeriod +
			'}';
		}
	}
}

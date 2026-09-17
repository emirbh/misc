package fpml.consolidated.cd;

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
import fpml.consolidated.cd.meta.ProtectionTermsMeta;
import fpml.consolidated.option.shared.CreditEvents;
import fpml.consolidated.shared.Money;
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
@RosettaDataType(value="ProtectionTerms", builder=ProtectionTerms.ProtectionTermsBuilderImpl.class, version="2.1.1")
@RuneDataType(value="ProtectionTerms", model="fpml", builder=ProtectionTerms.ProtectionTermsBuilderImpl.class, version="2.1.1")
public interface ProtectionTerms extends RosettaModelObject {

	ProtectionTermsMeta metaData = new ProtectionTermsMeta();

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
	 * Provision The notional amount of protection coverage. ISDA 2003 Term: Floating Rate Payer Calculation Amount
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The notional amount of protection coverage. ISDA 2003 Term: Floating Rate Payer Calculation Amount
	 *
	 */
	Money getCalculationAmount();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision This element contains all the ISDA terms relating to credit events.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision This element contains all the ISDA terms relating to credit events.
	 *
	 */
	CreditEvents getCreditEvents();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The underlying obligations of the reference entity on which you are buying or selling protection. The credit events Failure to Pay, Obligation Acceleration, Obligation Default, Restructuring, Repudiation/Moratorium are defined with respect to these obligations. ISDA 2003 Term:
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The underlying obligations of the reference entity on which you are buying or selling protection. The credit events Failure to Pay, Obligation Acceleration, Obligation Default, Restructuring, Repudiation/Moratorium are defined with respect to these obligations. ISDA 2003 Term:
	 *
	 */
	Obligations getObligations();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision This element contains the ISDA terms relating to the floating rate payment events and the implied additional fixed payments, applicable to the credit derivatives transactions on mortgage-backed securities with pay-as-you-go or physical settlement.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision This element contains the ISDA terms relating to the floating rate payment events and the implied additional fixed payments, applicable to the credit derivatives transactions on mortgage-backed securities with pay-as-you-go or physical settlement.
	 *
	 */
	FloatingAmountEvents getFloatingAmountEvents();

	/*********************** Build Methods  ***********************/
	ProtectionTerms build();
	
	ProtectionTerms.ProtectionTermsBuilder toBuilder();
	
	static ProtectionTerms.ProtectionTermsBuilder builder() {
		return new ProtectionTerms.ProtectionTermsBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends ProtectionTerms> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends ProtectionTerms> getType() {
		return ProtectionTerms.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		processRosetta(path.newSubPath("calculationAmount"), processor, Money.class, getCalculationAmount());
		processRosetta(path.newSubPath("creditEvents"), processor, CreditEvents.class, getCreditEvents());
		processRosetta(path.newSubPath("obligations"), processor, Obligations.class, getObligations());
		processRosetta(path.newSubPath("floatingAmountEvents"), processor, FloatingAmountEvents.class, getFloatingAmountEvents());
	}
	

	/*********************** Builder Interface  ***********************/
	interface ProtectionTermsBuilder extends ProtectionTerms, RosettaModelObjectBuilder {
		Money.MoneyBuilder getOrCreateCalculationAmount();
		@Override
		Money.MoneyBuilder getCalculationAmount();
		CreditEvents.CreditEventsBuilder getOrCreateCreditEvents();
		@Override
		CreditEvents.CreditEventsBuilder getCreditEvents();
		Obligations.ObligationsBuilder getOrCreateObligations();
		@Override
		Obligations.ObligationsBuilder getObligations();
		FloatingAmountEvents.FloatingAmountEventsBuilder getOrCreateFloatingAmountEvents();
		@Override
		FloatingAmountEvents.FloatingAmountEventsBuilder getFloatingAmountEvents();
		ProtectionTerms.ProtectionTermsBuilder setId(String id);
		ProtectionTerms.ProtectionTermsBuilder setCalculationAmount(Money calculationAmount);
		ProtectionTerms.ProtectionTermsBuilder setCreditEvents(CreditEvents creditEvents);
		ProtectionTerms.ProtectionTermsBuilder setObligations(Obligations obligations);
		ProtectionTerms.ProtectionTermsBuilder setFloatingAmountEvents(FloatingAmountEvents floatingAmountEvents);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
			processRosetta(path.newSubPath("calculationAmount"), processor, Money.MoneyBuilder.class, getCalculationAmount());
			processRosetta(path.newSubPath("creditEvents"), processor, CreditEvents.CreditEventsBuilder.class, getCreditEvents());
			processRosetta(path.newSubPath("obligations"), processor, Obligations.ObligationsBuilder.class, getObligations());
			processRosetta(path.newSubPath("floatingAmountEvents"), processor, FloatingAmountEvents.FloatingAmountEventsBuilder.class, getFloatingAmountEvents());
		}
		

		ProtectionTerms.ProtectionTermsBuilder prune();
	}

	/*********************** Immutable Implementation of ProtectionTerms  ***********************/
	class ProtectionTermsImpl implements ProtectionTerms {
		private final String id;
		private final Money calculationAmount;
		private final CreditEvents creditEvents;
		private final Obligations obligations;
		private final FloatingAmountEvents floatingAmountEvents;
		
		protected ProtectionTermsImpl(ProtectionTerms.ProtectionTermsBuilder builder) {
			this.id = builder.getId();
			this.calculationAmount = ofNullable(builder.getCalculationAmount()).map(f->f.build()).orElse(null);
			this.creditEvents = ofNullable(builder.getCreditEvents()).map(f->f.build()).orElse(null);
			this.obligations = ofNullable(builder.getObligations()).map(f->f.build()).orElse(null);
			this.floatingAmountEvents = ofNullable(builder.getFloatingAmountEvents()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("id")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("id")
		public String getId() {
			return id;
		}
		
		@Override
		@RosettaAttribute("calculationAmount")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("calculationAmount")
		public Money getCalculationAmount() {
			return calculationAmount;
		}
		
		@Override
		@RosettaAttribute("creditEvents")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("creditEvents")
		public CreditEvents getCreditEvents() {
			return creditEvents;
		}
		
		@Override
		@RosettaAttribute("obligations")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("obligations")
		public Obligations getObligations() {
			return obligations;
		}
		
		@Override
		@RosettaAttribute("floatingAmountEvents")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("floatingAmountEvents")
		public FloatingAmountEvents getFloatingAmountEvents() {
			return floatingAmountEvents;
		}
		
		@Override
		public ProtectionTerms build() {
			return this;
		}
		
		@Override
		public ProtectionTerms.ProtectionTermsBuilder toBuilder() {
			ProtectionTerms.ProtectionTermsBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(ProtectionTerms.ProtectionTermsBuilder builder) {
			ofNullable(getId()).ifPresent(builder::setId);
			ofNullable(getCalculationAmount()).ifPresent(builder::setCalculationAmount);
			ofNullable(getCreditEvents()).ifPresent(builder::setCreditEvents);
			ofNullable(getObligations()).ifPresent(builder::setObligations);
			ofNullable(getFloatingAmountEvents()).ifPresent(builder::setFloatingAmountEvents);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ProtectionTerms _that = getType().cast(o);
		
			if (!Objects.equals(id, _that.getId())) return false;
			if (!Objects.equals(calculationAmount, _that.getCalculationAmount())) return false;
			if (!Objects.equals(creditEvents, _that.getCreditEvents())) return false;
			if (!Objects.equals(obligations, _that.getObligations())) return false;
			if (!Objects.equals(floatingAmountEvents, _that.getFloatingAmountEvents())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			_result = 31 * _result + (calculationAmount != null ? calculationAmount.hashCode() : 0);
			_result = 31 * _result + (creditEvents != null ? creditEvents.hashCode() : 0);
			_result = 31 * _result + (obligations != null ? obligations.hashCode() : 0);
			_result = 31 * _result + (floatingAmountEvents != null ? floatingAmountEvents.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ProtectionTerms {" +
				"id=" + this.id + ", " +
				"calculationAmount=" + this.calculationAmount + ", " +
				"creditEvents=" + this.creditEvents + ", " +
				"obligations=" + this.obligations + ", " +
				"floatingAmountEvents=" + this.floatingAmountEvents +
			'}';
		}
	}

	/*********************** Builder Implementation of ProtectionTerms  ***********************/
	class ProtectionTermsBuilderImpl implements ProtectionTerms.ProtectionTermsBuilder {
	
		protected String id;
		protected Money.MoneyBuilder calculationAmount;
		protected CreditEvents.CreditEventsBuilder creditEvents;
		protected Obligations.ObligationsBuilder obligations;
		protected FloatingAmountEvents.FloatingAmountEventsBuilder floatingAmountEvents;
		
		@Override
		@RosettaAttribute("id")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("id")
		public String getId() {
			return id;
		}
		
		@Override
		@RosettaAttribute("calculationAmount")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("calculationAmount")
		public Money.MoneyBuilder getCalculationAmount() {
			return calculationAmount;
		}
		
		@Override
		public Money.MoneyBuilder getOrCreateCalculationAmount() {
			Money.MoneyBuilder result;
			if (calculationAmount!=null) {
				result = calculationAmount;
			}
			else {
				result = calculationAmount = Money.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("creditEvents")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("creditEvents")
		public CreditEvents.CreditEventsBuilder getCreditEvents() {
			return creditEvents;
		}
		
		@Override
		public CreditEvents.CreditEventsBuilder getOrCreateCreditEvents() {
			CreditEvents.CreditEventsBuilder result;
			if (creditEvents!=null) {
				result = creditEvents;
			}
			else {
				result = creditEvents = CreditEvents.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("obligations")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("obligations")
		public Obligations.ObligationsBuilder getObligations() {
			return obligations;
		}
		
		@Override
		public Obligations.ObligationsBuilder getOrCreateObligations() {
			Obligations.ObligationsBuilder result;
			if (obligations!=null) {
				result = obligations;
			}
			else {
				result = obligations = Obligations.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("floatingAmountEvents")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("floatingAmountEvents")
		public FloatingAmountEvents.FloatingAmountEventsBuilder getFloatingAmountEvents() {
			return floatingAmountEvents;
		}
		
		@Override
		public FloatingAmountEvents.FloatingAmountEventsBuilder getOrCreateFloatingAmountEvents() {
			FloatingAmountEvents.FloatingAmountEventsBuilder result;
			if (floatingAmountEvents!=null) {
				result = floatingAmountEvents;
			}
			else {
				result = floatingAmountEvents = FloatingAmountEvents.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("id")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("id")
		@Override
		public ProtectionTerms.ProtectionTermsBuilder setId(String _id) {
			this.id = _id == null ? null : _id;
			return this;
		}
		
		@RosettaAttribute("calculationAmount")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("calculationAmount")
		@Override
		public ProtectionTerms.ProtectionTermsBuilder setCalculationAmount(Money _calculationAmount) {
			this.calculationAmount = _calculationAmount == null ? null : _calculationAmount.toBuilder();
			return this;
		}
		
		@RosettaAttribute("creditEvents")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("creditEvents")
		@Override
		public ProtectionTerms.ProtectionTermsBuilder setCreditEvents(CreditEvents _creditEvents) {
			this.creditEvents = _creditEvents == null ? null : _creditEvents.toBuilder();
			return this;
		}
		
		@RosettaAttribute("obligations")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("obligations")
		@Override
		public ProtectionTerms.ProtectionTermsBuilder setObligations(Obligations _obligations) {
			this.obligations = _obligations == null ? null : _obligations.toBuilder();
			return this;
		}
		
		@RosettaAttribute("floatingAmountEvents")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("floatingAmountEvents")
		@Override
		public ProtectionTerms.ProtectionTermsBuilder setFloatingAmountEvents(FloatingAmountEvents _floatingAmountEvents) {
			this.floatingAmountEvents = _floatingAmountEvents == null ? null : _floatingAmountEvents.toBuilder();
			return this;
		}
		
		@Override
		public ProtectionTerms build() {
			return new ProtectionTerms.ProtectionTermsImpl(this);
		}
		
		@Override
		public ProtectionTerms.ProtectionTermsBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ProtectionTerms.ProtectionTermsBuilder prune() {
			if (calculationAmount!=null && !calculationAmount.prune().hasData()) calculationAmount = null;
			if (creditEvents!=null && !creditEvents.prune().hasData()) creditEvents = null;
			if (obligations!=null && !obligations.prune().hasData()) obligations = null;
			if (floatingAmountEvents!=null && !floatingAmountEvents.prune().hasData()) floatingAmountEvents = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getId()!=null) return true;
			if (getCalculationAmount()!=null && getCalculationAmount().hasData()) return true;
			if (getCreditEvents()!=null && getCreditEvents().hasData()) return true;
			if (getObligations()!=null && getObligations().hasData()) return true;
			if (getFloatingAmountEvents()!=null && getFloatingAmountEvents().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ProtectionTerms.ProtectionTermsBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			ProtectionTerms.ProtectionTermsBuilder o = (ProtectionTerms.ProtectionTermsBuilder) other;
			
			merger.mergeRosetta(getCalculationAmount(), o.getCalculationAmount(), this::setCalculationAmount);
			merger.mergeRosetta(getCreditEvents(), o.getCreditEvents(), this::setCreditEvents);
			merger.mergeRosetta(getObligations(), o.getObligations(), this::setObligations);
			merger.mergeRosetta(getFloatingAmountEvents(), o.getFloatingAmountEvents(), this::setFloatingAmountEvents);
			
			merger.mergeBasic(getId(), o.getId(), this::setId);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ProtectionTerms _that = getType().cast(o);
		
			if (!Objects.equals(id, _that.getId())) return false;
			if (!Objects.equals(calculationAmount, _that.getCalculationAmount())) return false;
			if (!Objects.equals(creditEvents, _that.getCreditEvents())) return false;
			if (!Objects.equals(obligations, _that.getObligations())) return false;
			if (!Objects.equals(floatingAmountEvents, _that.getFloatingAmountEvents())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			_result = 31 * _result + (calculationAmount != null ? calculationAmount.hashCode() : 0);
			_result = 31 * _result + (creditEvents != null ? creditEvents.hashCode() : 0);
			_result = 31 * _result + (obligations != null ? obligations.hashCode() : 0);
			_result = 31 * _result + (floatingAmountEvents != null ? floatingAmountEvents.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ProtectionTermsBuilder {" +
				"id=" + this.id + ", " +
				"calculationAmount=" + this.calculationAmount + ", " +
				"creditEvents=" + this.creditEvents + ", " +
				"obligations=" + this.obligations + ", " +
				"floatingAmountEvents=" + this.floatingAmountEvents +
			'}';
		}
	}
}

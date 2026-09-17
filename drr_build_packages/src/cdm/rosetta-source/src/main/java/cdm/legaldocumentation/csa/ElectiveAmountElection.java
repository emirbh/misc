package cdm.legaldocumentation.csa;

import cdm.base.staticdata.party.CounterpartyRoleEnum;
import cdm.legaldocumentation.csa.meta.ElectiveAmountElectionMeta;
import cdm.observable.asset.Money;
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
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * A class to specify the party elective amounts which can be used for the purpose of specifying elections such as the ISDA CSA Threshold and Minimum Transfer Amount.
 * @version 6.23.0
 */
@RosettaDataType(value="ElectiveAmountElection", builder=ElectiveAmountElection.ElectiveAmountElectionBuilderImpl.class, version="6.23.0")
@RuneDataType(value="ElectiveAmountElection", model="cdm", builder=ElectiveAmountElection.ElectiveAmountElectionBuilderImpl.class, version="6.23.0")
public interface ElectiveAmountElection extends RosettaModelObject {

	ElectiveAmountElectionMeta metaData = new ElectiveAmountElectionMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * The elective party.
	 */
	CounterpartyRoleEnum getParty();
	/**
	 * Specifies an enumerated election to express the elective amount.
	 */
	ElectiveAmountEnum getElectiveAmount();
	/**
	 * The elective amount when expressed as a currency amount. The associated PartyElectiveAmount_amount data rule enforces that the currency amount is actually greater than 0.
	 */
	Money getAmount();
	/**
	 * The elective amount when expressed as a custom election by the party.
	 */
	String getCustomElection();

	/*********************** Build Methods  ***********************/
	ElectiveAmountElection build();
	
	ElectiveAmountElection.ElectiveAmountElectionBuilder toBuilder();
	
	static ElectiveAmountElection.ElectiveAmountElectionBuilder builder() {
		return new ElectiveAmountElection.ElectiveAmountElectionBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends ElectiveAmountElection> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends ElectiveAmountElection> getType() {
		return ElectiveAmountElection.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("party"), CounterpartyRoleEnum.class, getParty(), this);
		processor.processBasic(path.newSubPath("electiveAmount"), ElectiveAmountEnum.class, getElectiveAmount(), this);
		processRosetta(path.newSubPath("amount"), processor, Money.class, getAmount());
		processor.processBasic(path.newSubPath("customElection"), String.class, getCustomElection(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface ElectiveAmountElectionBuilder extends ElectiveAmountElection, RosettaModelObjectBuilder {
		Money.MoneyBuilder getOrCreateAmount();
		@Override
		Money.MoneyBuilder getAmount();
		ElectiveAmountElection.ElectiveAmountElectionBuilder setParty(CounterpartyRoleEnum party);
		ElectiveAmountElection.ElectiveAmountElectionBuilder setElectiveAmount(ElectiveAmountEnum electiveAmount);
		ElectiveAmountElection.ElectiveAmountElectionBuilder setAmount(Money amount);
		ElectiveAmountElection.ElectiveAmountElectionBuilder setCustomElection(String customElection);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("party"), CounterpartyRoleEnum.class, getParty(), this);
			processor.processBasic(path.newSubPath("electiveAmount"), ElectiveAmountEnum.class, getElectiveAmount(), this);
			processRosetta(path.newSubPath("amount"), processor, Money.MoneyBuilder.class, getAmount());
			processor.processBasic(path.newSubPath("customElection"), String.class, getCustomElection(), this);
		}
		

		ElectiveAmountElection.ElectiveAmountElectionBuilder prune();
	}

	/*********************** Immutable Implementation of ElectiveAmountElection  ***********************/
	class ElectiveAmountElectionImpl implements ElectiveAmountElection {
		private final CounterpartyRoleEnum party;
		private final ElectiveAmountEnum electiveAmount;
		private final Money amount;
		private final String customElection;
		
		protected ElectiveAmountElectionImpl(ElectiveAmountElection.ElectiveAmountElectionBuilder builder) {
			this.party = builder.getParty();
			this.electiveAmount = builder.getElectiveAmount();
			this.amount = ofNullable(builder.getAmount()).map(f->f.build()).orElse(null);
			this.customElection = builder.getCustomElection();
		}
		
		@Override
		@RosettaAttribute("party")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("party")
		public CounterpartyRoleEnum getParty() {
			return party;
		}
		
		@Override
		@RosettaAttribute("electiveAmount")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("electiveAmount")
		public ElectiveAmountEnum getElectiveAmount() {
			return electiveAmount;
		}
		
		@Override
		@RosettaAttribute("amount")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("amount")
		public Money getAmount() {
			return amount;
		}
		
		@Override
		@RosettaAttribute("customElection")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("customElection")
		public String getCustomElection() {
			return customElection;
		}
		
		@Override
		public ElectiveAmountElection build() {
			return this;
		}
		
		@Override
		public ElectiveAmountElection.ElectiveAmountElectionBuilder toBuilder() {
			ElectiveAmountElection.ElectiveAmountElectionBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(ElectiveAmountElection.ElectiveAmountElectionBuilder builder) {
			ofNullable(getParty()).ifPresent(builder::setParty);
			ofNullable(getElectiveAmount()).ifPresent(builder::setElectiveAmount);
			ofNullable(getAmount()).ifPresent(builder::setAmount);
			ofNullable(getCustomElection()).ifPresent(builder::setCustomElection);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ElectiveAmountElection _that = getType().cast(o);
		
			if (!Objects.equals(party, _that.getParty())) return false;
			if (!Objects.equals(electiveAmount, _that.getElectiveAmount())) return false;
			if (!Objects.equals(amount, _that.getAmount())) return false;
			if (!Objects.equals(customElection, _that.getCustomElection())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (party != null ? party.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (electiveAmount != null ? electiveAmount.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (amount != null ? amount.hashCode() : 0);
			_result = 31 * _result + (customElection != null ? customElection.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ElectiveAmountElection {" +
				"party=" + this.party + ", " +
				"electiveAmount=" + this.electiveAmount + ", " +
				"amount=" + this.amount + ", " +
				"customElection=" + this.customElection +
			'}';
		}
	}

	/*********************** Builder Implementation of ElectiveAmountElection  ***********************/
	class ElectiveAmountElectionBuilderImpl implements ElectiveAmountElection.ElectiveAmountElectionBuilder {
	
		protected CounterpartyRoleEnum party;
		protected ElectiveAmountEnum electiveAmount;
		protected Money.MoneyBuilder amount;
		protected String customElection;
		
		@Override
		@RosettaAttribute("party")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("party")
		public CounterpartyRoleEnum getParty() {
			return party;
		}
		
		@Override
		@RosettaAttribute("electiveAmount")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("electiveAmount")
		public ElectiveAmountEnum getElectiveAmount() {
			return electiveAmount;
		}
		
		@Override
		@RosettaAttribute("amount")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("amount")
		public Money.MoneyBuilder getAmount() {
			return amount;
		}
		
		@Override
		public Money.MoneyBuilder getOrCreateAmount() {
			Money.MoneyBuilder result;
			if (amount!=null) {
				result = amount;
			}
			else {
				result = amount = Money.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("customElection")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("customElection")
		public String getCustomElection() {
			return customElection;
		}
		
		@RosettaAttribute("party")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("party")
		@Override
		public ElectiveAmountElection.ElectiveAmountElectionBuilder setParty(CounterpartyRoleEnum _party) {
			this.party = _party == null ? null : _party;
			return this;
		}
		
		@RosettaAttribute("electiveAmount")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("electiveAmount")
		@Override
		public ElectiveAmountElection.ElectiveAmountElectionBuilder setElectiveAmount(ElectiveAmountEnum _electiveAmount) {
			this.electiveAmount = _electiveAmount == null ? null : _electiveAmount;
			return this;
		}
		
		@RosettaAttribute("amount")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("amount")
		@Override
		public ElectiveAmountElection.ElectiveAmountElectionBuilder setAmount(Money _amount) {
			this.amount = _amount == null ? null : _amount.toBuilder();
			return this;
		}
		
		@RosettaAttribute("customElection")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("customElection")
		@Override
		public ElectiveAmountElection.ElectiveAmountElectionBuilder setCustomElection(String _customElection) {
			this.customElection = _customElection == null ? null : _customElection;
			return this;
		}
		
		@Override
		public ElectiveAmountElection build() {
			return new ElectiveAmountElection.ElectiveAmountElectionImpl(this);
		}
		
		@Override
		public ElectiveAmountElection.ElectiveAmountElectionBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ElectiveAmountElection.ElectiveAmountElectionBuilder prune() {
			if (amount!=null && !amount.prune().hasData()) amount = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getParty()!=null) return true;
			if (getElectiveAmount()!=null) return true;
			if (getAmount()!=null && getAmount().hasData()) return true;
			if (getCustomElection()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ElectiveAmountElection.ElectiveAmountElectionBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			ElectiveAmountElection.ElectiveAmountElectionBuilder o = (ElectiveAmountElection.ElectiveAmountElectionBuilder) other;
			
			merger.mergeRosetta(getAmount(), o.getAmount(), this::setAmount);
			
			merger.mergeBasic(getParty(), o.getParty(), this::setParty);
			merger.mergeBasic(getElectiveAmount(), o.getElectiveAmount(), this::setElectiveAmount);
			merger.mergeBasic(getCustomElection(), o.getCustomElection(), this::setCustomElection);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ElectiveAmountElection _that = getType().cast(o);
		
			if (!Objects.equals(party, _that.getParty())) return false;
			if (!Objects.equals(electiveAmount, _that.getElectiveAmount())) return false;
			if (!Objects.equals(amount, _that.getAmount())) return false;
			if (!Objects.equals(customElection, _that.getCustomElection())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (party != null ? party.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (electiveAmount != null ? electiveAmount.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (amount != null ? amount.hashCode() : 0);
			_result = 31 * _result + (customElection != null ? customElection.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ElectiveAmountElectionBuilder {" +
				"party=" + this.party + ", " +
				"electiveAmount=" + this.electiveAmount + ", " +
				"amount=" + this.amount + ", " +
				"customElection=" + this.customElection +
			'}';
		}
	}
}

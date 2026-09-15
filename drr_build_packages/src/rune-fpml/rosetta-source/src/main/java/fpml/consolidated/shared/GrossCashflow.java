package fpml.consolidated.shared;

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
import fpml.consolidated.shared.meta.GrossCashflowMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision A payment component owed from one party to the other for the cash flow date. This payment component should by of only a single type, e.g. a fee or a cashflow from a cashflow stream.
 *
 */
@RosettaDataType(value="GrossCashflow", builder=GrossCashflow.GrossCashflowBuilderImpl.class, version="2.1.1")
@RuneDataType(value="GrossCashflow", model="fpml", builder=GrossCashflow.GrossCashflowBuilderImpl.class, version="2.1.1")
public interface GrossCashflow extends RosettaModelObject {

	GrossCashflowMeta metaData = new GrossCashflowMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Unique identifier for a cash flow.
	 *
	 */
	CashflowId getCashflowId();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Pointer-style reference to the partyTradeIdentifier block within the tradeIdentifyingItems collection, which identifies the parent trade for this cashflow.
	 *
	 */
	PartyTradeIdentifierReference getPartyTradeIdentifierReference();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A reference to the party responsible for making the payments defined by this structure.
	 *
	 */
	PartyReference getPayerPartyReference();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A reference to the account responsible for making the payments defined by this structure.
	 *
	 */
	AccountReference getPayerAccountReference();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A reference to the party that receives the payments corresponding to this structure.
	 *
	 */
	PartyReference getReceiverPartyReference();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A reference to the account that receives the payments corresponding to this structure.
	 *
	 */
	AccountReference getReceiverAccountReference();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Cash flow amount in a given currency to be paid/received.
	 *
	 */
	Money getCashflowAmount();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Defines the type of cash flow. For instance, a type of fee, premium, principal exchange, leg fee.
	 *
	 */
	CashflowType getCashflowType();

	/*********************** Build Methods  ***********************/
	GrossCashflow build();
	
	GrossCashflow.GrossCashflowBuilder toBuilder();
	
	static GrossCashflow.GrossCashflowBuilder builder() {
		return new GrossCashflow.GrossCashflowBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends GrossCashflow> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends GrossCashflow> getType() {
		return GrossCashflow.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("cashflowId"), processor, CashflowId.class, getCashflowId());
		processRosetta(path.newSubPath("partyTradeIdentifierReference"), processor, PartyTradeIdentifierReference.class, getPartyTradeIdentifierReference());
		processRosetta(path.newSubPath("payerPartyReference"), processor, PartyReference.class, getPayerPartyReference());
		processRosetta(path.newSubPath("payerAccountReference"), processor, AccountReference.class, getPayerAccountReference());
		processRosetta(path.newSubPath("receiverPartyReference"), processor, PartyReference.class, getReceiverPartyReference());
		processRosetta(path.newSubPath("receiverAccountReference"), processor, AccountReference.class, getReceiverAccountReference());
		processRosetta(path.newSubPath("cashflowAmount"), processor, Money.class, getCashflowAmount());
		processRosetta(path.newSubPath("cashflowType"), processor, CashflowType.class, getCashflowType());
	}
	

	/*********************** Builder Interface  ***********************/
	interface GrossCashflowBuilder extends GrossCashflow, RosettaModelObjectBuilder {
		CashflowId.CashflowIdBuilder getOrCreateCashflowId();
		@Override
		CashflowId.CashflowIdBuilder getCashflowId();
		PartyTradeIdentifierReference.PartyTradeIdentifierReferenceBuilder getOrCreatePartyTradeIdentifierReference();
		@Override
		PartyTradeIdentifierReference.PartyTradeIdentifierReferenceBuilder getPartyTradeIdentifierReference();
		PartyReference.PartyReferenceBuilder getOrCreatePayerPartyReference();
		@Override
		PartyReference.PartyReferenceBuilder getPayerPartyReference();
		AccountReference.AccountReferenceBuilder getOrCreatePayerAccountReference();
		@Override
		AccountReference.AccountReferenceBuilder getPayerAccountReference();
		PartyReference.PartyReferenceBuilder getOrCreateReceiverPartyReference();
		@Override
		PartyReference.PartyReferenceBuilder getReceiverPartyReference();
		AccountReference.AccountReferenceBuilder getOrCreateReceiverAccountReference();
		@Override
		AccountReference.AccountReferenceBuilder getReceiverAccountReference();
		Money.MoneyBuilder getOrCreateCashflowAmount();
		@Override
		Money.MoneyBuilder getCashflowAmount();
		CashflowType.CashflowTypeBuilder getOrCreateCashflowType();
		@Override
		CashflowType.CashflowTypeBuilder getCashflowType();
		GrossCashflow.GrossCashflowBuilder setCashflowId(CashflowId cashflowId);
		GrossCashflow.GrossCashflowBuilder setPartyTradeIdentifierReference(PartyTradeIdentifierReference partyTradeIdentifierReference);
		GrossCashflow.GrossCashflowBuilder setPayerPartyReference(PartyReference payerPartyReference);
		GrossCashflow.GrossCashflowBuilder setPayerAccountReference(AccountReference payerAccountReference);
		GrossCashflow.GrossCashflowBuilder setReceiverPartyReference(PartyReference receiverPartyReference);
		GrossCashflow.GrossCashflowBuilder setReceiverAccountReference(AccountReference receiverAccountReference);
		GrossCashflow.GrossCashflowBuilder setCashflowAmount(Money cashflowAmount);
		GrossCashflow.GrossCashflowBuilder setCashflowType(CashflowType cashflowType);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("cashflowId"), processor, CashflowId.CashflowIdBuilder.class, getCashflowId());
			processRosetta(path.newSubPath("partyTradeIdentifierReference"), processor, PartyTradeIdentifierReference.PartyTradeIdentifierReferenceBuilder.class, getPartyTradeIdentifierReference());
			processRosetta(path.newSubPath("payerPartyReference"), processor, PartyReference.PartyReferenceBuilder.class, getPayerPartyReference());
			processRosetta(path.newSubPath("payerAccountReference"), processor, AccountReference.AccountReferenceBuilder.class, getPayerAccountReference());
			processRosetta(path.newSubPath("receiverPartyReference"), processor, PartyReference.PartyReferenceBuilder.class, getReceiverPartyReference());
			processRosetta(path.newSubPath("receiverAccountReference"), processor, AccountReference.AccountReferenceBuilder.class, getReceiverAccountReference());
			processRosetta(path.newSubPath("cashflowAmount"), processor, Money.MoneyBuilder.class, getCashflowAmount());
			processRosetta(path.newSubPath("cashflowType"), processor, CashflowType.CashflowTypeBuilder.class, getCashflowType());
		}
		

		GrossCashflow.GrossCashflowBuilder prune();
	}

	/*********************** Immutable Implementation of GrossCashflow  ***********************/
	class GrossCashflowImpl implements GrossCashflow {
		private final CashflowId cashflowId;
		private final PartyTradeIdentifierReference partyTradeIdentifierReference;
		private final PartyReference payerPartyReference;
		private final AccountReference payerAccountReference;
		private final PartyReference receiverPartyReference;
		private final AccountReference receiverAccountReference;
		private final Money cashflowAmount;
		private final CashflowType cashflowType;
		
		protected GrossCashflowImpl(GrossCashflow.GrossCashflowBuilder builder) {
			this.cashflowId = ofNullable(builder.getCashflowId()).map(f->f.build()).orElse(null);
			this.partyTradeIdentifierReference = ofNullable(builder.getPartyTradeIdentifierReference()).map(f->f.build()).orElse(null);
			this.payerPartyReference = ofNullable(builder.getPayerPartyReference()).map(f->f.build()).orElse(null);
			this.payerAccountReference = ofNullable(builder.getPayerAccountReference()).map(f->f.build()).orElse(null);
			this.receiverPartyReference = ofNullable(builder.getReceiverPartyReference()).map(f->f.build()).orElse(null);
			this.receiverAccountReference = ofNullable(builder.getReceiverAccountReference()).map(f->f.build()).orElse(null);
			this.cashflowAmount = ofNullable(builder.getCashflowAmount()).map(f->f.build()).orElse(null);
			this.cashflowType = ofNullable(builder.getCashflowType()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("cashflowId")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("cashflowId")
		public CashflowId getCashflowId() {
			return cashflowId;
		}
		
		@Override
		@RosettaAttribute("partyTradeIdentifierReference")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("partyTradeIdentifierReference")
		public PartyTradeIdentifierReference getPartyTradeIdentifierReference() {
			return partyTradeIdentifierReference;
		}
		
		@Override
		@RosettaAttribute("payerPartyReference")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("payerPartyReference")
		public PartyReference getPayerPartyReference() {
			return payerPartyReference;
		}
		
		@Override
		@RosettaAttribute("payerAccountReference")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("payerAccountReference")
		public AccountReference getPayerAccountReference() {
			return payerAccountReference;
		}
		
		@Override
		@RosettaAttribute("receiverPartyReference")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("receiverPartyReference")
		public PartyReference getReceiverPartyReference() {
			return receiverPartyReference;
		}
		
		@Override
		@RosettaAttribute("receiverAccountReference")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("receiverAccountReference")
		public AccountReference getReceiverAccountReference() {
			return receiverAccountReference;
		}
		
		@Override
		@RosettaAttribute("cashflowAmount")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("cashflowAmount")
		public Money getCashflowAmount() {
			return cashflowAmount;
		}
		
		@Override
		@RosettaAttribute("cashflowType")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("cashflowType")
		public CashflowType getCashflowType() {
			return cashflowType;
		}
		
		@Override
		public GrossCashflow build() {
			return this;
		}
		
		@Override
		public GrossCashflow.GrossCashflowBuilder toBuilder() {
			GrossCashflow.GrossCashflowBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(GrossCashflow.GrossCashflowBuilder builder) {
			ofNullable(getCashflowId()).ifPresent(builder::setCashflowId);
			ofNullable(getPartyTradeIdentifierReference()).ifPresent(builder::setPartyTradeIdentifierReference);
			ofNullable(getPayerPartyReference()).ifPresent(builder::setPayerPartyReference);
			ofNullable(getPayerAccountReference()).ifPresent(builder::setPayerAccountReference);
			ofNullable(getReceiverPartyReference()).ifPresent(builder::setReceiverPartyReference);
			ofNullable(getReceiverAccountReference()).ifPresent(builder::setReceiverAccountReference);
			ofNullable(getCashflowAmount()).ifPresent(builder::setCashflowAmount);
			ofNullable(getCashflowType()).ifPresent(builder::setCashflowType);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			GrossCashflow _that = getType().cast(o);
		
			if (!Objects.equals(cashflowId, _that.getCashflowId())) return false;
			if (!Objects.equals(partyTradeIdentifierReference, _that.getPartyTradeIdentifierReference())) return false;
			if (!Objects.equals(payerPartyReference, _that.getPayerPartyReference())) return false;
			if (!Objects.equals(payerAccountReference, _that.getPayerAccountReference())) return false;
			if (!Objects.equals(receiverPartyReference, _that.getReceiverPartyReference())) return false;
			if (!Objects.equals(receiverAccountReference, _that.getReceiverAccountReference())) return false;
			if (!Objects.equals(cashflowAmount, _that.getCashflowAmount())) return false;
			if (!Objects.equals(cashflowType, _that.getCashflowType())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (cashflowId != null ? cashflowId.hashCode() : 0);
			_result = 31 * _result + (partyTradeIdentifierReference != null ? partyTradeIdentifierReference.hashCode() : 0);
			_result = 31 * _result + (payerPartyReference != null ? payerPartyReference.hashCode() : 0);
			_result = 31 * _result + (payerAccountReference != null ? payerAccountReference.hashCode() : 0);
			_result = 31 * _result + (receiverPartyReference != null ? receiverPartyReference.hashCode() : 0);
			_result = 31 * _result + (receiverAccountReference != null ? receiverAccountReference.hashCode() : 0);
			_result = 31 * _result + (cashflowAmount != null ? cashflowAmount.hashCode() : 0);
			_result = 31 * _result + (cashflowType != null ? cashflowType.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "GrossCashflow {" +
				"cashflowId=" + this.cashflowId + ", " +
				"partyTradeIdentifierReference=" + this.partyTradeIdentifierReference + ", " +
				"payerPartyReference=" + this.payerPartyReference + ", " +
				"payerAccountReference=" + this.payerAccountReference + ", " +
				"receiverPartyReference=" + this.receiverPartyReference + ", " +
				"receiverAccountReference=" + this.receiverAccountReference + ", " +
				"cashflowAmount=" + this.cashflowAmount + ", " +
				"cashflowType=" + this.cashflowType +
			'}';
		}
	}

	/*********************** Builder Implementation of GrossCashflow  ***********************/
	class GrossCashflowBuilderImpl implements GrossCashflow.GrossCashflowBuilder {
	
		protected CashflowId.CashflowIdBuilder cashflowId;
		protected PartyTradeIdentifierReference.PartyTradeIdentifierReferenceBuilder partyTradeIdentifierReference;
		protected PartyReference.PartyReferenceBuilder payerPartyReference;
		protected AccountReference.AccountReferenceBuilder payerAccountReference;
		protected PartyReference.PartyReferenceBuilder receiverPartyReference;
		protected AccountReference.AccountReferenceBuilder receiverAccountReference;
		protected Money.MoneyBuilder cashflowAmount;
		protected CashflowType.CashflowTypeBuilder cashflowType;
		
		@Override
		@RosettaAttribute("cashflowId")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("cashflowId")
		public CashflowId.CashflowIdBuilder getCashflowId() {
			return cashflowId;
		}
		
		@Override
		public CashflowId.CashflowIdBuilder getOrCreateCashflowId() {
			CashflowId.CashflowIdBuilder result;
			if (cashflowId!=null) {
				result = cashflowId;
			}
			else {
				result = cashflowId = CashflowId.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("partyTradeIdentifierReference")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("partyTradeIdentifierReference")
		public PartyTradeIdentifierReference.PartyTradeIdentifierReferenceBuilder getPartyTradeIdentifierReference() {
			return partyTradeIdentifierReference;
		}
		
		@Override
		public PartyTradeIdentifierReference.PartyTradeIdentifierReferenceBuilder getOrCreatePartyTradeIdentifierReference() {
			PartyTradeIdentifierReference.PartyTradeIdentifierReferenceBuilder result;
			if (partyTradeIdentifierReference!=null) {
				result = partyTradeIdentifierReference;
			}
			else {
				result = partyTradeIdentifierReference = PartyTradeIdentifierReference.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("payerPartyReference")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("payerPartyReference")
		public PartyReference.PartyReferenceBuilder getPayerPartyReference() {
			return payerPartyReference;
		}
		
		@Override
		public PartyReference.PartyReferenceBuilder getOrCreatePayerPartyReference() {
			PartyReference.PartyReferenceBuilder result;
			if (payerPartyReference!=null) {
				result = payerPartyReference;
			}
			else {
				result = payerPartyReference = PartyReference.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("payerAccountReference")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("payerAccountReference")
		public AccountReference.AccountReferenceBuilder getPayerAccountReference() {
			return payerAccountReference;
		}
		
		@Override
		public AccountReference.AccountReferenceBuilder getOrCreatePayerAccountReference() {
			AccountReference.AccountReferenceBuilder result;
			if (payerAccountReference!=null) {
				result = payerAccountReference;
			}
			else {
				result = payerAccountReference = AccountReference.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("receiverPartyReference")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("receiverPartyReference")
		public PartyReference.PartyReferenceBuilder getReceiverPartyReference() {
			return receiverPartyReference;
		}
		
		@Override
		public PartyReference.PartyReferenceBuilder getOrCreateReceiverPartyReference() {
			PartyReference.PartyReferenceBuilder result;
			if (receiverPartyReference!=null) {
				result = receiverPartyReference;
			}
			else {
				result = receiverPartyReference = PartyReference.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("receiverAccountReference")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("receiverAccountReference")
		public AccountReference.AccountReferenceBuilder getReceiverAccountReference() {
			return receiverAccountReference;
		}
		
		@Override
		public AccountReference.AccountReferenceBuilder getOrCreateReceiverAccountReference() {
			AccountReference.AccountReferenceBuilder result;
			if (receiverAccountReference!=null) {
				result = receiverAccountReference;
			}
			else {
				result = receiverAccountReference = AccountReference.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("cashflowAmount")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("cashflowAmount")
		public Money.MoneyBuilder getCashflowAmount() {
			return cashflowAmount;
		}
		
		@Override
		public Money.MoneyBuilder getOrCreateCashflowAmount() {
			Money.MoneyBuilder result;
			if (cashflowAmount!=null) {
				result = cashflowAmount;
			}
			else {
				result = cashflowAmount = Money.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("cashflowType")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("cashflowType")
		public CashflowType.CashflowTypeBuilder getCashflowType() {
			return cashflowType;
		}
		
		@Override
		public CashflowType.CashflowTypeBuilder getOrCreateCashflowType() {
			CashflowType.CashflowTypeBuilder result;
			if (cashflowType!=null) {
				result = cashflowType;
			}
			else {
				result = cashflowType = CashflowType.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("cashflowId")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("cashflowId")
		@Override
		public GrossCashflow.GrossCashflowBuilder setCashflowId(CashflowId _cashflowId) {
			this.cashflowId = _cashflowId == null ? null : _cashflowId.toBuilder();
			return this;
		}
		
		@RosettaAttribute("partyTradeIdentifierReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("partyTradeIdentifierReference")
		@Override
		public GrossCashflow.GrossCashflowBuilder setPartyTradeIdentifierReference(PartyTradeIdentifierReference _partyTradeIdentifierReference) {
			this.partyTradeIdentifierReference = _partyTradeIdentifierReference == null ? null : _partyTradeIdentifierReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("payerPartyReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("payerPartyReference")
		@Override
		public GrossCashflow.GrossCashflowBuilder setPayerPartyReference(PartyReference _payerPartyReference) {
			this.payerPartyReference = _payerPartyReference == null ? null : _payerPartyReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("payerAccountReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("payerAccountReference")
		@Override
		public GrossCashflow.GrossCashflowBuilder setPayerAccountReference(AccountReference _payerAccountReference) {
			this.payerAccountReference = _payerAccountReference == null ? null : _payerAccountReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("receiverPartyReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("receiverPartyReference")
		@Override
		public GrossCashflow.GrossCashflowBuilder setReceiverPartyReference(PartyReference _receiverPartyReference) {
			this.receiverPartyReference = _receiverPartyReference == null ? null : _receiverPartyReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("receiverAccountReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("receiverAccountReference")
		@Override
		public GrossCashflow.GrossCashflowBuilder setReceiverAccountReference(AccountReference _receiverAccountReference) {
			this.receiverAccountReference = _receiverAccountReference == null ? null : _receiverAccountReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("cashflowAmount")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("cashflowAmount")
		@Override
		public GrossCashflow.GrossCashflowBuilder setCashflowAmount(Money _cashflowAmount) {
			this.cashflowAmount = _cashflowAmount == null ? null : _cashflowAmount.toBuilder();
			return this;
		}
		
		@RosettaAttribute("cashflowType")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("cashflowType")
		@Override
		public GrossCashflow.GrossCashflowBuilder setCashflowType(CashflowType _cashflowType) {
			this.cashflowType = _cashflowType == null ? null : _cashflowType.toBuilder();
			return this;
		}
		
		@Override
		public GrossCashflow build() {
			return new GrossCashflow.GrossCashflowImpl(this);
		}
		
		@Override
		public GrossCashflow.GrossCashflowBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public GrossCashflow.GrossCashflowBuilder prune() {
			if (cashflowId!=null && !cashflowId.prune().hasData()) cashflowId = null;
			if (partyTradeIdentifierReference!=null && !partyTradeIdentifierReference.prune().hasData()) partyTradeIdentifierReference = null;
			if (payerPartyReference!=null && !payerPartyReference.prune().hasData()) payerPartyReference = null;
			if (payerAccountReference!=null && !payerAccountReference.prune().hasData()) payerAccountReference = null;
			if (receiverPartyReference!=null && !receiverPartyReference.prune().hasData()) receiverPartyReference = null;
			if (receiverAccountReference!=null && !receiverAccountReference.prune().hasData()) receiverAccountReference = null;
			if (cashflowAmount!=null && !cashflowAmount.prune().hasData()) cashflowAmount = null;
			if (cashflowType!=null && !cashflowType.prune().hasData()) cashflowType = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getCashflowId()!=null && getCashflowId().hasData()) return true;
			if (getPartyTradeIdentifierReference()!=null && getPartyTradeIdentifierReference().hasData()) return true;
			if (getPayerPartyReference()!=null && getPayerPartyReference().hasData()) return true;
			if (getPayerAccountReference()!=null && getPayerAccountReference().hasData()) return true;
			if (getReceiverPartyReference()!=null && getReceiverPartyReference().hasData()) return true;
			if (getReceiverAccountReference()!=null && getReceiverAccountReference().hasData()) return true;
			if (getCashflowAmount()!=null && getCashflowAmount().hasData()) return true;
			if (getCashflowType()!=null && getCashflowType().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public GrossCashflow.GrossCashflowBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			GrossCashflow.GrossCashflowBuilder o = (GrossCashflow.GrossCashflowBuilder) other;
			
			merger.mergeRosetta(getCashflowId(), o.getCashflowId(), this::setCashflowId);
			merger.mergeRosetta(getPartyTradeIdentifierReference(), o.getPartyTradeIdentifierReference(), this::setPartyTradeIdentifierReference);
			merger.mergeRosetta(getPayerPartyReference(), o.getPayerPartyReference(), this::setPayerPartyReference);
			merger.mergeRosetta(getPayerAccountReference(), o.getPayerAccountReference(), this::setPayerAccountReference);
			merger.mergeRosetta(getReceiverPartyReference(), o.getReceiverPartyReference(), this::setReceiverPartyReference);
			merger.mergeRosetta(getReceiverAccountReference(), o.getReceiverAccountReference(), this::setReceiverAccountReference);
			merger.mergeRosetta(getCashflowAmount(), o.getCashflowAmount(), this::setCashflowAmount);
			merger.mergeRosetta(getCashflowType(), o.getCashflowType(), this::setCashflowType);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			GrossCashflow _that = getType().cast(o);
		
			if (!Objects.equals(cashflowId, _that.getCashflowId())) return false;
			if (!Objects.equals(partyTradeIdentifierReference, _that.getPartyTradeIdentifierReference())) return false;
			if (!Objects.equals(payerPartyReference, _that.getPayerPartyReference())) return false;
			if (!Objects.equals(payerAccountReference, _that.getPayerAccountReference())) return false;
			if (!Objects.equals(receiverPartyReference, _that.getReceiverPartyReference())) return false;
			if (!Objects.equals(receiverAccountReference, _that.getReceiverAccountReference())) return false;
			if (!Objects.equals(cashflowAmount, _that.getCashflowAmount())) return false;
			if (!Objects.equals(cashflowType, _that.getCashflowType())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (cashflowId != null ? cashflowId.hashCode() : 0);
			_result = 31 * _result + (partyTradeIdentifierReference != null ? partyTradeIdentifierReference.hashCode() : 0);
			_result = 31 * _result + (payerPartyReference != null ? payerPartyReference.hashCode() : 0);
			_result = 31 * _result + (payerAccountReference != null ? payerAccountReference.hashCode() : 0);
			_result = 31 * _result + (receiverPartyReference != null ? receiverPartyReference.hashCode() : 0);
			_result = 31 * _result + (receiverAccountReference != null ? receiverAccountReference.hashCode() : 0);
			_result = 31 * _result + (cashflowAmount != null ? cashflowAmount.hashCode() : 0);
			_result = 31 * _result + (cashflowType != null ? cashflowType.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "GrossCashflowBuilder {" +
				"cashflowId=" + this.cashflowId + ", " +
				"partyTradeIdentifierReference=" + this.partyTradeIdentifierReference + ", " +
				"payerPartyReference=" + this.payerPartyReference + ", " +
				"payerAccountReference=" + this.payerAccountReference + ", " +
				"receiverPartyReference=" + this.receiverPartyReference + ", " +
				"receiverAccountReference=" + this.receiverAccountReference + ", " +
				"cashflowAmount=" + this.cashflowAmount + ", " +
				"cashflowType=" + this.cashflowType +
			'}';
		}
	}
}

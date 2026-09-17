package fpml.consolidated.doc;

import com.google.common.collect.ImmutableList;
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
import com.rosetta.util.ListEquals;
import fpml.consolidated.doc.meta.AllocationMeta;
import fpml.consolidated.shared.AccountReference;
import fpml.consolidated.shared.Collateral;
import fpml.consolidated.shared.Money;
import fpml.consolidated.shared.PartyReference;
import fpml.consolidated.shared.RelatedParty;
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
@RosettaDataType(value="Allocation", builder=Allocation.AllocationBuilderImpl.class, version="2.1.1")
@RuneDataType(value="Allocation", model="fpml", builder=Allocation.AllocationBuilderImpl.class, version="2.1.1")
public interface Allocation extends RosettaModelObject {

	AllocationMeta metaData = new AllocationMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Unique ID for the allocation. Multiple allocation trade IDs are provided to allow for the use of USI/UTI representations along with party-specific trade identifiers.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Unique ID for the allocation. Multiple allocation trade IDs are provided to allow for the use of USI/UTI representations along with party-specific trade identifiers.
	 *
	 */
	List<? extends TradeIdentifier> getAllocationTradeId();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Reference to a party.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Reference to a party.
	 *
	 */
	PartyReference getPartyReference();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Reference to an account.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Reference to an account.
	 *
	 */
	AccountReference getAccountReference();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The fractional allocation (0.45 = 45%) of the notional and "block" fees to this particular client subaccount.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The fractional allocation (0.45 = 45%) of the notional and "block" fees to this particular client subaccount.
	 *
	 */
	BigDecimal getAllocatedFraction();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The notional allocation (amount and currency) to this particular client account.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The notional allocation (amount and currency) to this particular client account.
	 *
	 */
	List<? extends Money> getAllocatedNotional();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The sum that must be posted upfront to collateralize against counterparty credit risk.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The sum that must be posted upfront to collateralize against counterparty credit risk.
	 *
	 */
	Collateral getCollateral();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Special credit fee assessed to certain institutions.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Special credit fee assessed to certain institutions.
	 *
	 */
	Money getCreditChargeAmount();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision A container for approval states in the workflow.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A container for approval states in the workflow.
	 *
	 */
	Approvals getApprovals();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The date of the confirmation executed between the parties and intended to govern the allocated trade between those parties.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The date of the confirmation executed between the parties and intended to govern the allocated trade between those parties.
	 *
	 */
	ZonedDateTime getMasterConfirmationDate();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Specifies any relevant parties to the allocation which should be referenced.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Specifies any relevant parties to the allocation which should be referenced.
	 *
	 */
	List<? extends RelatedParty> getRelatedParty();

	/*********************** Build Methods  ***********************/
	Allocation build();
	
	Allocation.AllocationBuilder toBuilder();
	
	static Allocation.AllocationBuilder builder() {
		return new Allocation.AllocationBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends Allocation> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends Allocation> getType() {
		return Allocation.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("allocationTradeId"), processor, TradeIdentifier.class, getAllocationTradeId());
		processRosetta(path.newSubPath("partyReference"), processor, PartyReference.class, getPartyReference());
		processRosetta(path.newSubPath("accountReference"), processor, AccountReference.class, getAccountReference());
		processor.processBasic(path.newSubPath("allocatedFraction"), BigDecimal.class, getAllocatedFraction(), this);
		processRosetta(path.newSubPath("allocatedNotional"), processor, Money.class, getAllocatedNotional());
		processRosetta(path.newSubPath("collateral"), processor, Collateral.class, getCollateral());
		processRosetta(path.newSubPath("creditChargeAmount"), processor, Money.class, getCreditChargeAmount());
		processRosetta(path.newSubPath("approvals"), processor, Approvals.class, getApprovals());
		processor.processBasic(path.newSubPath("masterConfirmationDate"), ZonedDateTime.class, getMasterConfirmationDate(), this);
		processRosetta(path.newSubPath("relatedParty"), processor, RelatedParty.class, getRelatedParty());
	}
	

	/*********************** Builder Interface  ***********************/
	interface AllocationBuilder extends Allocation, RosettaModelObjectBuilder {
		TradeIdentifier.TradeIdentifierBuilder getOrCreateAllocationTradeId(int index);
		@Override
		List<? extends TradeIdentifier.TradeIdentifierBuilder> getAllocationTradeId();
		PartyReference.PartyReferenceBuilder getOrCreatePartyReference();
		@Override
		PartyReference.PartyReferenceBuilder getPartyReference();
		AccountReference.AccountReferenceBuilder getOrCreateAccountReference();
		@Override
		AccountReference.AccountReferenceBuilder getAccountReference();
		Money.MoneyBuilder getOrCreateAllocatedNotional(int index);
		@Override
		List<? extends Money.MoneyBuilder> getAllocatedNotional();
		Collateral.CollateralBuilder getOrCreateCollateral();
		@Override
		Collateral.CollateralBuilder getCollateral();
		Money.MoneyBuilder getOrCreateCreditChargeAmount();
		@Override
		Money.MoneyBuilder getCreditChargeAmount();
		Approvals.ApprovalsBuilder getOrCreateApprovals();
		@Override
		Approvals.ApprovalsBuilder getApprovals();
		RelatedParty.RelatedPartyBuilder getOrCreateRelatedParty(int index);
		@Override
		List<? extends RelatedParty.RelatedPartyBuilder> getRelatedParty();
		Allocation.AllocationBuilder addAllocationTradeId(TradeIdentifier allocationTradeId);
		Allocation.AllocationBuilder addAllocationTradeId(TradeIdentifier allocationTradeId, int idx);
		Allocation.AllocationBuilder addAllocationTradeId(List<? extends TradeIdentifier> allocationTradeId);
		Allocation.AllocationBuilder setAllocationTradeId(List<? extends TradeIdentifier> allocationTradeId);
		Allocation.AllocationBuilder setPartyReference(PartyReference partyReference);
		Allocation.AllocationBuilder setAccountReference(AccountReference accountReference);
		Allocation.AllocationBuilder setAllocatedFraction(BigDecimal allocatedFraction);
		Allocation.AllocationBuilder addAllocatedNotional(Money allocatedNotional);
		Allocation.AllocationBuilder addAllocatedNotional(Money allocatedNotional, int idx);
		Allocation.AllocationBuilder addAllocatedNotional(List<? extends Money> allocatedNotional);
		Allocation.AllocationBuilder setAllocatedNotional(List<? extends Money> allocatedNotional);
		Allocation.AllocationBuilder setCollateral(Collateral collateral);
		Allocation.AllocationBuilder setCreditChargeAmount(Money creditChargeAmount);
		Allocation.AllocationBuilder setApprovals(Approvals approvals);
		Allocation.AllocationBuilder setMasterConfirmationDate(ZonedDateTime masterConfirmationDate);
		Allocation.AllocationBuilder addRelatedParty(RelatedParty relatedParty);
		Allocation.AllocationBuilder addRelatedParty(RelatedParty relatedParty, int idx);
		Allocation.AllocationBuilder addRelatedParty(List<? extends RelatedParty> relatedParty);
		Allocation.AllocationBuilder setRelatedParty(List<? extends RelatedParty> relatedParty);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("allocationTradeId"), processor, TradeIdentifier.TradeIdentifierBuilder.class, getAllocationTradeId());
			processRosetta(path.newSubPath("partyReference"), processor, PartyReference.PartyReferenceBuilder.class, getPartyReference());
			processRosetta(path.newSubPath("accountReference"), processor, AccountReference.AccountReferenceBuilder.class, getAccountReference());
			processor.processBasic(path.newSubPath("allocatedFraction"), BigDecimal.class, getAllocatedFraction(), this);
			processRosetta(path.newSubPath("allocatedNotional"), processor, Money.MoneyBuilder.class, getAllocatedNotional());
			processRosetta(path.newSubPath("collateral"), processor, Collateral.CollateralBuilder.class, getCollateral());
			processRosetta(path.newSubPath("creditChargeAmount"), processor, Money.MoneyBuilder.class, getCreditChargeAmount());
			processRosetta(path.newSubPath("approvals"), processor, Approvals.ApprovalsBuilder.class, getApprovals());
			processor.processBasic(path.newSubPath("masterConfirmationDate"), ZonedDateTime.class, getMasterConfirmationDate(), this);
			processRosetta(path.newSubPath("relatedParty"), processor, RelatedParty.RelatedPartyBuilder.class, getRelatedParty());
		}
		

		Allocation.AllocationBuilder prune();
	}

	/*********************** Immutable Implementation of Allocation  ***********************/
	class AllocationImpl implements Allocation {
		private final List<? extends TradeIdentifier> allocationTradeId;
		private final PartyReference partyReference;
		private final AccountReference accountReference;
		private final BigDecimal allocatedFraction;
		private final List<? extends Money> allocatedNotional;
		private final Collateral collateral;
		private final Money creditChargeAmount;
		private final Approvals approvals;
		private final ZonedDateTime masterConfirmationDate;
		private final List<? extends RelatedParty> relatedParty;
		
		protected AllocationImpl(Allocation.AllocationBuilder builder) {
			this.allocationTradeId = ofNullable(builder.getAllocationTradeId()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.partyReference = ofNullable(builder.getPartyReference()).map(f->f.build()).orElse(null);
			this.accountReference = ofNullable(builder.getAccountReference()).map(f->f.build()).orElse(null);
			this.allocatedFraction = builder.getAllocatedFraction();
			this.allocatedNotional = ofNullable(builder.getAllocatedNotional()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.collateral = ofNullable(builder.getCollateral()).map(f->f.build()).orElse(null);
			this.creditChargeAmount = ofNullable(builder.getCreditChargeAmount()).map(f->f.build()).orElse(null);
			this.approvals = ofNullable(builder.getApprovals()).map(f->f.build()).orElse(null);
			this.masterConfirmationDate = builder.getMasterConfirmationDate();
			this.relatedParty = ofNullable(builder.getRelatedParty()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		@RosettaAttribute("allocationTradeId")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("allocationTradeId")
		public List<? extends TradeIdentifier> getAllocationTradeId() {
			return allocationTradeId;
		}
		
		@Override
		@RosettaAttribute("partyReference")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("partyReference")
		public PartyReference getPartyReference() {
			return partyReference;
		}
		
		@Override
		@RosettaAttribute("accountReference")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("accountReference")
		public AccountReference getAccountReference() {
			return accountReference;
		}
		
		@Override
		@RosettaAttribute("allocatedFraction")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("allocatedFraction")
		public BigDecimal getAllocatedFraction() {
			return allocatedFraction;
		}
		
		@Override
		@RosettaAttribute("allocatedNotional")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("allocatedNotional")
		public List<? extends Money> getAllocatedNotional() {
			return allocatedNotional;
		}
		
		@Override
		@RosettaAttribute("collateral")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("collateral")
		public Collateral getCollateral() {
			return collateral;
		}
		
		@Override
		@RosettaAttribute("creditChargeAmount")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("creditChargeAmount")
		public Money getCreditChargeAmount() {
			return creditChargeAmount;
		}
		
		@Override
		@RosettaAttribute("approvals")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("approvals")
		public Approvals getApprovals() {
			return approvals;
		}
		
		@Override
		@RosettaAttribute("masterConfirmationDate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("masterConfirmationDate")
		public ZonedDateTime getMasterConfirmationDate() {
			return masterConfirmationDate;
		}
		
		@Override
		@RosettaAttribute("relatedParty")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("relatedParty")
		public List<? extends RelatedParty> getRelatedParty() {
			return relatedParty;
		}
		
		@Override
		public Allocation build() {
			return this;
		}
		
		@Override
		public Allocation.AllocationBuilder toBuilder() {
			Allocation.AllocationBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(Allocation.AllocationBuilder builder) {
			ofNullable(getAllocationTradeId()).ifPresent(builder::setAllocationTradeId);
			ofNullable(getPartyReference()).ifPresent(builder::setPartyReference);
			ofNullable(getAccountReference()).ifPresent(builder::setAccountReference);
			ofNullable(getAllocatedFraction()).ifPresent(builder::setAllocatedFraction);
			ofNullable(getAllocatedNotional()).ifPresent(builder::setAllocatedNotional);
			ofNullable(getCollateral()).ifPresent(builder::setCollateral);
			ofNullable(getCreditChargeAmount()).ifPresent(builder::setCreditChargeAmount);
			ofNullable(getApprovals()).ifPresent(builder::setApprovals);
			ofNullable(getMasterConfirmationDate()).ifPresent(builder::setMasterConfirmationDate);
			ofNullable(getRelatedParty()).ifPresent(builder::setRelatedParty);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			Allocation _that = getType().cast(o);
		
			if (!ListEquals.listEquals(allocationTradeId, _that.getAllocationTradeId())) return false;
			if (!Objects.equals(partyReference, _that.getPartyReference())) return false;
			if (!Objects.equals(accountReference, _that.getAccountReference())) return false;
			if (!Objects.equals(allocatedFraction, _that.getAllocatedFraction())) return false;
			if (!ListEquals.listEquals(allocatedNotional, _that.getAllocatedNotional())) return false;
			if (!Objects.equals(collateral, _that.getCollateral())) return false;
			if (!Objects.equals(creditChargeAmount, _that.getCreditChargeAmount())) return false;
			if (!Objects.equals(approvals, _that.getApprovals())) return false;
			if (!Objects.equals(masterConfirmationDate, _that.getMasterConfirmationDate())) return false;
			if (!ListEquals.listEquals(relatedParty, _that.getRelatedParty())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (allocationTradeId != null ? allocationTradeId.hashCode() : 0);
			_result = 31 * _result + (partyReference != null ? partyReference.hashCode() : 0);
			_result = 31 * _result + (accountReference != null ? accountReference.hashCode() : 0);
			_result = 31 * _result + (allocatedFraction != null ? allocatedFraction.hashCode() : 0);
			_result = 31 * _result + (allocatedNotional != null ? allocatedNotional.hashCode() : 0);
			_result = 31 * _result + (collateral != null ? collateral.hashCode() : 0);
			_result = 31 * _result + (creditChargeAmount != null ? creditChargeAmount.hashCode() : 0);
			_result = 31 * _result + (approvals != null ? approvals.hashCode() : 0);
			_result = 31 * _result + (masterConfirmationDate != null ? masterConfirmationDate.hashCode() : 0);
			_result = 31 * _result + (relatedParty != null ? relatedParty.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "Allocation {" +
				"allocationTradeId=" + this.allocationTradeId + ", " +
				"partyReference=" + this.partyReference + ", " +
				"accountReference=" + this.accountReference + ", " +
				"allocatedFraction=" + this.allocatedFraction + ", " +
				"allocatedNotional=" + this.allocatedNotional + ", " +
				"collateral=" + this.collateral + ", " +
				"creditChargeAmount=" + this.creditChargeAmount + ", " +
				"approvals=" + this.approvals + ", " +
				"masterConfirmationDate=" + this.masterConfirmationDate + ", " +
				"relatedParty=" + this.relatedParty +
			'}';
		}
	}

	/*********************** Builder Implementation of Allocation  ***********************/
	class AllocationBuilderImpl implements Allocation.AllocationBuilder {
	
		protected List<TradeIdentifier.TradeIdentifierBuilder> allocationTradeId = new ArrayList<>();
		protected PartyReference.PartyReferenceBuilder partyReference;
		protected AccountReference.AccountReferenceBuilder accountReference;
		protected BigDecimal allocatedFraction;
		protected List<Money.MoneyBuilder> allocatedNotional = new ArrayList<>();
		protected Collateral.CollateralBuilder collateral;
		protected Money.MoneyBuilder creditChargeAmount;
		protected Approvals.ApprovalsBuilder approvals;
		protected ZonedDateTime masterConfirmationDate;
		protected List<RelatedParty.RelatedPartyBuilder> relatedParty = new ArrayList<>();
		
		@Override
		@RosettaAttribute("allocationTradeId")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("allocationTradeId")
		public List<? extends TradeIdentifier.TradeIdentifierBuilder> getAllocationTradeId() {
			return allocationTradeId;
		}
		
		@Override
		public TradeIdentifier.TradeIdentifierBuilder getOrCreateAllocationTradeId(int index) {
			if (allocationTradeId==null) {
				this.allocationTradeId = new ArrayList<>();
			}
			return getIndex(allocationTradeId, index, () -> {
						TradeIdentifier.TradeIdentifierBuilder newAllocationTradeId = TradeIdentifier.builder();
						return newAllocationTradeId;
					});
		}
		
		@Override
		@RosettaAttribute("partyReference")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("partyReference")
		public PartyReference.PartyReferenceBuilder getPartyReference() {
			return partyReference;
		}
		
		@Override
		public PartyReference.PartyReferenceBuilder getOrCreatePartyReference() {
			PartyReference.PartyReferenceBuilder result;
			if (partyReference!=null) {
				result = partyReference;
			}
			else {
				result = partyReference = PartyReference.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("accountReference")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("accountReference")
		public AccountReference.AccountReferenceBuilder getAccountReference() {
			return accountReference;
		}
		
		@Override
		public AccountReference.AccountReferenceBuilder getOrCreateAccountReference() {
			AccountReference.AccountReferenceBuilder result;
			if (accountReference!=null) {
				result = accountReference;
			}
			else {
				result = accountReference = AccountReference.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("allocatedFraction")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("allocatedFraction")
		public BigDecimal getAllocatedFraction() {
			return allocatedFraction;
		}
		
		@Override
		@RosettaAttribute("allocatedNotional")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("allocatedNotional")
		public List<? extends Money.MoneyBuilder> getAllocatedNotional() {
			return allocatedNotional;
		}
		
		@Override
		public Money.MoneyBuilder getOrCreateAllocatedNotional(int index) {
			if (allocatedNotional==null) {
				this.allocatedNotional = new ArrayList<>();
			}
			return getIndex(allocatedNotional, index, () -> {
						Money.MoneyBuilder newAllocatedNotional = Money.builder();
						return newAllocatedNotional;
					});
		}
		
		@Override
		@RosettaAttribute("collateral")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("collateral")
		public Collateral.CollateralBuilder getCollateral() {
			return collateral;
		}
		
		@Override
		public Collateral.CollateralBuilder getOrCreateCollateral() {
			Collateral.CollateralBuilder result;
			if (collateral!=null) {
				result = collateral;
			}
			else {
				result = collateral = Collateral.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("creditChargeAmount")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("creditChargeAmount")
		public Money.MoneyBuilder getCreditChargeAmount() {
			return creditChargeAmount;
		}
		
		@Override
		public Money.MoneyBuilder getOrCreateCreditChargeAmount() {
			Money.MoneyBuilder result;
			if (creditChargeAmount!=null) {
				result = creditChargeAmount;
			}
			else {
				result = creditChargeAmount = Money.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("approvals")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("approvals")
		public Approvals.ApprovalsBuilder getApprovals() {
			return approvals;
		}
		
		@Override
		public Approvals.ApprovalsBuilder getOrCreateApprovals() {
			Approvals.ApprovalsBuilder result;
			if (approvals!=null) {
				result = approvals;
			}
			else {
				result = approvals = Approvals.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("masterConfirmationDate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("masterConfirmationDate")
		public ZonedDateTime getMasterConfirmationDate() {
			return masterConfirmationDate;
		}
		
		@Override
		@RosettaAttribute("relatedParty")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("relatedParty")
		public List<? extends RelatedParty.RelatedPartyBuilder> getRelatedParty() {
			return relatedParty;
		}
		
		@Override
		public RelatedParty.RelatedPartyBuilder getOrCreateRelatedParty(int index) {
			if (relatedParty==null) {
				this.relatedParty = new ArrayList<>();
			}
			return getIndex(relatedParty, index, () -> {
						RelatedParty.RelatedPartyBuilder newRelatedParty = RelatedParty.builder();
						return newRelatedParty;
					});
		}
		
		@RosettaAttribute("allocationTradeId")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("allocationTradeId")
		@Override
		public Allocation.AllocationBuilder addAllocationTradeId(TradeIdentifier _allocationTradeId) {
			if (_allocationTradeId != null) {
				this.allocationTradeId.add(_allocationTradeId.toBuilder());
			}
			return this;
		}
		
		@Override
		public Allocation.AllocationBuilder addAllocationTradeId(TradeIdentifier _allocationTradeId, int idx) {
			getIndex(this.allocationTradeId, idx, () -> _allocationTradeId.toBuilder());
			return this;
		}
		
		@Override
		public Allocation.AllocationBuilder addAllocationTradeId(List<? extends TradeIdentifier> allocationTradeIds) {
			if (allocationTradeIds != null) {
				for (final TradeIdentifier toAdd : allocationTradeIds) {
					this.allocationTradeId.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("allocationTradeId")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("allocationTradeId")
		@Override
		public Allocation.AllocationBuilder setAllocationTradeId(List<? extends TradeIdentifier> allocationTradeIds) {
			if (allocationTradeIds == null) {
				this.allocationTradeId = new ArrayList<>();
			} else {
				this.allocationTradeId = allocationTradeIds.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("partyReference")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("partyReference")
		@Override
		public Allocation.AllocationBuilder setPartyReference(PartyReference _partyReference) {
			this.partyReference = _partyReference == null ? null : _partyReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("accountReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("accountReference")
		@Override
		public Allocation.AllocationBuilder setAccountReference(AccountReference _accountReference) {
			this.accountReference = _accountReference == null ? null : _accountReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("allocatedFraction")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("allocatedFraction")
		@Override
		public Allocation.AllocationBuilder setAllocatedFraction(BigDecimal _allocatedFraction) {
			this.allocatedFraction = _allocatedFraction == null ? null : _allocatedFraction;
			return this;
		}
		
		@RosettaAttribute("allocatedNotional")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("allocatedNotional")
		@Override
		public Allocation.AllocationBuilder addAllocatedNotional(Money _allocatedNotional) {
			if (_allocatedNotional != null) {
				this.allocatedNotional.add(_allocatedNotional.toBuilder());
			}
			return this;
		}
		
		@Override
		public Allocation.AllocationBuilder addAllocatedNotional(Money _allocatedNotional, int idx) {
			getIndex(this.allocatedNotional, idx, () -> _allocatedNotional.toBuilder());
			return this;
		}
		
		@Override
		public Allocation.AllocationBuilder addAllocatedNotional(List<? extends Money> allocatedNotionals) {
			if (allocatedNotionals != null) {
				for (final Money toAdd : allocatedNotionals) {
					this.allocatedNotional.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("allocatedNotional")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("allocatedNotional")
		@Override
		public Allocation.AllocationBuilder setAllocatedNotional(List<? extends Money> allocatedNotionals) {
			if (allocatedNotionals == null) {
				this.allocatedNotional = new ArrayList<>();
			} else {
				this.allocatedNotional = allocatedNotionals.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("collateral")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("collateral")
		@Override
		public Allocation.AllocationBuilder setCollateral(Collateral _collateral) {
			this.collateral = _collateral == null ? null : _collateral.toBuilder();
			return this;
		}
		
		@RosettaAttribute("creditChargeAmount")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("creditChargeAmount")
		@Override
		public Allocation.AllocationBuilder setCreditChargeAmount(Money _creditChargeAmount) {
			this.creditChargeAmount = _creditChargeAmount == null ? null : _creditChargeAmount.toBuilder();
			return this;
		}
		
		@RosettaAttribute("approvals")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("approvals")
		@Override
		public Allocation.AllocationBuilder setApprovals(Approvals _approvals) {
			this.approvals = _approvals == null ? null : _approvals.toBuilder();
			return this;
		}
		
		@RosettaAttribute("masterConfirmationDate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("masterConfirmationDate")
		@Override
		public Allocation.AllocationBuilder setMasterConfirmationDate(ZonedDateTime _masterConfirmationDate) {
			this.masterConfirmationDate = _masterConfirmationDate == null ? null : _masterConfirmationDate;
			return this;
		}
		
		@RosettaAttribute("relatedParty")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("relatedParty")
		@Override
		public Allocation.AllocationBuilder addRelatedParty(RelatedParty _relatedParty) {
			if (_relatedParty != null) {
				this.relatedParty.add(_relatedParty.toBuilder());
			}
			return this;
		}
		
		@Override
		public Allocation.AllocationBuilder addRelatedParty(RelatedParty _relatedParty, int idx) {
			getIndex(this.relatedParty, idx, () -> _relatedParty.toBuilder());
			return this;
		}
		
		@Override
		public Allocation.AllocationBuilder addRelatedParty(List<? extends RelatedParty> relatedPartys) {
			if (relatedPartys != null) {
				for (final RelatedParty toAdd : relatedPartys) {
					this.relatedParty.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("relatedParty")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("relatedParty")
		@Override
		public Allocation.AllocationBuilder setRelatedParty(List<? extends RelatedParty> relatedPartys) {
			if (relatedPartys == null) {
				this.relatedParty = new ArrayList<>();
			} else {
				this.relatedParty = relatedPartys.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		public Allocation build() {
			return new Allocation.AllocationImpl(this);
		}
		
		@Override
		public Allocation.AllocationBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Allocation.AllocationBuilder prune() {
			allocationTradeId = allocationTradeId.stream().filter(b->b!=null).<TradeIdentifier.TradeIdentifierBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			if (partyReference!=null && !partyReference.prune().hasData()) partyReference = null;
			if (accountReference!=null && !accountReference.prune().hasData()) accountReference = null;
			allocatedNotional = allocatedNotional.stream().filter(b->b!=null).<Money.MoneyBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			if (collateral!=null && !collateral.prune().hasData()) collateral = null;
			if (creditChargeAmount!=null && !creditChargeAmount.prune().hasData()) creditChargeAmount = null;
			if (approvals!=null && !approvals.prune().hasData()) approvals = null;
			relatedParty = relatedParty.stream().filter(b->b!=null).<RelatedParty.RelatedPartyBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getAllocationTradeId()!=null && getAllocationTradeId().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getPartyReference()!=null && getPartyReference().hasData()) return true;
			if (getAccountReference()!=null && getAccountReference().hasData()) return true;
			if (getAllocatedFraction()!=null) return true;
			if (getAllocatedNotional()!=null && getAllocatedNotional().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getCollateral()!=null && getCollateral().hasData()) return true;
			if (getCreditChargeAmount()!=null && getCreditChargeAmount().hasData()) return true;
			if (getApprovals()!=null && getApprovals().hasData()) return true;
			if (getMasterConfirmationDate()!=null) return true;
			if (getRelatedParty()!=null && getRelatedParty().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Allocation.AllocationBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			Allocation.AllocationBuilder o = (Allocation.AllocationBuilder) other;
			
			merger.mergeRosetta(getAllocationTradeId(), o.getAllocationTradeId(), this::getOrCreateAllocationTradeId);
			merger.mergeRosetta(getPartyReference(), o.getPartyReference(), this::setPartyReference);
			merger.mergeRosetta(getAccountReference(), o.getAccountReference(), this::setAccountReference);
			merger.mergeRosetta(getAllocatedNotional(), o.getAllocatedNotional(), this::getOrCreateAllocatedNotional);
			merger.mergeRosetta(getCollateral(), o.getCollateral(), this::setCollateral);
			merger.mergeRosetta(getCreditChargeAmount(), o.getCreditChargeAmount(), this::setCreditChargeAmount);
			merger.mergeRosetta(getApprovals(), o.getApprovals(), this::setApprovals);
			merger.mergeRosetta(getRelatedParty(), o.getRelatedParty(), this::getOrCreateRelatedParty);
			
			merger.mergeBasic(getAllocatedFraction(), o.getAllocatedFraction(), this::setAllocatedFraction);
			merger.mergeBasic(getMasterConfirmationDate(), o.getMasterConfirmationDate(), this::setMasterConfirmationDate);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			Allocation _that = getType().cast(o);
		
			if (!ListEquals.listEquals(allocationTradeId, _that.getAllocationTradeId())) return false;
			if (!Objects.equals(partyReference, _that.getPartyReference())) return false;
			if (!Objects.equals(accountReference, _that.getAccountReference())) return false;
			if (!Objects.equals(allocatedFraction, _that.getAllocatedFraction())) return false;
			if (!ListEquals.listEquals(allocatedNotional, _that.getAllocatedNotional())) return false;
			if (!Objects.equals(collateral, _that.getCollateral())) return false;
			if (!Objects.equals(creditChargeAmount, _that.getCreditChargeAmount())) return false;
			if (!Objects.equals(approvals, _that.getApprovals())) return false;
			if (!Objects.equals(masterConfirmationDate, _that.getMasterConfirmationDate())) return false;
			if (!ListEquals.listEquals(relatedParty, _that.getRelatedParty())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (allocationTradeId != null ? allocationTradeId.hashCode() : 0);
			_result = 31 * _result + (partyReference != null ? partyReference.hashCode() : 0);
			_result = 31 * _result + (accountReference != null ? accountReference.hashCode() : 0);
			_result = 31 * _result + (allocatedFraction != null ? allocatedFraction.hashCode() : 0);
			_result = 31 * _result + (allocatedNotional != null ? allocatedNotional.hashCode() : 0);
			_result = 31 * _result + (collateral != null ? collateral.hashCode() : 0);
			_result = 31 * _result + (creditChargeAmount != null ? creditChargeAmount.hashCode() : 0);
			_result = 31 * _result + (approvals != null ? approvals.hashCode() : 0);
			_result = 31 * _result + (masterConfirmationDate != null ? masterConfirmationDate.hashCode() : 0);
			_result = 31 * _result + (relatedParty != null ? relatedParty.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AllocationBuilder {" +
				"allocationTradeId=" + this.allocationTradeId + ", " +
				"partyReference=" + this.partyReference + ", " +
				"accountReference=" + this.accountReference + ", " +
				"allocatedFraction=" + this.allocatedFraction + ", " +
				"allocatedNotional=" + this.allocatedNotional + ", " +
				"collateral=" + this.collateral + ", " +
				"creditChargeAmount=" + this.creditChargeAmount + ", " +
				"approvals=" + this.approvals + ", " +
				"masterConfirmationDate=" + this.masterConfirmationDate + ", " +
				"relatedParty=" + this.relatedParty +
			'}';
		}
	}
}

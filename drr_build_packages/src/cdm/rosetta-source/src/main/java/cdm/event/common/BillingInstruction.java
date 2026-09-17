package cdm.event.common;

import cdm.base.staticdata.party.Party;
import cdm.event.common.meta.BillingInstructionMeta;
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
import com.rosetta.model.lib.records.Date;
import com.rosetta.util.ListEquals;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * Specifies the instructions for creation of a Security Lending billing invoice.
 * @version 6.23.0
 */
@RosettaDataType(value="BillingInstruction", builder=BillingInstruction.BillingInstructionBuilderImpl.class, version="6.23.0")
@RuneDataType(value="BillingInstruction", model="cdm", builder=BillingInstruction.BillingInstructionBuilderImpl.class, version="6.23.0")
public interface BillingInstruction extends RosettaModelObject {

	BillingInstructionMeta metaData = new BillingInstructionMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * The party issuing the invoice
	 */
	Party getSendingParty();
	/**
	 * The party receiving the invoice
	 */
	Party getReceivingParty();
	/**
	 * The starting date of the period described by this invoice
	 */
	Date getBillingStartDate();
	/**
	 * The ending date of the period described by this invoice
	 */
	Date getBillingEndDate();
	/**
	 * Instructions for creating the billing records contained within the invoice
	 */
	List<? extends BillingRecordInstruction> getBillingRecordInstruction();
	/**
	 * The billing summaries contained within the invoice
	 */
	List<? extends BillingSummaryInstruction> getBillingSummary();

	/*********************** Build Methods  ***********************/
	BillingInstruction build();
	
	BillingInstruction.BillingInstructionBuilder toBuilder();
	
	static BillingInstruction.BillingInstructionBuilder builder() {
		return new BillingInstruction.BillingInstructionBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends BillingInstruction> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends BillingInstruction> getType() {
		return BillingInstruction.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("sendingParty"), processor, Party.class, getSendingParty());
		processRosetta(path.newSubPath("receivingParty"), processor, Party.class, getReceivingParty());
		processor.processBasic(path.newSubPath("billingStartDate"), Date.class, getBillingStartDate(), this);
		processor.processBasic(path.newSubPath("billingEndDate"), Date.class, getBillingEndDate(), this);
		processRosetta(path.newSubPath("billingRecordInstruction"), processor, BillingRecordInstruction.class, getBillingRecordInstruction());
		processRosetta(path.newSubPath("billingSummary"), processor, BillingSummaryInstruction.class, getBillingSummary());
	}
	

	/*********************** Builder Interface  ***********************/
	interface BillingInstructionBuilder extends BillingInstruction, RosettaModelObjectBuilder {
		Party.PartyBuilder getOrCreateSendingParty();
		@Override
		Party.PartyBuilder getSendingParty();
		Party.PartyBuilder getOrCreateReceivingParty();
		@Override
		Party.PartyBuilder getReceivingParty();
		BillingRecordInstruction.BillingRecordInstructionBuilder getOrCreateBillingRecordInstruction(int index);
		@Override
		List<? extends BillingRecordInstruction.BillingRecordInstructionBuilder> getBillingRecordInstruction();
		BillingSummaryInstruction.BillingSummaryInstructionBuilder getOrCreateBillingSummary(int index);
		@Override
		List<? extends BillingSummaryInstruction.BillingSummaryInstructionBuilder> getBillingSummary();
		BillingInstruction.BillingInstructionBuilder setSendingParty(Party sendingParty);
		BillingInstruction.BillingInstructionBuilder setReceivingParty(Party receivingParty);
		BillingInstruction.BillingInstructionBuilder setBillingStartDate(Date billingStartDate);
		BillingInstruction.BillingInstructionBuilder setBillingEndDate(Date billingEndDate);
		BillingInstruction.BillingInstructionBuilder addBillingRecordInstruction(BillingRecordInstruction billingRecordInstruction);
		BillingInstruction.BillingInstructionBuilder addBillingRecordInstruction(BillingRecordInstruction billingRecordInstruction, int idx);
		BillingInstruction.BillingInstructionBuilder addBillingRecordInstruction(List<? extends BillingRecordInstruction> billingRecordInstruction);
		BillingInstruction.BillingInstructionBuilder setBillingRecordInstruction(List<? extends BillingRecordInstruction> billingRecordInstruction);
		BillingInstruction.BillingInstructionBuilder addBillingSummary(BillingSummaryInstruction billingSummary);
		BillingInstruction.BillingInstructionBuilder addBillingSummary(BillingSummaryInstruction billingSummary, int idx);
		BillingInstruction.BillingInstructionBuilder addBillingSummary(List<? extends BillingSummaryInstruction> billingSummary);
		BillingInstruction.BillingInstructionBuilder setBillingSummary(List<? extends BillingSummaryInstruction> billingSummary);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("sendingParty"), processor, Party.PartyBuilder.class, getSendingParty());
			processRosetta(path.newSubPath("receivingParty"), processor, Party.PartyBuilder.class, getReceivingParty());
			processor.processBasic(path.newSubPath("billingStartDate"), Date.class, getBillingStartDate(), this);
			processor.processBasic(path.newSubPath("billingEndDate"), Date.class, getBillingEndDate(), this);
			processRosetta(path.newSubPath("billingRecordInstruction"), processor, BillingRecordInstruction.BillingRecordInstructionBuilder.class, getBillingRecordInstruction());
			processRosetta(path.newSubPath("billingSummary"), processor, BillingSummaryInstruction.BillingSummaryInstructionBuilder.class, getBillingSummary());
		}
		

		BillingInstruction.BillingInstructionBuilder prune();
	}

	/*********************** Immutable Implementation of BillingInstruction  ***********************/
	class BillingInstructionImpl implements BillingInstruction {
		private final Party sendingParty;
		private final Party receivingParty;
		private final Date billingStartDate;
		private final Date billingEndDate;
		private final List<? extends BillingRecordInstruction> billingRecordInstruction;
		private final List<? extends BillingSummaryInstruction> billingSummary;
		
		protected BillingInstructionImpl(BillingInstruction.BillingInstructionBuilder builder) {
			this.sendingParty = ofNullable(builder.getSendingParty()).map(f->f.build()).orElse(null);
			this.receivingParty = ofNullable(builder.getReceivingParty()).map(f->f.build()).orElse(null);
			this.billingStartDate = builder.getBillingStartDate();
			this.billingEndDate = builder.getBillingEndDate();
			this.billingRecordInstruction = ofNullable(builder.getBillingRecordInstruction()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.billingSummary = ofNullable(builder.getBillingSummary()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		@RosettaAttribute("sendingParty")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("sendingParty")
		public Party getSendingParty() {
			return sendingParty;
		}
		
		@Override
		@RosettaAttribute("receivingParty")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("receivingParty")
		public Party getReceivingParty() {
			return receivingParty;
		}
		
		@Override
		@RosettaAttribute("billingStartDate")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("billingStartDate")
		public Date getBillingStartDate() {
			return billingStartDate;
		}
		
		@Override
		@RosettaAttribute("billingEndDate")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("billingEndDate")
		public Date getBillingEndDate() {
			return billingEndDate;
		}
		
		@Override
		@RosettaAttribute("billingRecordInstruction")
		@Accessor(AccessorType.GETTER)
		@Required
		@Multi
		@RuneAttribute("billingRecordInstruction")
		public List<? extends BillingRecordInstruction> getBillingRecordInstruction() {
			return billingRecordInstruction;
		}
		
		@Override
		@RosettaAttribute("billingSummary")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("billingSummary")
		public List<? extends BillingSummaryInstruction> getBillingSummary() {
			return billingSummary;
		}
		
		@Override
		public BillingInstruction build() {
			return this;
		}
		
		@Override
		public BillingInstruction.BillingInstructionBuilder toBuilder() {
			BillingInstruction.BillingInstructionBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(BillingInstruction.BillingInstructionBuilder builder) {
			ofNullable(getSendingParty()).ifPresent(builder::setSendingParty);
			ofNullable(getReceivingParty()).ifPresent(builder::setReceivingParty);
			ofNullable(getBillingStartDate()).ifPresent(builder::setBillingStartDate);
			ofNullable(getBillingEndDate()).ifPresent(builder::setBillingEndDate);
			ofNullable(getBillingRecordInstruction()).ifPresent(builder::setBillingRecordInstruction);
			ofNullable(getBillingSummary()).ifPresent(builder::setBillingSummary);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			BillingInstruction _that = getType().cast(o);
		
			if (!Objects.equals(sendingParty, _that.getSendingParty())) return false;
			if (!Objects.equals(receivingParty, _that.getReceivingParty())) return false;
			if (!Objects.equals(billingStartDate, _that.getBillingStartDate())) return false;
			if (!Objects.equals(billingEndDate, _that.getBillingEndDate())) return false;
			if (!ListEquals.listEquals(billingRecordInstruction, _that.getBillingRecordInstruction())) return false;
			if (!ListEquals.listEquals(billingSummary, _that.getBillingSummary())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (sendingParty != null ? sendingParty.hashCode() : 0);
			_result = 31 * _result + (receivingParty != null ? receivingParty.hashCode() : 0);
			_result = 31 * _result + (billingStartDate != null ? billingStartDate.hashCode() : 0);
			_result = 31 * _result + (billingEndDate != null ? billingEndDate.hashCode() : 0);
			_result = 31 * _result + (billingRecordInstruction != null ? billingRecordInstruction.hashCode() : 0);
			_result = 31 * _result + (billingSummary != null ? billingSummary.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "BillingInstruction {" +
				"sendingParty=" + this.sendingParty + ", " +
				"receivingParty=" + this.receivingParty + ", " +
				"billingStartDate=" + this.billingStartDate + ", " +
				"billingEndDate=" + this.billingEndDate + ", " +
				"billingRecordInstruction=" + this.billingRecordInstruction + ", " +
				"billingSummary=" + this.billingSummary +
			'}';
		}
	}

	/*********************** Builder Implementation of BillingInstruction  ***********************/
	class BillingInstructionBuilderImpl implements BillingInstruction.BillingInstructionBuilder {
	
		protected Party.PartyBuilder sendingParty;
		protected Party.PartyBuilder receivingParty;
		protected Date billingStartDate;
		protected Date billingEndDate;
		protected List<BillingRecordInstruction.BillingRecordInstructionBuilder> billingRecordInstruction = new ArrayList<>();
		protected List<BillingSummaryInstruction.BillingSummaryInstructionBuilder> billingSummary = new ArrayList<>();
		
		@Override
		@RosettaAttribute("sendingParty")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("sendingParty")
		public Party.PartyBuilder getSendingParty() {
			return sendingParty;
		}
		
		@Override
		public Party.PartyBuilder getOrCreateSendingParty() {
			Party.PartyBuilder result;
			if (sendingParty!=null) {
				result = sendingParty;
			}
			else {
				result = sendingParty = Party.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("receivingParty")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("receivingParty")
		public Party.PartyBuilder getReceivingParty() {
			return receivingParty;
		}
		
		@Override
		public Party.PartyBuilder getOrCreateReceivingParty() {
			Party.PartyBuilder result;
			if (receivingParty!=null) {
				result = receivingParty;
			}
			else {
				result = receivingParty = Party.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("billingStartDate")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("billingStartDate")
		public Date getBillingStartDate() {
			return billingStartDate;
		}
		
		@Override
		@RosettaAttribute("billingEndDate")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("billingEndDate")
		public Date getBillingEndDate() {
			return billingEndDate;
		}
		
		@Override
		@RosettaAttribute("billingRecordInstruction")
		@Accessor(AccessorType.GETTER)
		@Required
		@Multi
		@RuneAttribute("billingRecordInstruction")
		public List<? extends BillingRecordInstruction.BillingRecordInstructionBuilder> getBillingRecordInstruction() {
			return billingRecordInstruction;
		}
		
		@Override
		public BillingRecordInstruction.BillingRecordInstructionBuilder getOrCreateBillingRecordInstruction(int index) {
			if (billingRecordInstruction==null) {
				this.billingRecordInstruction = new ArrayList<>();
			}
			return getIndex(billingRecordInstruction, index, () -> {
						BillingRecordInstruction.BillingRecordInstructionBuilder newBillingRecordInstruction = BillingRecordInstruction.builder();
						return newBillingRecordInstruction;
					});
		}
		
		@Override
		@RosettaAttribute("billingSummary")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("billingSummary")
		public List<? extends BillingSummaryInstruction.BillingSummaryInstructionBuilder> getBillingSummary() {
			return billingSummary;
		}
		
		@Override
		public BillingSummaryInstruction.BillingSummaryInstructionBuilder getOrCreateBillingSummary(int index) {
			if (billingSummary==null) {
				this.billingSummary = new ArrayList<>();
			}
			return getIndex(billingSummary, index, () -> {
						BillingSummaryInstruction.BillingSummaryInstructionBuilder newBillingSummary = BillingSummaryInstruction.builder();
						return newBillingSummary;
					});
		}
		
		@RosettaAttribute("sendingParty")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("sendingParty")
		@Override
		public BillingInstruction.BillingInstructionBuilder setSendingParty(Party _sendingParty) {
			this.sendingParty = _sendingParty == null ? null : _sendingParty.toBuilder();
			return this;
		}
		
		@RosettaAttribute("receivingParty")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("receivingParty")
		@Override
		public BillingInstruction.BillingInstructionBuilder setReceivingParty(Party _receivingParty) {
			this.receivingParty = _receivingParty == null ? null : _receivingParty.toBuilder();
			return this;
		}
		
		@RosettaAttribute("billingStartDate")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("billingStartDate")
		@Override
		public BillingInstruction.BillingInstructionBuilder setBillingStartDate(Date _billingStartDate) {
			this.billingStartDate = _billingStartDate == null ? null : _billingStartDate;
			return this;
		}
		
		@RosettaAttribute("billingEndDate")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("billingEndDate")
		@Override
		public BillingInstruction.BillingInstructionBuilder setBillingEndDate(Date _billingEndDate) {
			this.billingEndDate = _billingEndDate == null ? null : _billingEndDate;
			return this;
		}
		
		@RosettaAttribute("billingRecordInstruction")
		@Accessor(AccessorType.ADDER)
		@Required
		@Multi
		@RuneAttribute("billingRecordInstruction")
		@Override
		public BillingInstruction.BillingInstructionBuilder addBillingRecordInstruction(BillingRecordInstruction _billingRecordInstruction) {
			if (_billingRecordInstruction != null) {
				this.billingRecordInstruction.add(_billingRecordInstruction.toBuilder());
			}
			return this;
		}
		
		@Override
		public BillingInstruction.BillingInstructionBuilder addBillingRecordInstruction(BillingRecordInstruction _billingRecordInstruction, int idx) {
			getIndex(this.billingRecordInstruction, idx, () -> _billingRecordInstruction.toBuilder());
			return this;
		}
		
		@Override
		public BillingInstruction.BillingInstructionBuilder addBillingRecordInstruction(List<? extends BillingRecordInstruction> billingRecordInstructions) {
			if (billingRecordInstructions != null) {
				for (final BillingRecordInstruction toAdd : billingRecordInstructions) {
					this.billingRecordInstruction.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("billingRecordInstruction")
		@Accessor(AccessorType.SETTER)
		@Required
		@Multi
		@RuneAttribute("billingRecordInstruction")
		@Override
		public BillingInstruction.BillingInstructionBuilder setBillingRecordInstruction(List<? extends BillingRecordInstruction> billingRecordInstructions) {
			if (billingRecordInstructions == null) {
				this.billingRecordInstruction = new ArrayList<>();
			} else {
				this.billingRecordInstruction = billingRecordInstructions.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("billingSummary")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("billingSummary")
		@Override
		public BillingInstruction.BillingInstructionBuilder addBillingSummary(BillingSummaryInstruction _billingSummary) {
			if (_billingSummary != null) {
				this.billingSummary.add(_billingSummary.toBuilder());
			}
			return this;
		}
		
		@Override
		public BillingInstruction.BillingInstructionBuilder addBillingSummary(BillingSummaryInstruction _billingSummary, int idx) {
			getIndex(this.billingSummary, idx, () -> _billingSummary.toBuilder());
			return this;
		}
		
		@Override
		public BillingInstruction.BillingInstructionBuilder addBillingSummary(List<? extends BillingSummaryInstruction> billingSummarys) {
			if (billingSummarys != null) {
				for (final BillingSummaryInstruction toAdd : billingSummarys) {
					this.billingSummary.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("billingSummary")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("billingSummary")
		@Override
		public BillingInstruction.BillingInstructionBuilder setBillingSummary(List<? extends BillingSummaryInstruction> billingSummarys) {
			if (billingSummarys == null) {
				this.billingSummary = new ArrayList<>();
			} else {
				this.billingSummary = billingSummarys.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		public BillingInstruction build() {
			return new BillingInstruction.BillingInstructionImpl(this);
		}
		
		@Override
		public BillingInstruction.BillingInstructionBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public BillingInstruction.BillingInstructionBuilder prune() {
			if (sendingParty!=null && !sendingParty.prune().hasData()) sendingParty = null;
			if (receivingParty!=null && !receivingParty.prune().hasData()) receivingParty = null;
			billingRecordInstruction = billingRecordInstruction.stream().filter(b->b!=null).<BillingRecordInstruction.BillingRecordInstructionBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			billingSummary = billingSummary.stream().filter(b->b!=null).<BillingSummaryInstruction.BillingSummaryInstructionBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getSendingParty()!=null && getSendingParty().hasData()) return true;
			if (getReceivingParty()!=null && getReceivingParty().hasData()) return true;
			if (getBillingStartDate()!=null) return true;
			if (getBillingEndDate()!=null) return true;
			if (getBillingRecordInstruction()!=null && getBillingRecordInstruction().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getBillingSummary()!=null && getBillingSummary().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public BillingInstruction.BillingInstructionBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			BillingInstruction.BillingInstructionBuilder o = (BillingInstruction.BillingInstructionBuilder) other;
			
			merger.mergeRosetta(getSendingParty(), o.getSendingParty(), this::setSendingParty);
			merger.mergeRosetta(getReceivingParty(), o.getReceivingParty(), this::setReceivingParty);
			merger.mergeRosetta(getBillingRecordInstruction(), o.getBillingRecordInstruction(), this::getOrCreateBillingRecordInstruction);
			merger.mergeRosetta(getBillingSummary(), o.getBillingSummary(), this::getOrCreateBillingSummary);
			
			merger.mergeBasic(getBillingStartDate(), o.getBillingStartDate(), this::setBillingStartDate);
			merger.mergeBasic(getBillingEndDate(), o.getBillingEndDate(), this::setBillingEndDate);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			BillingInstruction _that = getType().cast(o);
		
			if (!Objects.equals(sendingParty, _that.getSendingParty())) return false;
			if (!Objects.equals(receivingParty, _that.getReceivingParty())) return false;
			if (!Objects.equals(billingStartDate, _that.getBillingStartDate())) return false;
			if (!Objects.equals(billingEndDate, _that.getBillingEndDate())) return false;
			if (!ListEquals.listEquals(billingRecordInstruction, _that.getBillingRecordInstruction())) return false;
			if (!ListEquals.listEquals(billingSummary, _that.getBillingSummary())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (sendingParty != null ? sendingParty.hashCode() : 0);
			_result = 31 * _result + (receivingParty != null ? receivingParty.hashCode() : 0);
			_result = 31 * _result + (billingStartDate != null ? billingStartDate.hashCode() : 0);
			_result = 31 * _result + (billingEndDate != null ? billingEndDate.hashCode() : 0);
			_result = 31 * _result + (billingRecordInstruction != null ? billingRecordInstruction.hashCode() : 0);
			_result = 31 * _result + (billingSummary != null ? billingSummary.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "BillingInstructionBuilder {" +
				"sendingParty=" + this.sendingParty + ", " +
				"receivingParty=" + this.receivingParty + ", " +
				"billingStartDate=" + this.billingStartDate + ", " +
				"billingEndDate=" + this.billingEndDate + ", " +
				"billingRecordInstruction=" + this.billingRecordInstruction + ", " +
				"billingSummary=" + this.billingSummary +
			'}';
		}
	}
}

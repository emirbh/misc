package fpml.consolidated.loan;

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
import fpml.consolidated.loan.meta.LoanAllocationPaymentMeta;
import fpml.consolidated.shared.AdjustableDate;
import fpml.consolidated.shared.NonNegativeMoney;
import fpml.consolidated.shared.PartyReference;
import fpml.consolidated.shared.SettlementInstruction;
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
 * version "confirmation-5.13"
 *
 * Provision A structure that represents a payment related to a loan allocation level of a trade.
 *
 */
@RosettaDataType(value="LoanAllocationPayment", builder=LoanAllocationPayment.LoanAllocationPaymentBuilderImpl.class, version="2.1.1")
@RuneDataType(value="LoanAllocationPayment", model="fpml", builder=LoanAllocationPayment.LoanAllocationPaymentBuilderImpl.class, version="2.1.1")
public interface LoanAllocationPayment extends LoanSimplePayment {

	LoanAllocationPaymentMeta metaData = new LoanAllocationPaymentMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Reference to the loan trade allocation.
	 *
	 */
	List<? extends LoanAllocationReference> getAllocationReference();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision This structure can be utilized as an override to previously-communicated settlement instructions (via the LoanPartyProfileNotification).
	 *
	 */
	SettlementInstruction getReceiverSettlementInstruction();

	/*********************** Build Methods  ***********************/
	LoanAllocationPayment build();
	
	LoanAllocationPayment.LoanAllocationPaymentBuilder toBuilder();
	
	static LoanAllocationPayment.LoanAllocationPaymentBuilder builder() {
		return new LoanAllocationPayment.LoanAllocationPaymentBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends LoanAllocationPayment> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends LoanAllocationPayment> getType() {
		return LoanAllocationPayment.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		processRosetta(path.newSubPath("payerPartyReference"), processor, PartyReference.class, getPayerPartyReference());
		processRosetta(path.newSubPath("receiverPartyReference"), processor, PartyReference.class, getReceiverPartyReference());
		processRosetta(path.newSubPath("paymentAmount"), processor, NonNegativeMoney.class, getPaymentAmount());
		processRosetta(path.newSubPath("paymentDate"), processor, AdjustableDate.class, getPaymentDate());
		processRosetta(path.newSubPath("allocationReference"), processor, LoanAllocationReference.class, getAllocationReference());
		processRosetta(path.newSubPath("receiverSettlementInstruction"), processor, SettlementInstruction.class, getReceiverSettlementInstruction());
	}
	

	/*********************** Builder Interface  ***********************/
	interface LoanAllocationPaymentBuilder extends LoanAllocationPayment, LoanSimplePayment.LoanSimplePaymentBuilder {
		LoanAllocationReference.LoanAllocationReferenceBuilder getOrCreateAllocationReference(int index);
		@Override
		List<? extends LoanAllocationReference.LoanAllocationReferenceBuilder> getAllocationReference();
		SettlementInstruction.SettlementInstructionBuilder getOrCreateReceiverSettlementInstruction();
		@Override
		SettlementInstruction.SettlementInstructionBuilder getReceiverSettlementInstruction();
		@Override
		LoanAllocationPayment.LoanAllocationPaymentBuilder setId(String id);
		@Override
		LoanAllocationPayment.LoanAllocationPaymentBuilder setPayerPartyReference(PartyReference payerPartyReference);
		@Override
		LoanAllocationPayment.LoanAllocationPaymentBuilder setReceiverPartyReference(PartyReference receiverPartyReference);
		@Override
		LoanAllocationPayment.LoanAllocationPaymentBuilder setPaymentAmount(NonNegativeMoney paymentAmount);
		@Override
		LoanAllocationPayment.LoanAllocationPaymentBuilder setPaymentDate(AdjustableDate paymentDate);
		LoanAllocationPayment.LoanAllocationPaymentBuilder addAllocationReference(LoanAllocationReference allocationReference);
		LoanAllocationPayment.LoanAllocationPaymentBuilder addAllocationReference(LoanAllocationReference allocationReference, int idx);
		LoanAllocationPayment.LoanAllocationPaymentBuilder addAllocationReference(List<? extends LoanAllocationReference> allocationReference);
		LoanAllocationPayment.LoanAllocationPaymentBuilder setAllocationReference(List<? extends LoanAllocationReference> allocationReference);
		LoanAllocationPayment.LoanAllocationPaymentBuilder setReceiverSettlementInstruction(SettlementInstruction receiverSettlementInstruction);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
			processRosetta(path.newSubPath("payerPartyReference"), processor, PartyReference.PartyReferenceBuilder.class, getPayerPartyReference());
			processRosetta(path.newSubPath("receiverPartyReference"), processor, PartyReference.PartyReferenceBuilder.class, getReceiverPartyReference());
			processRosetta(path.newSubPath("paymentAmount"), processor, NonNegativeMoney.NonNegativeMoneyBuilder.class, getPaymentAmount());
			processRosetta(path.newSubPath("paymentDate"), processor, AdjustableDate.AdjustableDateBuilder.class, getPaymentDate());
			processRosetta(path.newSubPath("allocationReference"), processor, LoanAllocationReference.LoanAllocationReferenceBuilder.class, getAllocationReference());
			processRosetta(path.newSubPath("receiverSettlementInstruction"), processor, SettlementInstruction.SettlementInstructionBuilder.class, getReceiverSettlementInstruction());
		}
		

		LoanAllocationPayment.LoanAllocationPaymentBuilder prune();
	}

	/*********************** Immutable Implementation of LoanAllocationPayment  ***********************/
	class LoanAllocationPaymentImpl extends LoanSimplePayment.LoanSimplePaymentImpl implements LoanAllocationPayment {
		private final List<? extends LoanAllocationReference> allocationReference;
		private final SettlementInstruction receiverSettlementInstruction;
		
		protected LoanAllocationPaymentImpl(LoanAllocationPayment.LoanAllocationPaymentBuilder builder) {
			super(builder);
			this.allocationReference = ofNullable(builder.getAllocationReference()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.receiverSettlementInstruction = ofNullable(builder.getReceiverSettlementInstruction()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("allocationReference")
		@Accessor(AccessorType.GETTER)
		@Required
		@Multi
		@RuneAttribute("allocationReference")
		public List<? extends LoanAllocationReference> getAllocationReference() {
			return allocationReference;
		}
		
		@Override
		@RosettaAttribute("receiverSettlementInstruction")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("receiverSettlementInstruction")
		public SettlementInstruction getReceiverSettlementInstruction() {
			return receiverSettlementInstruction;
		}
		
		@Override
		public LoanAllocationPayment build() {
			return this;
		}
		
		@Override
		public LoanAllocationPayment.LoanAllocationPaymentBuilder toBuilder() {
			LoanAllocationPayment.LoanAllocationPaymentBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(LoanAllocationPayment.LoanAllocationPaymentBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getAllocationReference()).ifPresent(builder::setAllocationReference);
			ofNullable(getReceiverSettlementInstruction()).ifPresent(builder::setReceiverSettlementInstruction);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			LoanAllocationPayment _that = getType().cast(o);
		
			if (!ListEquals.listEquals(allocationReference, _that.getAllocationReference())) return false;
			if (!Objects.equals(receiverSettlementInstruction, _that.getReceiverSettlementInstruction())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (allocationReference != null ? allocationReference.hashCode() : 0);
			_result = 31 * _result + (receiverSettlementInstruction != null ? receiverSettlementInstruction.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "LoanAllocationPayment {" +
				"allocationReference=" + this.allocationReference + ", " +
				"receiverSettlementInstruction=" + this.receiverSettlementInstruction +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of LoanAllocationPayment  ***********************/
	class LoanAllocationPaymentBuilderImpl extends LoanSimplePayment.LoanSimplePaymentBuilderImpl implements LoanAllocationPayment.LoanAllocationPaymentBuilder {
	
		protected List<LoanAllocationReference.LoanAllocationReferenceBuilder> allocationReference = new ArrayList<>();
		protected SettlementInstruction.SettlementInstructionBuilder receiverSettlementInstruction;
		
		@Override
		@RosettaAttribute("allocationReference")
		@Accessor(AccessorType.GETTER)
		@Required
		@Multi
		@RuneAttribute("allocationReference")
		public List<? extends LoanAllocationReference.LoanAllocationReferenceBuilder> getAllocationReference() {
			return allocationReference;
		}
		
		@Override
		public LoanAllocationReference.LoanAllocationReferenceBuilder getOrCreateAllocationReference(int index) {
			if (allocationReference==null) {
				this.allocationReference = new ArrayList<>();
			}
			return getIndex(allocationReference, index, () -> {
						LoanAllocationReference.LoanAllocationReferenceBuilder newAllocationReference = LoanAllocationReference.builder();
						return newAllocationReference;
					});
		}
		
		@Override
		@RosettaAttribute("receiverSettlementInstruction")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("receiverSettlementInstruction")
		public SettlementInstruction.SettlementInstructionBuilder getReceiverSettlementInstruction() {
			return receiverSettlementInstruction;
		}
		
		@Override
		public SettlementInstruction.SettlementInstructionBuilder getOrCreateReceiverSettlementInstruction() {
			SettlementInstruction.SettlementInstructionBuilder result;
			if (receiverSettlementInstruction!=null) {
				result = receiverSettlementInstruction;
			}
			else {
				result = receiverSettlementInstruction = SettlementInstruction.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("id")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("id")
		@Override
		public LoanAllocationPayment.LoanAllocationPaymentBuilder setId(String _id) {
			this.id = _id == null ? null : _id;
			return this;
		}
		
		@RosettaAttribute("payerPartyReference")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("payerPartyReference")
		@Override
		public LoanAllocationPayment.LoanAllocationPaymentBuilder setPayerPartyReference(PartyReference _payerPartyReference) {
			this.payerPartyReference = _payerPartyReference == null ? null : _payerPartyReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("receiverPartyReference")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("receiverPartyReference")
		@Override
		public LoanAllocationPayment.LoanAllocationPaymentBuilder setReceiverPartyReference(PartyReference _receiverPartyReference) {
			this.receiverPartyReference = _receiverPartyReference == null ? null : _receiverPartyReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("paymentAmount")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("paymentAmount")
		@Override
		public LoanAllocationPayment.LoanAllocationPaymentBuilder setPaymentAmount(NonNegativeMoney _paymentAmount) {
			this.paymentAmount = _paymentAmount == null ? null : _paymentAmount.toBuilder();
			return this;
		}
		
		@RosettaAttribute("paymentDate")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("paymentDate")
		@Override
		public LoanAllocationPayment.LoanAllocationPaymentBuilder setPaymentDate(AdjustableDate _paymentDate) {
			this.paymentDate = _paymentDate == null ? null : _paymentDate.toBuilder();
			return this;
		}
		
		@RosettaAttribute("allocationReference")
		@Accessor(AccessorType.ADDER)
		@Required
		@Multi
		@RuneAttribute("allocationReference")
		@Override
		public LoanAllocationPayment.LoanAllocationPaymentBuilder addAllocationReference(LoanAllocationReference _allocationReference) {
			if (_allocationReference != null) {
				this.allocationReference.add(_allocationReference.toBuilder());
			}
			return this;
		}
		
		@Override
		public LoanAllocationPayment.LoanAllocationPaymentBuilder addAllocationReference(LoanAllocationReference _allocationReference, int idx) {
			getIndex(this.allocationReference, idx, () -> _allocationReference.toBuilder());
			return this;
		}
		
		@Override
		public LoanAllocationPayment.LoanAllocationPaymentBuilder addAllocationReference(List<? extends LoanAllocationReference> allocationReferences) {
			if (allocationReferences != null) {
				for (final LoanAllocationReference toAdd : allocationReferences) {
					this.allocationReference.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("allocationReference")
		@Accessor(AccessorType.SETTER)
		@Required
		@Multi
		@RuneAttribute("allocationReference")
		@Override
		public LoanAllocationPayment.LoanAllocationPaymentBuilder setAllocationReference(List<? extends LoanAllocationReference> allocationReferences) {
			if (allocationReferences == null) {
				this.allocationReference = new ArrayList<>();
			} else {
				this.allocationReference = allocationReferences.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("receiverSettlementInstruction")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("receiverSettlementInstruction")
		@Override
		public LoanAllocationPayment.LoanAllocationPaymentBuilder setReceiverSettlementInstruction(SettlementInstruction _receiverSettlementInstruction) {
			this.receiverSettlementInstruction = _receiverSettlementInstruction == null ? null : _receiverSettlementInstruction.toBuilder();
			return this;
		}
		
		@Override
		public LoanAllocationPayment build() {
			return new LoanAllocationPayment.LoanAllocationPaymentImpl(this);
		}
		
		@Override
		public LoanAllocationPayment.LoanAllocationPaymentBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public LoanAllocationPayment.LoanAllocationPaymentBuilder prune() {
			super.prune();
			allocationReference = allocationReference.stream().filter(b->b!=null).<LoanAllocationReference.LoanAllocationReferenceBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			if (receiverSettlementInstruction!=null && !receiverSettlementInstruction.prune().hasData()) receiverSettlementInstruction = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getAllocationReference()!=null && getAllocationReference().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getReceiverSettlementInstruction()!=null && getReceiverSettlementInstruction().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public LoanAllocationPayment.LoanAllocationPaymentBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			LoanAllocationPayment.LoanAllocationPaymentBuilder o = (LoanAllocationPayment.LoanAllocationPaymentBuilder) other;
			
			merger.mergeRosetta(getAllocationReference(), o.getAllocationReference(), this::getOrCreateAllocationReference);
			merger.mergeRosetta(getReceiverSettlementInstruction(), o.getReceiverSettlementInstruction(), this::setReceiverSettlementInstruction);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			LoanAllocationPayment _that = getType().cast(o);
		
			if (!ListEquals.listEquals(allocationReference, _that.getAllocationReference())) return false;
			if (!Objects.equals(receiverSettlementInstruction, _that.getReceiverSettlementInstruction())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (allocationReference != null ? allocationReference.hashCode() : 0);
			_result = 31 * _result + (receiverSettlementInstruction != null ? receiverSettlementInstruction.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "LoanAllocationPaymentBuilder {" +
				"allocationReference=" + this.allocationReference + ", " +
				"receiverSettlementInstruction=" + this.receiverSettlementInstruction +
			'}' + " " + super.toString();
		}
	}
}

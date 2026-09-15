package fpml.consolidated.loan;

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
import fpml.consolidated.doc.TradeIdentifierChoice;
import fpml.consolidated.loan.meta.LoanAllocationTypeMeta;
import fpml.consolidated.shared.AccountReference;
import fpml.consolidated.shared.IssuerId;
import fpml.consolidated.shared.NonNegativeMoney;
import fpml.consolidated.shared.PartyReference;
import fpml.consolidated.shared.TradeId;
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
 * Provision A structure that defines party-to-party loan allocation information. This structure contains the allocated party details.
 *
 */
@RosettaDataType(value="LoanAllocationType", builder=LoanAllocationType.LoanAllocationTypeBuilderImpl.class, version="2.1.1")
@RuneDataType(value="LoanAllocationType", model="fpml", builder=LoanAllocationType.LoanAllocationTypeBuilderImpl.class, version="2.1.1")
public interface LoanAllocationType extends LoanAllocationSummary {

	LoanAllocationTypeMeta metaData = new LoanAllocationTypeMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A reference to the party responsible for the allocation.
	 *
	 */
	PartyReference getOriginalPartyReference();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A reference to the party that has been allocated to.
	 *
	 */
	PartyReference getAllocatedPartyReference();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A reference to the party that buys this instrument, ie. pays for this instrument and receives the rights defined by it. See 2000 ISDA definitions Article 11.1 (b). In the case of FRAs this the fixed rate payer.
	 *
	 */
	PartyReference getBuyerPartyReference();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A reference to the party that sells ("writes") this instrument, i.e. that grants the rights defined by this instrument and in return receives a payment for it. See 2000 ISDA definitions Article 11.1 (a). In the case of FRAs this is the floating rate payer.
	 *
	 */
	PartyReference getSellerPartyReference();

	/*********************** Build Methods  ***********************/
	LoanAllocationType build();
	
	LoanAllocationType.LoanAllocationTypeBuilder toBuilder();
	
	static LoanAllocationType.LoanAllocationTypeBuilder builder() {
		return new LoanAllocationType.LoanAllocationTypeBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends LoanAllocationType> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends LoanAllocationType> getType() {
		return LoanAllocationType.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		processRosetta(path.newSubPath("issuer"), processor, IssuerId.class, getIssuer());
		processRosetta(path.newSubPath("tradeId"), processor, TradeId.class, getTradeId());
		processRosetta(path.newSubPath("partyReference"), processor, PartyReference.class, getPartyReference());
		processRosetta(path.newSubPath("accountReference"), processor, AccountReference.class, getAccountReference());
		processRosetta(path.newSubPath("tradeIdentifierChoice"), processor, TradeIdentifierChoice.class, getTradeIdentifierChoice());
		processRosetta(path.newSubPath("loanTradeReference"), processor, LoanTradeReference.class, getLoanTradeReference());
		processRosetta(path.newSubPath("amount"), processor, NonNegativeMoney.class, getAmount());
		processor.processBasic(path.newSubPath("comment"), String.class, getComment(), this);
		processRosetta(path.newSubPath("originalPartyReference"), processor, PartyReference.class, getOriginalPartyReference());
		processRosetta(path.newSubPath("allocatedPartyReference"), processor, PartyReference.class, getAllocatedPartyReference());
		processRosetta(path.newSubPath("buyerPartyReference"), processor, PartyReference.class, getBuyerPartyReference());
		processRosetta(path.newSubPath("sellerPartyReference"), processor, PartyReference.class, getSellerPartyReference());
	}
	

	/*********************** Builder Interface  ***********************/
	interface LoanAllocationTypeBuilder extends LoanAllocationType, LoanAllocationSummary.LoanAllocationSummaryBuilder {
		PartyReference.PartyReferenceBuilder getOrCreateOriginalPartyReference();
		@Override
		PartyReference.PartyReferenceBuilder getOriginalPartyReference();
		PartyReference.PartyReferenceBuilder getOrCreateAllocatedPartyReference();
		@Override
		PartyReference.PartyReferenceBuilder getAllocatedPartyReference();
		PartyReference.PartyReferenceBuilder getOrCreateBuyerPartyReference();
		@Override
		PartyReference.PartyReferenceBuilder getBuyerPartyReference();
		PartyReference.PartyReferenceBuilder getOrCreateSellerPartyReference();
		@Override
		PartyReference.PartyReferenceBuilder getSellerPartyReference();
		@Override
		LoanAllocationType.LoanAllocationTypeBuilder setId(String id);
		@Override
		LoanAllocationType.LoanAllocationTypeBuilder setIssuer(IssuerId issuer);
		@Override
		LoanAllocationType.LoanAllocationTypeBuilder setTradeId(TradeId tradeId);
		@Override
		LoanAllocationType.LoanAllocationTypeBuilder setPartyReference(PartyReference partyReference);
		@Override
		LoanAllocationType.LoanAllocationTypeBuilder setAccountReference(AccountReference accountReference);
		@Override
		LoanAllocationType.LoanAllocationTypeBuilder addTradeIdentifierChoice(TradeIdentifierChoice tradeIdentifierChoice);
		@Override
		LoanAllocationType.LoanAllocationTypeBuilder addTradeIdentifierChoice(TradeIdentifierChoice tradeIdentifierChoice, int idx);
		@Override
		LoanAllocationType.LoanAllocationTypeBuilder addTradeIdentifierChoice(List<? extends TradeIdentifierChoice> tradeIdentifierChoice);
		@Override
		LoanAllocationType.LoanAllocationTypeBuilder setTradeIdentifierChoice(List<? extends TradeIdentifierChoice> tradeIdentifierChoice);
		@Override
		LoanAllocationType.LoanAllocationTypeBuilder setLoanTradeReference(LoanTradeReference loanTradeReference);
		@Override
		LoanAllocationType.LoanAllocationTypeBuilder setAmount(NonNegativeMoney amount);
		@Override
		LoanAllocationType.LoanAllocationTypeBuilder setComment(String comment);
		LoanAllocationType.LoanAllocationTypeBuilder setOriginalPartyReference(PartyReference originalPartyReference);
		LoanAllocationType.LoanAllocationTypeBuilder setAllocatedPartyReference(PartyReference allocatedPartyReference);
		LoanAllocationType.LoanAllocationTypeBuilder setBuyerPartyReference(PartyReference buyerPartyReference);
		LoanAllocationType.LoanAllocationTypeBuilder setSellerPartyReference(PartyReference sellerPartyReference);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
			processRosetta(path.newSubPath("issuer"), processor, IssuerId.IssuerIdBuilder.class, getIssuer());
			processRosetta(path.newSubPath("tradeId"), processor, TradeId.TradeIdBuilder.class, getTradeId());
			processRosetta(path.newSubPath("partyReference"), processor, PartyReference.PartyReferenceBuilder.class, getPartyReference());
			processRosetta(path.newSubPath("accountReference"), processor, AccountReference.AccountReferenceBuilder.class, getAccountReference());
			processRosetta(path.newSubPath("tradeIdentifierChoice"), processor, TradeIdentifierChoice.TradeIdentifierChoiceBuilder.class, getTradeIdentifierChoice());
			processRosetta(path.newSubPath("loanTradeReference"), processor, LoanTradeReference.LoanTradeReferenceBuilder.class, getLoanTradeReference());
			processRosetta(path.newSubPath("amount"), processor, NonNegativeMoney.NonNegativeMoneyBuilder.class, getAmount());
			processor.processBasic(path.newSubPath("comment"), String.class, getComment(), this);
			processRosetta(path.newSubPath("originalPartyReference"), processor, PartyReference.PartyReferenceBuilder.class, getOriginalPartyReference());
			processRosetta(path.newSubPath("allocatedPartyReference"), processor, PartyReference.PartyReferenceBuilder.class, getAllocatedPartyReference());
			processRosetta(path.newSubPath("buyerPartyReference"), processor, PartyReference.PartyReferenceBuilder.class, getBuyerPartyReference());
			processRosetta(path.newSubPath("sellerPartyReference"), processor, PartyReference.PartyReferenceBuilder.class, getSellerPartyReference());
		}
		

		LoanAllocationType.LoanAllocationTypeBuilder prune();
	}

	/*********************** Immutable Implementation of LoanAllocationType  ***********************/
	class LoanAllocationTypeImpl extends LoanAllocationSummary.LoanAllocationSummaryImpl implements LoanAllocationType {
		private final PartyReference originalPartyReference;
		private final PartyReference allocatedPartyReference;
		private final PartyReference buyerPartyReference;
		private final PartyReference sellerPartyReference;
		
		protected LoanAllocationTypeImpl(LoanAllocationType.LoanAllocationTypeBuilder builder) {
			super(builder);
			this.originalPartyReference = ofNullable(builder.getOriginalPartyReference()).map(f->f.build()).orElse(null);
			this.allocatedPartyReference = ofNullable(builder.getAllocatedPartyReference()).map(f->f.build()).orElse(null);
			this.buyerPartyReference = ofNullable(builder.getBuyerPartyReference()).map(f->f.build()).orElse(null);
			this.sellerPartyReference = ofNullable(builder.getSellerPartyReference()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("originalPartyReference")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("originalPartyReference")
		public PartyReference getOriginalPartyReference() {
			return originalPartyReference;
		}
		
		@Override
		@RosettaAttribute("allocatedPartyReference")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("allocatedPartyReference")
		public PartyReference getAllocatedPartyReference() {
			return allocatedPartyReference;
		}
		
		@Override
		@RosettaAttribute("buyerPartyReference")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("buyerPartyReference")
		public PartyReference getBuyerPartyReference() {
			return buyerPartyReference;
		}
		
		@Override
		@RosettaAttribute("sellerPartyReference")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("sellerPartyReference")
		public PartyReference getSellerPartyReference() {
			return sellerPartyReference;
		}
		
		@Override
		public LoanAllocationType build() {
			return this;
		}
		
		@Override
		public LoanAllocationType.LoanAllocationTypeBuilder toBuilder() {
			LoanAllocationType.LoanAllocationTypeBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(LoanAllocationType.LoanAllocationTypeBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getOriginalPartyReference()).ifPresent(builder::setOriginalPartyReference);
			ofNullable(getAllocatedPartyReference()).ifPresent(builder::setAllocatedPartyReference);
			ofNullable(getBuyerPartyReference()).ifPresent(builder::setBuyerPartyReference);
			ofNullable(getSellerPartyReference()).ifPresent(builder::setSellerPartyReference);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			LoanAllocationType _that = getType().cast(o);
		
			if (!Objects.equals(originalPartyReference, _that.getOriginalPartyReference())) return false;
			if (!Objects.equals(allocatedPartyReference, _that.getAllocatedPartyReference())) return false;
			if (!Objects.equals(buyerPartyReference, _that.getBuyerPartyReference())) return false;
			if (!Objects.equals(sellerPartyReference, _that.getSellerPartyReference())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (originalPartyReference != null ? originalPartyReference.hashCode() : 0);
			_result = 31 * _result + (allocatedPartyReference != null ? allocatedPartyReference.hashCode() : 0);
			_result = 31 * _result + (buyerPartyReference != null ? buyerPartyReference.hashCode() : 0);
			_result = 31 * _result + (sellerPartyReference != null ? sellerPartyReference.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "LoanAllocationType {" +
				"originalPartyReference=" + this.originalPartyReference + ", " +
				"allocatedPartyReference=" + this.allocatedPartyReference + ", " +
				"buyerPartyReference=" + this.buyerPartyReference + ", " +
				"sellerPartyReference=" + this.sellerPartyReference +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of LoanAllocationType  ***********************/
	class LoanAllocationTypeBuilderImpl extends LoanAllocationSummary.LoanAllocationSummaryBuilderImpl implements LoanAllocationType.LoanAllocationTypeBuilder {
	
		protected PartyReference.PartyReferenceBuilder originalPartyReference;
		protected PartyReference.PartyReferenceBuilder allocatedPartyReference;
		protected PartyReference.PartyReferenceBuilder buyerPartyReference;
		protected PartyReference.PartyReferenceBuilder sellerPartyReference;
		
		@Override
		@RosettaAttribute("originalPartyReference")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("originalPartyReference")
		public PartyReference.PartyReferenceBuilder getOriginalPartyReference() {
			return originalPartyReference;
		}
		
		@Override
		public PartyReference.PartyReferenceBuilder getOrCreateOriginalPartyReference() {
			PartyReference.PartyReferenceBuilder result;
			if (originalPartyReference!=null) {
				result = originalPartyReference;
			}
			else {
				result = originalPartyReference = PartyReference.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("allocatedPartyReference")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("allocatedPartyReference")
		public PartyReference.PartyReferenceBuilder getAllocatedPartyReference() {
			return allocatedPartyReference;
		}
		
		@Override
		public PartyReference.PartyReferenceBuilder getOrCreateAllocatedPartyReference() {
			PartyReference.PartyReferenceBuilder result;
			if (allocatedPartyReference!=null) {
				result = allocatedPartyReference;
			}
			else {
				result = allocatedPartyReference = PartyReference.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("buyerPartyReference")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("buyerPartyReference")
		public PartyReference.PartyReferenceBuilder getBuyerPartyReference() {
			return buyerPartyReference;
		}
		
		@Override
		public PartyReference.PartyReferenceBuilder getOrCreateBuyerPartyReference() {
			PartyReference.PartyReferenceBuilder result;
			if (buyerPartyReference!=null) {
				result = buyerPartyReference;
			}
			else {
				result = buyerPartyReference = PartyReference.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("sellerPartyReference")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("sellerPartyReference")
		public PartyReference.PartyReferenceBuilder getSellerPartyReference() {
			return sellerPartyReference;
		}
		
		@Override
		public PartyReference.PartyReferenceBuilder getOrCreateSellerPartyReference() {
			PartyReference.PartyReferenceBuilder result;
			if (sellerPartyReference!=null) {
				result = sellerPartyReference;
			}
			else {
				result = sellerPartyReference = PartyReference.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("id")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("id")
		@Override
		public LoanAllocationType.LoanAllocationTypeBuilder setId(String _id) {
			this.id = _id == null ? null : _id;
			return this;
		}
		
		@RosettaAttribute("issuer")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("issuer")
		@Override
		public LoanAllocationType.LoanAllocationTypeBuilder setIssuer(IssuerId _issuer) {
			this.issuer = _issuer == null ? null : _issuer.toBuilder();
			return this;
		}
		
		@RosettaAttribute("tradeId")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("tradeId")
		@Override
		public LoanAllocationType.LoanAllocationTypeBuilder setTradeId(TradeId _tradeId) {
			this.tradeId = _tradeId == null ? null : _tradeId.toBuilder();
			return this;
		}
		
		@RosettaAttribute("partyReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("partyReference")
		@Override
		public LoanAllocationType.LoanAllocationTypeBuilder setPartyReference(PartyReference _partyReference) {
			this.partyReference = _partyReference == null ? null : _partyReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("accountReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("accountReference")
		@Override
		public LoanAllocationType.LoanAllocationTypeBuilder setAccountReference(AccountReference _accountReference) {
			this.accountReference = _accountReference == null ? null : _accountReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("tradeIdentifierChoice")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("tradeIdentifierChoice")
		@Override
		public LoanAllocationType.LoanAllocationTypeBuilder addTradeIdentifierChoice(TradeIdentifierChoice _tradeIdentifierChoice) {
			if (_tradeIdentifierChoice != null) {
				this.tradeIdentifierChoice.add(_tradeIdentifierChoice.toBuilder());
			}
			return this;
		}
		
		@Override
		public LoanAllocationType.LoanAllocationTypeBuilder addTradeIdentifierChoice(TradeIdentifierChoice _tradeIdentifierChoice, int idx) {
			getIndex(this.tradeIdentifierChoice, idx, () -> _tradeIdentifierChoice.toBuilder());
			return this;
		}
		
		@Override
		public LoanAllocationType.LoanAllocationTypeBuilder addTradeIdentifierChoice(List<? extends TradeIdentifierChoice> tradeIdentifierChoices) {
			if (tradeIdentifierChoices != null) {
				for (final TradeIdentifierChoice toAdd : tradeIdentifierChoices) {
					this.tradeIdentifierChoice.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("tradeIdentifierChoice")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("tradeIdentifierChoice")
		@Override
		public LoanAllocationType.LoanAllocationTypeBuilder setTradeIdentifierChoice(List<? extends TradeIdentifierChoice> tradeIdentifierChoices) {
			if (tradeIdentifierChoices == null) {
				this.tradeIdentifierChoice = new ArrayList<>();
			} else {
				this.tradeIdentifierChoice = tradeIdentifierChoices.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("loanTradeReference")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("loanTradeReference")
		@Override
		public LoanAllocationType.LoanAllocationTypeBuilder setLoanTradeReference(LoanTradeReference _loanTradeReference) {
			this.loanTradeReference = _loanTradeReference == null ? null : _loanTradeReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("amount")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("amount")
		@Override
		public LoanAllocationType.LoanAllocationTypeBuilder setAmount(NonNegativeMoney _amount) {
			this.amount = _amount == null ? null : _amount.toBuilder();
			return this;
		}
		
		@RosettaAttribute("comment")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("comment")
		@Override
		public LoanAllocationType.LoanAllocationTypeBuilder setComment(String _comment) {
			this.comment = _comment == null ? null : _comment;
			return this;
		}
		
		@RosettaAttribute("originalPartyReference")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("originalPartyReference")
		@Override
		public LoanAllocationType.LoanAllocationTypeBuilder setOriginalPartyReference(PartyReference _originalPartyReference) {
			this.originalPartyReference = _originalPartyReference == null ? null : _originalPartyReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("allocatedPartyReference")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("allocatedPartyReference")
		@Override
		public LoanAllocationType.LoanAllocationTypeBuilder setAllocatedPartyReference(PartyReference _allocatedPartyReference) {
			this.allocatedPartyReference = _allocatedPartyReference == null ? null : _allocatedPartyReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("buyerPartyReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("buyerPartyReference")
		@Override
		public LoanAllocationType.LoanAllocationTypeBuilder setBuyerPartyReference(PartyReference _buyerPartyReference) {
			this.buyerPartyReference = _buyerPartyReference == null ? null : _buyerPartyReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("sellerPartyReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("sellerPartyReference")
		@Override
		public LoanAllocationType.LoanAllocationTypeBuilder setSellerPartyReference(PartyReference _sellerPartyReference) {
			this.sellerPartyReference = _sellerPartyReference == null ? null : _sellerPartyReference.toBuilder();
			return this;
		}
		
		@Override
		public LoanAllocationType build() {
			return new LoanAllocationType.LoanAllocationTypeImpl(this);
		}
		
		@Override
		public LoanAllocationType.LoanAllocationTypeBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public LoanAllocationType.LoanAllocationTypeBuilder prune() {
			super.prune();
			if (originalPartyReference!=null && !originalPartyReference.prune().hasData()) originalPartyReference = null;
			if (allocatedPartyReference!=null && !allocatedPartyReference.prune().hasData()) allocatedPartyReference = null;
			if (buyerPartyReference!=null && !buyerPartyReference.prune().hasData()) buyerPartyReference = null;
			if (sellerPartyReference!=null && !sellerPartyReference.prune().hasData()) sellerPartyReference = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getOriginalPartyReference()!=null && getOriginalPartyReference().hasData()) return true;
			if (getAllocatedPartyReference()!=null && getAllocatedPartyReference().hasData()) return true;
			if (getBuyerPartyReference()!=null && getBuyerPartyReference().hasData()) return true;
			if (getSellerPartyReference()!=null && getSellerPartyReference().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public LoanAllocationType.LoanAllocationTypeBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			LoanAllocationType.LoanAllocationTypeBuilder o = (LoanAllocationType.LoanAllocationTypeBuilder) other;
			
			merger.mergeRosetta(getOriginalPartyReference(), o.getOriginalPartyReference(), this::setOriginalPartyReference);
			merger.mergeRosetta(getAllocatedPartyReference(), o.getAllocatedPartyReference(), this::setAllocatedPartyReference);
			merger.mergeRosetta(getBuyerPartyReference(), o.getBuyerPartyReference(), this::setBuyerPartyReference);
			merger.mergeRosetta(getSellerPartyReference(), o.getSellerPartyReference(), this::setSellerPartyReference);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			LoanAllocationType _that = getType().cast(o);
		
			if (!Objects.equals(originalPartyReference, _that.getOriginalPartyReference())) return false;
			if (!Objects.equals(allocatedPartyReference, _that.getAllocatedPartyReference())) return false;
			if (!Objects.equals(buyerPartyReference, _that.getBuyerPartyReference())) return false;
			if (!Objects.equals(sellerPartyReference, _that.getSellerPartyReference())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (originalPartyReference != null ? originalPartyReference.hashCode() : 0);
			_result = 31 * _result + (allocatedPartyReference != null ? allocatedPartyReference.hashCode() : 0);
			_result = 31 * _result + (buyerPartyReference != null ? buyerPartyReference.hashCode() : 0);
			_result = 31 * _result + (sellerPartyReference != null ? sellerPartyReference.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "LoanAllocationTypeBuilder {" +
				"originalPartyReference=" + this.originalPartyReference + ", " +
				"allocatedPartyReference=" + this.allocatedPartyReference + ", " +
				"buyerPartyReference=" + this.buyerPartyReference + ", " +
				"sellerPartyReference=" + this.sellerPartyReference +
			'}' + " " + super.toString();
		}
	}
}

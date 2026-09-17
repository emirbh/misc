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
import fpml.consolidated.loan.meta.CashPayableMeta;
import fpml.consolidated.shared.NonNegativeMoney;
import fpml.consolidated.shared.PartyReference;
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
 * Provision A structure that represents payable cash, together with reference to any withholding tax being applied. This is used as a generic cash flow container across all loan business events (within the event header).
 *
 */
@RosettaDataType(value="CashPayable", builder=CashPayable.CashPayableBuilderImpl.class, version="2.1.1")
@RuneDataType(value="CashPayable", model="fpml", builder=CashPayable.CashPayableBuilderImpl.class, version="2.1.1")
public interface CashPayable extends RosettaModelObject {

	CashPayableMeta metaData = new CashPayableMeta();

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
	PartyReference getPayerPartyReference();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A reference to the party that has been allocated to.
	 *
	 */
	PartyReference getReceiverPartyReference();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The cash amount payable, net of all tax withholding. This amount represents the funds to be wired from 'payer' to 'receiver' as a result of the underlying business event.
	 *
	 */
	NonNegativeMoney getNetAmount();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Details of the tax being withheld.
	 *
	 */
	List<? extends TaxWithholding> getTaxWithholding();

	/*********************** Build Methods  ***********************/
	CashPayable build();
	
	CashPayable.CashPayableBuilder toBuilder();
	
	static CashPayable.CashPayableBuilder builder() {
		return new CashPayable.CashPayableBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends CashPayable> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends CashPayable> getType() {
		return CashPayable.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("payerPartyReference"), processor, PartyReference.class, getPayerPartyReference());
		processRosetta(path.newSubPath("receiverPartyReference"), processor, PartyReference.class, getReceiverPartyReference());
		processRosetta(path.newSubPath("netAmount"), processor, NonNegativeMoney.class, getNetAmount());
		processRosetta(path.newSubPath("taxWithholding"), processor, TaxWithholding.class, getTaxWithholding());
	}
	

	/*********************** Builder Interface  ***********************/
	interface CashPayableBuilder extends CashPayable, RosettaModelObjectBuilder {
		PartyReference.PartyReferenceBuilder getOrCreatePayerPartyReference();
		@Override
		PartyReference.PartyReferenceBuilder getPayerPartyReference();
		PartyReference.PartyReferenceBuilder getOrCreateReceiverPartyReference();
		@Override
		PartyReference.PartyReferenceBuilder getReceiverPartyReference();
		NonNegativeMoney.NonNegativeMoneyBuilder getOrCreateNetAmount();
		@Override
		NonNegativeMoney.NonNegativeMoneyBuilder getNetAmount();
		TaxWithholding.TaxWithholdingBuilder getOrCreateTaxWithholding(int index);
		@Override
		List<? extends TaxWithholding.TaxWithholdingBuilder> getTaxWithholding();
		CashPayable.CashPayableBuilder setPayerPartyReference(PartyReference payerPartyReference);
		CashPayable.CashPayableBuilder setReceiverPartyReference(PartyReference receiverPartyReference);
		CashPayable.CashPayableBuilder setNetAmount(NonNegativeMoney netAmount);
		CashPayable.CashPayableBuilder addTaxWithholding(TaxWithholding taxWithholding);
		CashPayable.CashPayableBuilder addTaxWithholding(TaxWithholding taxWithholding, int idx);
		CashPayable.CashPayableBuilder addTaxWithholding(List<? extends TaxWithholding> taxWithholding);
		CashPayable.CashPayableBuilder setTaxWithholding(List<? extends TaxWithholding> taxWithholding);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("payerPartyReference"), processor, PartyReference.PartyReferenceBuilder.class, getPayerPartyReference());
			processRosetta(path.newSubPath("receiverPartyReference"), processor, PartyReference.PartyReferenceBuilder.class, getReceiverPartyReference());
			processRosetta(path.newSubPath("netAmount"), processor, NonNegativeMoney.NonNegativeMoneyBuilder.class, getNetAmount());
			processRosetta(path.newSubPath("taxWithholding"), processor, TaxWithholding.TaxWithholdingBuilder.class, getTaxWithholding());
		}
		

		CashPayable.CashPayableBuilder prune();
	}

	/*********************** Immutable Implementation of CashPayable  ***********************/
	class CashPayableImpl implements CashPayable {
		private final PartyReference payerPartyReference;
		private final PartyReference receiverPartyReference;
		private final NonNegativeMoney netAmount;
		private final List<? extends TaxWithholding> taxWithholding;
		
		protected CashPayableImpl(CashPayable.CashPayableBuilder builder) {
			this.payerPartyReference = ofNullable(builder.getPayerPartyReference()).map(f->f.build()).orElse(null);
			this.receiverPartyReference = ofNullable(builder.getReceiverPartyReference()).map(f->f.build()).orElse(null);
			this.netAmount = ofNullable(builder.getNetAmount()).map(f->f.build()).orElse(null);
			this.taxWithholding = ofNullable(builder.getTaxWithholding()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		@RosettaAttribute("payerPartyReference")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("payerPartyReference")
		public PartyReference getPayerPartyReference() {
			return payerPartyReference;
		}
		
		@Override
		@RosettaAttribute("receiverPartyReference")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("receiverPartyReference")
		public PartyReference getReceiverPartyReference() {
			return receiverPartyReference;
		}
		
		@Override
		@RosettaAttribute("netAmount")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("netAmount")
		public NonNegativeMoney getNetAmount() {
			return netAmount;
		}
		
		@Override
		@RosettaAttribute("taxWithholding")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("taxWithholding")
		public List<? extends TaxWithholding> getTaxWithholding() {
			return taxWithholding;
		}
		
		@Override
		public CashPayable build() {
			return this;
		}
		
		@Override
		public CashPayable.CashPayableBuilder toBuilder() {
			CashPayable.CashPayableBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CashPayable.CashPayableBuilder builder) {
			ofNullable(getPayerPartyReference()).ifPresent(builder::setPayerPartyReference);
			ofNullable(getReceiverPartyReference()).ifPresent(builder::setReceiverPartyReference);
			ofNullable(getNetAmount()).ifPresent(builder::setNetAmount);
			ofNullable(getTaxWithholding()).ifPresent(builder::setTaxWithholding);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CashPayable _that = getType().cast(o);
		
			if (!Objects.equals(payerPartyReference, _that.getPayerPartyReference())) return false;
			if (!Objects.equals(receiverPartyReference, _that.getReceiverPartyReference())) return false;
			if (!Objects.equals(netAmount, _that.getNetAmount())) return false;
			if (!ListEquals.listEquals(taxWithholding, _that.getTaxWithholding())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (payerPartyReference != null ? payerPartyReference.hashCode() : 0);
			_result = 31 * _result + (receiverPartyReference != null ? receiverPartyReference.hashCode() : 0);
			_result = 31 * _result + (netAmount != null ? netAmount.hashCode() : 0);
			_result = 31 * _result + (taxWithholding != null ? taxWithholding.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CashPayable {" +
				"payerPartyReference=" + this.payerPartyReference + ", " +
				"receiverPartyReference=" + this.receiverPartyReference + ", " +
				"netAmount=" + this.netAmount + ", " +
				"taxWithholding=" + this.taxWithholding +
			'}';
		}
	}

	/*********************** Builder Implementation of CashPayable  ***********************/
	class CashPayableBuilderImpl implements CashPayable.CashPayableBuilder {
	
		protected PartyReference.PartyReferenceBuilder payerPartyReference;
		protected PartyReference.PartyReferenceBuilder receiverPartyReference;
		protected NonNegativeMoney.NonNegativeMoneyBuilder netAmount;
		protected List<TaxWithholding.TaxWithholdingBuilder> taxWithholding = new ArrayList<>();
		
		@Override
		@RosettaAttribute("payerPartyReference")
		@Accessor(AccessorType.GETTER)
		@Required
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
		@RosettaAttribute("receiverPartyReference")
		@Accessor(AccessorType.GETTER)
		@Required
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
		@RosettaAttribute("netAmount")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("netAmount")
		public NonNegativeMoney.NonNegativeMoneyBuilder getNetAmount() {
			return netAmount;
		}
		
		@Override
		public NonNegativeMoney.NonNegativeMoneyBuilder getOrCreateNetAmount() {
			NonNegativeMoney.NonNegativeMoneyBuilder result;
			if (netAmount!=null) {
				result = netAmount;
			}
			else {
				result = netAmount = NonNegativeMoney.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("taxWithholding")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("taxWithholding")
		public List<? extends TaxWithholding.TaxWithholdingBuilder> getTaxWithholding() {
			return taxWithholding;
		}
		
		@Override
		public TaxWithholding.TaxWithholdingBuilder getOrCreateTaxWithholding(int index) {
			if (taxWithholding==null) {
				this.taxWithholding = new ArrayList<>();
			}
			return getIndex(taxWithholding, index, () -> {
						TaxWithholding.TaxWithholdingBuilder newTaxWithholding = TaxWithholding.builder();
						return newTaxWithholding;
					});
		}
		
		@RosettaAttribute("payerPartyReference")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("payerPartyReference")
		@Override
		public CashPayable.CashPayableBuilder setPayerPartyReference(PartyReference _payerPartyReference) {
			this.payerPartyReference = _payerPartyReference == null ? null : _payerPartyReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("receiverPartyReference")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("receiverPartyReference")
		@Override
		public CashPayable.CashPayableBuilder setReceiverPartyReference(PartyReference _receiverPartyReference) {
			this.receiverPartyReference = _receiverPartyReference == null ? null : _receiverPartyReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("netAmount")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("netAmount")
		@Override
		public CashPayable.CashPayableBuilder setNetAmount(NonNegativeMoney _netAmount) {
			this.netAmount = _netAmount == null ? null : _netAmount.toBuilder();
			return this;
		}
		
		@RosettaAttribute("taxWithholding")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("taxWithholding")
		@Override
		public CashPayable.CashPayableBuilder addTaxWithholding(TaxWithholding _taxWithholding) {
			if (_taxWithholding != null) {
				this.taxWithholding.add(_taxWithholding.toBuilder());
			}
			return this;
		}
		
		@Override
		public CashPayable.CashPayableBuilder addTaxWithholding(TaxWithholding _taxWithholding, int idx) {
			getIndex(this.taxWithholding, idx, () -> _taxWithholding.toBuilder());
			return this;
		}
		
		@Override
		public CashPayable.CashPayableBuilder addTaxWithholding(List<? extends TaxWithholding> taxWithholdings) {
			if (taxWithholdings != null) {
				for (final TaxWithholding toAdd : taxWithholdings) {
					this.taxWithholding.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("taxWithholding")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("taxWithholding")
		@Override
		public CashPayable.CashPayableBuilder setTaxWithholding(List<? extends TaxWithholding> taxWithholdings) {
			if (taxWithholdings == null) {
				this.taxWithholding = new ArrayList<>();
			} else {
				this.taxWithholding = taxWithholdings.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		public CashPayable build() {
			return new CashPayable.CashPayableImpl(this);
		}
		
		@Override
		public CashPayable.CashPayableBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CashPayable.CashPayableBuilder prune() {
			if (payerPartyReference!=null && !payerPartyReference.prune().hasData()) payerPartyReference = null;
			if (receiverPartyReference!=null && !receiverPartyReference.prune().hasData()) receiverPartyReference = null;
			if (netAmount!=null && !netAmount.prune().hasData()) netAmount = null;
			taxWithholding = taxWithholding.stream().filter(b->b!=null).<TaxWithholding.TaxWithholdingBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getPayerPartyReference()!=null && getPayerPartyReference().hasData()) return true;
			if (getReceiverPartyReference()!=null && getReceiverPartyReference().hasData()) return true;
			if (getNetAmount()!=null && getNetAmount().hasData()) return true;
			if (getTaxWithholding()!=null && getTaxWithholding().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CashPayable.CashPayableBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			CashPayable.CashPayableBuilder o = (CashPayable.CashPayableBuilder) other;
			
			merger.mergeRosetta(getPayerPartyReference(), o.getPayerPartyReference(), this::setPayerPartyReference);
			merger.mergeRosetta(getReceiverPartyReference(), o.getReceiverPartyReference(), this::setReceiverPartyReference);
			merger.mergeRosetta(getNetAmount(), o.getNetAmount(), this::setNetAmount);
			merger.mergeRosetta(getTaxWithholding(), o.getTaxWithholding(), this::getOrCreateTaxWithholding);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CashPayable _that = getType().cast(o);
		
			if (!Objects.equals(payerPartyReference, _that.getPayerPartyReference())) return false;
			if (!Objects.equals(receiverPartyReference, _that.getReceiverPartyReference())) return false;
			if (!Objects.equals(netAmount, _that.getNetAmount())) return false;
			if (!ListEquals.listEquals(taxWithholding, _that.getTaxWithholding())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (payerPartyReference != null ? payerPartyReference.hashCode() : 0);
			_result = 31 * _result + (receiverPartyReference != null ? receiverPartyReference.hashCode() : 0);
			_result = 31 * _result + (netAmount != null ? netAmount.hashCode() : 0);
			_result = 31 * _result + (taxWithholding != null ? taxWithholding.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CashPayableBuilder {" +
				"payerPartyReference=" + this.payerPartyReference + ", " +
				"receiverPartyReference=" + this.receiverPartyReference + ", " +
				"netAmount=" + this.netAmount + ", " +
				"taxWithholding=" + this.taxWithholding +
			'}';
		}
	}
}

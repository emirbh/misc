package fpml.consolidated.option.shared;

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
import fpml.consolidated.asset.AssetReference;
import fpml.consolidated.option.shared.meta.PassThroughItemMeta;
import fpml.consolidated.shared.AccountReference;
import fpml.consolidated.shared.PartyReference;
import java.math.BigDecimal;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "recordkeeping-5.13"
 *
 * Provision Type to represent a single pass through payment.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision Type to represent a single pass through payment.
 *
 */
@RosettaDataType(value="PassThroughItem", builder=PassThroughItem.PassThroughItemBuilderImpl.class, version="2.1.1")
@RuneDataType(value="PassThroughItem", model="fpml", builder=PassThroughItem.PassThroughItemBuilderImpl.class, version="2.1.1")
public interface PassThroughItem extends RosettaModelObject {

	PassThroughItemMeta metaData = new PassThroughItemMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision A reference to the party responsible for making the payments defined by this structure.
	 *
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
	 * version "recordkeeping-5.13"
	 *
	 * Provision A reference to the account responsible for making the payments defined by this structure.
	 *
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
	 * version "recordkeeping-5.13"
	 *
	 * Provision A reference to the party that receives the payments corresponding to this structure.
	 *
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
	 * version "recordkeeping-5.13"
	 *
	 * Provision A reference to the account that receives the payments corresponding to this structure.
	 *
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
	 * version "recordkeeping-5.13"
	 *
	 * Provision Reference to the underlyer whose payments are being passed through.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Reference to the underlyer whose payments are being passed through.
	 *
	 */
	AssetReference getUnderlyerReference();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Percentage of payments from the underlyer which are passed through. A value expressed in percentage units i.e. 5 means 5%.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Percentage of payments from the underlyer which are passed through. A value expressed in percentage units i.e. 5 means 5%.
	 *
	 */
	BigDecimal getPassThroughPercentage();

	/*********************** Build Methods  ***********************/
	PassThroughItem build();
	
	PassThroughItem.PassThroughItemBuilder toBuilder();
	
	static PassThroughItem.PassThroughItemBuilder builder() {
		return new PassThroughItem.PassThroughItemBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends PassThroughItem> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends PassThroughItem> getType() {
		return PassThroughItem.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("payerPartyReference"), processor, PartyReference.class, getPayerPartyReference());
		processRosetta(path.newSubPath("payerAccountReference"), processor, AccountReference.class, getPayerAccountReference());
		processRosetta(path.newSubPath("receiverPartyReference"), processor, PartyReference.class, getReceiverPartyReference());
		processRosetta(path.newSubPath("receiverAccountReference"), processor, AccountReference.class, getReceiverAccountReference());
		processRosetta(path.newSubPath("underlyerReference"), processor, AssetReference.class, getUnderlyerReference());
		processor.processBasic(path.newSubPath("passThroughPercentage"), BigDecimal.class, getPassThroughPercentage(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface PassThroughItemBuilder extends PassThroughItem, RosettaModelObjectBuilder {
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
		AssetReference.AssetReferenceBuilder getOrCreateUnderlyerReference();
		@Override
		AssetReference.AssetReferenceBuilder getUnderlyerReference();
		PassThroughItem.PassThroughItemBuilder setPayerPartyReference(PartyReference payerPartyReference);
		PassThroughItem.PassThroughItemBuilder setPayerAccountReference(AccountReference payerAccountReference);
		PassThroughItem.PassThroughItemBuilder setReceiverPartyReference(PartyReference receiverPartyReference);
		PassThroughItem.PassThroughItemBuilder setReceiverAccountReference(AccountReference receiverAccountReference);
		PassThroughItem.PassThroughItemBuilder setUnderlyerReference(AssetReference underlyerReference);
		PassThroughItem.PassThroughItemBuilder setPassThroughPercentage(BigDecimal passThroughPercentage);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("payerPartyReference"), processor, PartyReference.PartyReferenceBuilder.class, getPayerPartyReference());
			processRosetta(path.newSubPath("payerAccountReference"), processor, AccountReference.AccountReferenceBuilder.class, getPayerAccountReference());
			processRosetta(path.newSubPath("receiverPartyReference"), processor, PartyReference.PartyReferenceBuilder.class, getReceiverPartyReference());
			processRosetta(path.newSubPath("receiverAccountReference"), processor, AccountReference.AccountReferenceBuilder.class, getReceiverAccountReference());
			processRosetta(path.newSubPath("underlyerReference"), processor, AssetReference.AssetReferenceBuilder.class, getUnderlyerReference());
			processor.processBasic(path.newSubPath("passThroughPercentage"), BigDecimal.class, getPassThroughPercentage(), this);
		}
		

		PassThroughItem.PassThroughItemBuilder prune();
	}

	/*********************** Immutable Implementation of PassThroughItem  ***********************/
	class PassThroughItemImpl implements PassThroughItem {
		private final PartyReference payerPartyReference;
		private final AccountReference payerAccountReference;
		private final PartyReference receiverPartyReference;
		private final AccountReference receiverAccountReference;
		private final AssetReference underlyerReference;
		private final BigDecimal passThroughPercentage;
		
		protected PassThroughItemImpl(PassThroughItem.PassThroughItemBuilder builder) {
			this.payerPartyReference = ofNullable(builder.getPayerPartyReference()).map(f->f.build()).orElse(null);
			this.payerAccountReference = ofNullable(builder.getPayerAccountReference()).map(f->f.build()).orElse(null);
			this.receiverPartyReference = ofNullable(builder.getReceiverPartyReference()).map(f->f.build()).orElse(null);
			this.receiverAccountReference = ofNullable(builder.getReceiverAccountReference()).map(f->f.build()).orElse(null);
			this.underlyerReference = ofNullable(builder.getUnderlyerReference()).map(f->f.build()).orElse(null);
			this.passThroughPercentage = builder.getPassThroughPercentage();
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
		@RosettaAttribute("underlyerReference")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("underlyerReference")
		public AssetReference getUnderlyerReference() {
			return underlyerReference;
		}
		
		@Override
		@RosettaAttribute("passThroughPercentage")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("passThroughPercentage")
		public BigDecimal getPassThroughPercentage() {
			return passThroughPercentage;
		}
		
		@Override
		public PassThroughItem build() {
			return this;
		}
		
		@Override
		public PassThroughItem.PassThroughItemBuilder toBuilder() {
			PassThroughItem.PassThroughItemBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(PassThroughItem.PassThroughItemBuilder builder) {
			ofNullable(getPayerPartyReference()).ifPresent(builder::setPayerPartyReference);
			ofNullable(getPayerAccountReference()).ifPresent(builder::setPayerAccountReference);
			ofNullable(getReceiverPartyReference()).ifPresent(builder::setReceiverPartyReference);
			ofNullable(getReceiverAccountReference()).ifPresent(builder::setReceiverAccountReference);
			ofNullable(getUnderlyerReference()).ifPresent(builder::setUnderlyerReference);
			ofNullable(getPassThroughPercentage()).ifPresent(builder::setPassThroughPercentage);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			PassThroughItem _that = getType().cast(o);
		
			if (!Objects.equals(payerPartyReference, _that.getPayerPartyReference())) return false;
			if (!Objects.equals(payerAccountReference, _that.getPayerAccountReference())) return false;
			if (!Objects.equals(receiverPartyReference, _that.getReceiverPartyReference())) return false;
			if (!Objects.equals(receiverAccountReference, _that.getReceiverAccountReference())) return false;
			if (!Objects.equals(underlyerReference, _that.getUnderlyerReference())) return false;
			if (!Objects.equals(passThroughPercentage, _that.getPassThroughPercentage())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (payerPartyReference != null ? payerPartyReference.hashCode() : 0);
			_result = 31 * _result + (payerAccountReference != null ? payerAccountReference.hashCode() : 0);
			_result = 31 * _result + (receiverPartyReference != null ? receiverPartyReference.hashCode() : 0);
			_result = 31 * _result + (receiverAccountReference != null ? receiverAccountReference.hashCode() : 0);
			_result = 31 * _result + (underlyerReference != null ? underlyerReference.hashCode() : 0);
			_result = 31 * _result + (passThroughPercentage != null ? passThroughPercentage.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "PassThroughItem {" +
				"payerPartyReference=" + this.payerPartyReference + ", " +
				"payerAccountReference=" + this.payerAccountReference + ", " +
				"receiverPartyReference=" + this.receiverPartyReference + ", " +
				"receiverAccountReference=" + this.receiverAccountReference + ", " +
				"underlyerReference=" + this.underlyerReference + ", " +
				"passThroughPercentage=" + this.passThroughPercentage +
			'}';
		}
	}

	/*********************** Builder Implementation of PassThroughItem  ***********************/
	class PassThroughItemBuilderImpl implements PassThroughItem.PassThroughItemBuilder {
	
		protected PartyReference.PartyReferenceBuilder payerPartyReference;
		protected AccountReference.AccountReferenceBuilder payerAccountReference;
		protected PartyReference.PartyReferenceBuilder receiverPartyReference;
		protected AccountReference.AccountReferenceBuilder receiverAccountReference;
		protected AssetReference.AssetReferenceBuilder underlyerReference;
		protected BigDecimal passThroughPercentage;
		
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
		@RosettaAttribute("underlyerReference")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("underlyerReference")
		public AssetReference.AssetReferenceBuilder getUnderlyerReference() {
			return underlyerReference;
		}
		
		@Override
		public AssetReference.AssetReferenceBuilder getOrCreateUnderlyerReference() {
			AssetReference.AssetReferenceBuilder result;
			if (underlyerReference!=null) {
				result = underlyerReference;
			}
			else {
				result = underlyerReference = AssetReference.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("passThroughPercentage")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("passThroughPercentage")
		public BigDecimal getPassThroughPercentage() {
			return passThroughPercentage;
		}
		
		@RosettaAttribute("payerPartyReference")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("payerPartyReference")
		@Override
		public PassThroughItem.PassThroughItemBuilder setPayerPartyReference(PartyReference _payerPartyReference) {
			this.payerPartyReference = _payerPartyReference == null ? null : _payerPartyReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("payerAccountReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("payerAccountReference")
		@Override
		public PassThroughItem.PassThroughItemBuilder setPayerAccountReference(AccountReference _payerAccountReference) {
			this.payerAccountReference = _payerAccountReference == null ? null : _payerAccountReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("receiverPartyReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("receiverPartyReference")
		@Override
		public PassThroughItem.PassThroughItemBuilder setReceiverPartyReference(PartyReference _receiverPartyReference) {
			this.receiverPartyReference = _receiverPartyReference == null ? null : _receiverPartyReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("receiverAccountReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("receiverAccountReference")
		@Override
		public PassThroughItem.PassThroughItemBuilder setReceiverAccountReference(AccountReference _receiverAccountReference) {
			this.receiverAccountReference = _receiverAccountReference == null ? null : _receiverAccountReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("underlyerReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("underlyerReference")
		@Override
		public PassThroughItem.PassThroughItemBuilder setUnderlyerReference(AssetReference _underlyerReference) {
			this.underlyerReference = _underlyerReference == null ? null : _underlyerReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("passThroughPercentage")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("passThroughPercentage")
		@Override
		public PassThroughItem.PassThroughItemBuilder setPassThroughPercentage(BigDecimal _passThroughPercentage) {
			this.passThroughPercentage = _passThroughPercentage == null ? null : _passThroughPercentage;
			return this;
		}
		
		@Override
		public PassThroughItem build() {
			return new PassThroughItem.PassThroughItemImpl(this);
		}
		
		@Override
		public PassThroughItem.PassThroughItemBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public PassThroughItem.PassThroughItemBuilder prune() {
			if (payerPartyReference!=null && !payerPartyReference.prune().hasData()) payerPartyReference = null;
			if (payerAccountReference!=null && !payerAccountReference.prune().hasData()) payerAccountReference = null;
			if (receiverPartyReference!=null && !receiverPartyReference.prune().hasData()) receiverPartyReference = null;
			if (receiverAccountReference!=null && !receiverAccountReference.prune().hasData()) receiverAccountReference = null;
			if (underlyerReference!=null && !underlyerReference.prune().hasData()) underlyerReference = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getPayerPartyReference()!=null && getPayerPartyReference().hasData()) return true;
			if (getPayerAccountReference()!=null && getPayerAccountReference().hasData()) return true;
			if (getReceiverPartyReference()!=null && getReceiverPartyReference().hasData()) return true;
			if (getReceiverAccountReference()!=null && getReceiverAccountReference().hasData()) return true;
			if (getUnderlyerReference()!=null && getUnderlyerReference().hasData()) return true;
			if (getPassThroughPercentage()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public PassThroughItem.PassThroughItemBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			PassThroughItem.PassThroughItemBuilder o = (PassThroughItem.PassThroughItemBuilder) other;
			
			merger.mergeRosetta(getPayerPartyReference(), o.getPayerPartyReference(), this::setPayerPartyReference);
			merger.mergeRosetta(getPayerAccountReference(), o.getPayerAccountReference(), this::setPayerAccountReference);
			merger.mergeRosetta(getReceiverPartyReference(), o.getReceiverPartyReference(), this::setReceiverPartyReference);
			merger.mergeRosetta(getReceiverAccountReference(), o.getReceiverAccountReference(), this::setReceiverAccountReference);
			merger.mergeRosetta(getUnderlyerReference(), o.getUnderlyerReference(), this::setUnderlyerReference);
			
			merger.mergeBasic(getPassThroughPercentage(), o.getPassThroughPercentage(), this::setPassThroughPercentage);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			PassThroughItem _that = getType().cast(o);
		
			if (!Objects.equals(payerPartyReference, _that.getPayerPartyReference())) return false;
			if (!Objects.equals(payerAccountReference, _that.getPayerAccountReference())) return false;
			if (!Objects.equals(receiverPartyReference, _that.getReceiverPartyReference())) return false;
			if (!Objects.equals(receiverAccountReference, _that.getReceiverAccountReference())) return false;
			if (!Objects.equals(underlyerReference, _that.getUnderlyerReference())) return false;
			if (!Objects.equals(passThroughPercentage, _that.getPassThroughPercentage())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (payerPartyReference != null ? payerPartyReference.hashCode() : 0);
			_result = 31 * _result + (payerAccountReference != null ? payerAccountReference.hashCode() : 0);
			_result = 31 * _result + (receiverPartyReference != null ? receiverPartyReference.hashCode() : 0);
			_result = 31 * _result + (receiverAccountReference != null ? receiverAccountReference.hashCode() : 0);
			_result = 31 * _result + (underlyerReference != null ? underlyerReference.hashCode() : 0);
			_result = 31 * _result + (passThroughPercentage != null ? passThroughPercentage.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "PassThroughItemBuilder {" +
				"payerPartyReference=" + this.payerPartyReference + ", " +
				"payerAccountReference=" + this.payerAccountReference + ", " +
				"receiverPartyReference=" + this.receiverPartyReference + ", " +
				"receiverAccountReference=" + this.receiverAccountReference + ", " +
				"underlyerReference=" + this.underlyerReference + ", " +
				"passThroughPercentage=" + this.passThroughPercentage +
			'}';
		}
	}
}

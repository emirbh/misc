package fpml.consolidated.recordkeeping.processes;

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
import fpml.consolidated.doc.ClearingStatusValue;
import fpml.consolidated.recordkeeping.processes.meta.RegReportingCDEMeta;
import fpml.consolidated.shared.PartyReference;
import java.time.ZonedDateTime;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "recordkeeping-5.13"
 *
 * Provision DEPRECATED. Not in use (RPTWG decision 2024-12-12).
 *
 */
@RosettaDataType(value="RegReportingCDE", builder=RegReportingCDE.RegReportingCDEBuilderImpl.class, version="2.1.1")
@RuneDataType(value="RegReportingCDE", model="fpml", builder=RegReportingCDE.RegReportingCDEBuilderImpl.class, version="2.1.1")
public interface RegReportingCDE extends RegulatoryClassification {

	RegReportingCDEMeta metaData = new RegReportingCDEMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Indicates the party this regulator considers to be the buyer
	 *
	 */
	PartyReference getBuyerPartyReference();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Indicates the party this regulator considers to be the seller.
	 *
	 */
	PartyReference getSellerPartyReference();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision DEPRECATED. Not in use (RPTWG decision 2024-12-12). Unadjusted date as per the contract, by which all transfer of cash or assets should take place and the counterparties should no longer have any outstanding obligations to each other under that contract. For products that may not have a final contractual settlement date (eg American options), this data element reflects the date by which the transfer of cash or asset would take place if termination were to occur on the expiration date.
	 *
	 */
	ZonedDateTime getFinalContractualSettlementDate();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision DEPRECATED. Not in use (RPTWG decision 2024-12-12). Effective date of the early termination (expiry) of the reported transaction. This data element is applicable if the termination of the transaction occurs prior to its maturity due to an ex-interim decision of a counterparty (or counterparties). Examples of early terminations (expiry) are: negotiated early termination; early termination under an optional early termination provision ("mutual put"); novation; offsetting (netting) transaction; option exercise; compression; early termination clause specified in the original contract which is a callable swap (bought embedded option); mutual credit break.
	 *
	 */
	ZonedDateTime getEarlyTerminationDate();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision DEPRECATED. Not in use (RPTWG decision 2024-12-12). Indicator of whether the transaction has been cleared, or is intended to be cleared, by a central counterparty.
	 *
	 */
	ClearingStatusValue getClearingStatus();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision DEPRECATED. Not in use (RPTWG decision 2024-12-12). For new reportable transactions (as defined by the CPMI-IOSCO Technical Guidance: Harmonisation of the Unique Transaction Identifier), whether the legally binding terms of an OTC derivatives contract were documented and agreed upon (confirmed) or not (unconfirmed). If documented and agreed, whether such confirmation was done: - via a shared confirmation facility or platform, or a private/bilateral electronic system (electronic); - via a human-readable written document, such as fax, paper or manually processed e-mails (non-electronic).
	 *
	 */
	String getConfirmationStatus();

	/*********************** Build Methods  ***********************/
	RegReportingCDE build();
	
	RegReportingCDE.RegReportingCDEBuilder toBuilder();
	
	static RegReportingCDE.RegReportingCDEBuilder builder() {
		return new RegReportingCDE.RegReportingCDEBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends RegReportingCDE> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends RegReportingCDE> getType() {
		return RegReportingCDE.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("buyerPartyReference"), processor, PartyReference.class, getBuyerPartyReference());
		processRosetta(path.newSubPath("sellerPartyReference"), processor, PartyReference.class, getSellerPartyReference());
		processor.processBasic(path.newSubPath("finalContractualSettlementDate"), ZonedDateTime.class, getFinalContractualSettlementDate(), this);
		processor.processBasic(path.newSubPath("earlyTerminationDate"), ZonedDateTime.class, getEarlyTerminationDate(), this);
		processRosetta(path.newSubPath("clearingStatus"), processor, ClearingStatusValue.class, getClearingStatus());
		processor.processBasic(path.newSubPath("confirmationStatus"), String.class, getConfirmationStatus(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface RegReportingCDEBuilder extends RegReportingCDE, RegulatoryClassification.RegulatoryClassificationBuilder {
		PartyReference.PartyReferenceBuilder getOrCreateBuyerPartyReference();
		@Override
		PartyReference.PartyReferenceBuilder getBuyerPartyReference();
		PartyReference.PartyReferenceBuilder getOrCreateSellerPartyReference();
		@Override
		PartyReference.PartyReferenceBuilder getSellerPartyReference();
		ClearingStatusValue.ClearingStatusValueBuilder getOrCreateClearingStatus();
		@Override
		ClearingStatusValue.ClearingStatusValueBuilder getClearingStatus();
		RegReportingCDE.RegReportingCDEBuilder setBuyerPartyReference(PartyReference buyerPartyReference);
		RegReportingCDE.RegReportingCDEBuilder setSellerPartyReference(PartyReference sellerPartyReference);
		RegReportingCDE.RegReportingCDEBuilder setFinalContractualSettlementDate(ZonedDateTime finalContractualSettlementDate);
		RegReportingCDE.RegReportingCDEBuilder setEarlyTerminationDate(ZonedDateTime earlyTerminationDate);
		RegReportingCDE.RegReportingCDEBuilder setClearingStatus(ClearingStatusValue clearingStatus);
		RegReportingCDE.RegReportingCDEBuilder setConfirmationStatus(String confirmationStatus);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("buyerPartyReference"), processor, PartyReference.PartyReferenceBuilder.class, getBuyerPartyReference());
			processRosetta(path.newSubPath("sellerPartyReference"), processor, PartyReference.PartyReferenceBuilder.class, getSellerPartyReference());
			processor.processBasic(path.newSubPath("finalContractualSettlementDate"), ZonedDateTime.class, getFinalContractualSettlementDate(), this);
			processor.processBasic(path.newSubPath("earlyTerminationDate"), ZonedDateTime.class, getEarlyTerminationDate(), this);
			processRosetta(path.newSubPath("clearingStatus"), processor, ClearingStatusValue.ClearingStatusValueBuilder.class, getClearingStatus());
			processor.processBasic(path.newSubPath("confirmationStatus"), String.class, getConfirmationStatus(), this);
		}
		

		RegReportingCDE.RegReportingCDEBuilder prune();
	}

	/*********************** Immutable Implementation of RegReportingCDE  ***********************/
	class RegReportingCDEImpl extends RegulatoryClassification.RegulatoryClassificationImpl implements RegReportingCDE {
		private final PartyReference buyerPartyReference;
		private final PartyReference sellerPartyReference;
		private final ZonedDateTime finalContractualSettlementDate;
		private final ZonedDateTime earlyTerminationDate;
		private final ClearingStatusValue clearingStatus;
		private final String confirmationStatus;
		
		protected RegReportingCDEImpl(RegReportingCDE.RegReportingCDEBuilder builder) {
			super(builder);
			this.buyerPartyReference = ofNullable(builder.getBuyerPartyReference()).map(f->f.build()).orElse(null);
			this.sellerPartyReference = ofNullable(builder.getSellerPartyReference()).map(f->f.build()).orElse(null);
			this.finalContractualSettlementDate = builder.getFinalContractualSettlementDate();
			this.earlyTerminationDate = builder.getEarlyTerminationDate();
			this.clearingStatus = ofNullable(builder.getClearingStatus()).map(f->f.build()).orElse(null);
			this.confirmationStatus = builder.getConfirmationStatus();
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
		@RosettaAttribute("finalContractualSettlementDate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("finalContractualSettlementDate")
		public ZonedDateTime getFinalContractualSettlementDate() {
			return finalContractualSettlementDate;
		}
		
		@Override
		@RosettaAttribute("earlyTerminationDate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("earlyTerminationDate")
		public ZonedDateTime getEarlyTerminationDate() {
			return earlyTerminationDate;
		}
		
		@Override
		@RosettaAttribute("clearingStatus")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("clearingStatus")
		public ClearingStatusValue getClearingStatus() {
			return clearingStatus;
		}
		
		@Override
		@RosettaAttribute("confirmationStatus")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("confirmationStatus")
		public String getConfirmationStatus() {
			return confirmationStatus;
		}
		
		@Override
		public RegReportingCDE build() {
			return this;
		}
		
		@Override
		public RegReportingCDE.RegReportingCDEBuilder toBuilder() {
			RegReportingCDE.RegReportingCDEBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(RegReportingCDE.RegReportingCDEBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getBuyerPartyReference()).ifPresent(builder::setBuyerPartyReference);
			ofNullable(getSellerPartyReference()).ifPresent(builder::setSellerPartyReference);
			ofNullable(getFinalContractualSettlementDate()).ifPresent(builder::setFinalContractualSettlementDate);
			ofNullable(getEarlyTerminationDate()).ifPresent(builder::setEarlyTerminationDate);
			ofNullable(getClearingStatus()).ifPresent(builder::setClearingStatus);
			ofNullable(getConfirmationStatus()).ifPresent(builder::setConfirmationStatus);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			RegReportingCDE _that = getType().cast(o);
		
			if (!Objects.equals(buyerPartyReference, _that.getBuyerPartyReference())) return false;
			if (!Objects.equals(sellerPartyReference, _that.getSellerPartyReference())) return false;
			if (!Objects.equals(finalContractualSettlementDate, _that.getFinalContractualSettlementDate())) return false;
			if (!Objects.equals(earlyTerminationDate, _that.getEarlyTerminationDate())) return false;
			if (!Objects.equals(clearingStatus, _that.getClearingStatus())) return false;
			if (!Objects.equals(confirmationStatus, _that.getConfirmationStatus())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (buyerPartyReference != null ? buyerPartyReference.hashCode() : 0);
			_result = 31 * _result + (sellerPartyReference != null ? sellerPartyReference.hashCode() : 0);
			_result = 31 * _result + (finalContractualSettlementDate != null ? finalContractualSettlementDate.hashCode() : 0);
			_result = 31 * _result + (earlyTerminationDate != null ? earlyTerminationDate.hashCode() : 0);
			_result = 31 * _result + (clearingStatus != null ? clearingStatus.hashCode() : 0);
			_result = 31 * _result + (confirmationStatus != null ? confirmationStatus.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "RegReportingCDE {" +
				"buyerPartyReference=" + this.buyerPartyReference + ", " +
				"sellerPartyReference=" + this.sellerPartyReference + ", " +
				"finalContractualSettlementDate=" + this.finalContractualSettlementDate + ", " +
				"earlyTerminationDate=" + this.earlyTerminationDate + ", " +
				"clearingStatus=" + this.clearingStatus + ", " +
				"confirmationStatus=" + this.confirmationStatus +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of RegReportingCDE  ***********************/
	class RegReportingCDEBuilderImpl extends RegulatoryClassification.RegulatoryClassificationBuilderImpl implements RegReportingCDE.RegReportingCDEBuilder {
	
		protected PartyReference.PartyReferenceBuilder buyerPartyReference;
		protected PartyReference.PartyReferenceBuilder sellerPartyReference;
		protected ZonedDateTime finalContractualSettlementDate;
		protected ZonedDateTime earlyTerminationDate;
		protected ClearingStatusValue.ClearingStatusValueBuilder clearingStatus;
		protected String confirmationStatus;
		
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
		
		@Override
		@RosettaAttribute("finalContractualSettlementDate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("finalContractualSettlementDate")
		public ZonedDateTime getFinalContractualSettlementDate() {
			return finalContractualSettlementDate;
		}
		
		@Override
		@RosettaAttribute("earlyTerminationDate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("earlyTerminationDate")
		public ZonedDateTime getEarlyTerminationDate() {
			return earlyTerminationDate;
		}
		
		@Override
		@RosettaAttribute("clearingStatus")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("clearingStatus")
		public ClearingStatusValue.ClearingStatusValueBuilder getClearingStatus() {
			return clearingStatus;
		}
		
		@Override
		public ClearingStatusValue.ClearingStatusValueBuilder getOrCreateClearingStatus() {
			ClearingStatusValue.ClearingStatusValueBuilder result;
			if (clearingStatus!=null) {
				result = clearingStatus;
			}
			else {
				result = clearingStatus = ClearingStatusValue.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("confirmationStatus")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("confirmationStatus")
		public String getConfirmationStatus() {
			return confirmationStatus;
		}
		
		@RosettaAttribute("buyerPartyReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("buyerPartyReference")
		@Override
		public RegReportingCDE.RegReportingCDEBuilder setBuyerPartyReference(PartyReference _buyerPartyReference) {
			this.buyerPartyReference = _buyerPartyReference == null ? null : _buyerPartyReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("sellerPartyReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("sellerPartyReference")
		@Override
		public RegReportingCDE.RegReportingCDEBuilder setSellerPartyReference(PartyReference _sellerPartyReference) {
			this.sellerPartyReference = _sellerPartyReference == null ? null : _sellerPartyReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("finalContractualSettlementDate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("finalContractualSettlementDate")
		@Override
		public RegReportingCDE.RegReportingCDEBuilder setFinalContractualSettlementDate(ZonedDateTime _finalContractualSettlementDate) {
			this.finalContractualSettlementDate = _finalContractualSettlementDate == null ? null : _finalContractualSettlementDate;
			return this;
		}
		
		@RosettaAttribute("earlyTerminationDate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("earlyTerminationDate")
		@Override
		public RegReportingCDE.RegReportingCDEBuilder setEarlyTerminationDate(ZonedDateTime _earlyTerminationDate) {
			this.earlyTerminationDate = _earlyTerminationDate == null ? null : _earlyTerminationDate;
			return this;
		}
		
		@RosettaAttribute("clearingStatus")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("clearingStatus")
		@Override
		public RegReportingCDE.RegReportingCDEBuilder setClearingStatus(ClearingStatusValue _clearingStatus) {
			this.clearingStatus = _clearingStatus == null ? null : _clearingStatus.toBuilder();
			return this;
		}
		
		@RosettaAttribute("confirmationStatus")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("confirmationStatus")
		@Override
		public RegReportingCDE.RegReportingCDEBuilder setConfirmationStatus(String _confirmationStatus) {
			this.confirmationStatus = _confirmationStatus == null ? null : _confirmationStatus;
			return this;
		}
		
		@Override
		public RegReportingCDE build() {
			return new RegReportingCDE.RegReportingCDEImpl(this);
		}
		
		@Override
		public RegReportingCDE.RegReportingCDEBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public RegReportingCDE.RegReportingCDEBuilder prune() {
			super.prune();
			if (buyerPartyReference!=null && !buyerPartyReference.prune().hasData()) buyerPartyReference = null;
			if (sellerPartyReference!=null && !sellerPartyReference.prune().hasData()) sellerPartyReference = null;
			if (clearingStatus!=null && !clearingStatus.prune().hasData()) clearingStatus = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getBuyerPartyReference()!=null && getBuyerPartyReference().hasData()) return true;
			if (getSellerPartyReference()!=null && getSellerPartyReference().hasData()) return true;
			if (getFinalContractualSettlementDate()!=null) return true;
			if (getEarlyTerminationDate()!=null) return true;
			if (getClearingStatus()!=null && getClearingStatus().hasData()) return true;
			if (getConfirmationStatus()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public RegReportingCDE.RegReportingCDEBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			RegReportingCDE.RegReportingCDEBuilder o = (RegReportingCDE.RegReportingCDEBuilder) other;
			
			merger.mergeRosetta(getBuyerPartyReference(), o.getBuyerPartyReference(), this::setBuyerPartyReference);
			merger.mergeRosetta(getSellerPartyReference(), o.getSellerPartyReference(), this::setSellerPartyReference);
			merger.mergeRosetta(getClearingStatus(), o.getClearingStatus(), this::setClearingStatus);
			
			merger.mergeBasic(getFinalContractualSettlementDate(), o.getFinalContractualSettlementDate(), this::setFinalContractualSettlementDate);
			merger.mergeBasic(getEarlyTerminationDate(), o.getEarlyTerminationDate(), this::setEarlyTerminationDate);
			merger.mergeBasic(getConfirmationStatus(), o.getConfirmationStatus(), this::setConfirmationStatus);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			RegReportingCDE _that = getType().cast(o);
		
			if (!Objects.equals(buyerPartyReference, _that.getBuyerPartyReference())) return false;
			if (!Objects.equals(sellerPartyReference, _that.getSellerPartyReference())) return false;
			if (!Objects.equals(finalContractualSettlementDate, _that.getFinalContractualSettlementDate())) return false;
			if (!Objects.equals(earlyTerminationDate, _that.getEarlyTerminationDate())) return false;
			if (!Objects.equals(clearingStatus, _that.getClearingStatus())) return false;
			if (!Objects.equals(confirmationStatus, _that.getConfirmationStatus())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (buyerPartyReference != null ? buyerPartyReference.hashCode() : 0);
			_result = 31 * _result + (sellerPartyReference != null ? sellerPartyReference.hashCode() : 0);
			_result = 31 * _result + (finalContractualSettlementDate != null ? finalContractualSettlementDate.hashCode() : 0);
			_result = 31 * _result + (earlyTerminationDate != null ? earlyTerminationDate.hashCode() : 0);
			_result = 31 * _result + (clearingStatus != null ? clearingStatus.hashCode() : 0);
			_result = 31 * _result + (confirmationStatus != null ? confirmationStatus.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "RegReportingCDEBuilder {" +
				"buyerPartyReference=" + this.buyerPartyReference + ", " +
				"sellerPartyReference=" + this.sellerPartyReference + ", " +
				"finalContractualSettlementDate=" + this.finalContractualSettlementDate + ", " +
				"earlyTerminationDate=" + this.earlyTerminationDate + ", " +
				"clearingStatus=" + this.clearingStatus + ", " +
				"confirmationStatus=" + this.confirmationStatus +
			'}' + " " + super.toString();
		}
	}
}

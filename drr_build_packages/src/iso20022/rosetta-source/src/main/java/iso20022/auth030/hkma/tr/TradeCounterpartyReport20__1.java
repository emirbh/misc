package iso20022.auth030.hkma.tr;

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
import iso20022.auth030.hkma.tr.meta.TradeCounterpartyReport20__1Meta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * Information related to parties in the contract.
 * @version ${project.version}
 */
@RosettaDataType(value="TradeCounterpartyReport20__1", builder=TradeCounterpartyReport20__1.TradeCounterpartyReport20__1BuilderImpl.class, version="${project.version}")
@RuneDataType(value="TradeCounterpartyReport20__1", model="iso20022", builder=TradeCounterpartyReport20__1.TradeCounterpartyReport20__1BuilderImpl.class, version="${project.version}")
public interface TradeCounterpartyReport20__1 extends RosettaModelObject {

	TradeCounterpartyReport20__1Meta metaData = new TradeCounterpartyReport20__1Meta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Identification of the counterparty to a derivative transaction who is fulfilling its reporting obligation in the present report.
	 */
	Counterparty45__1 getRptgCtrPty();
	/**
	 * Identification of the other counterparty to a derivative transaction.
	 */
	Counterparty46__1 getOthrCtrPty();
	/**
	 * Identification of the entity [party] acting as an intermediary which [who] arranges the transaction for the reporting counterparty (“arranging broker”).
	 */
	OrganisationIdentification15Choice__3 getBrkr();
	/**
	 * Identification of the party that ultimately submits the report to the trade repository.
	 */
	OrganisationIdentification15Choice__4 getSubmitgAgt();
	/**
	 * Identifies the clearing member through which a derivative transaction is cleared at a central counterparty (CCP).  The element applies to transactions under the agency clearing model and the principal clearing model.
	 */
	PartyIdentification248Choice__3 getClrMmb();
	/**
	 * Identification of the beneficiary of a derivative transaction, that is a party that is subject to the rights and obligations arising from the contract.    Usage: In case of two occurances of beneficiary, the first iteration should always be the beneficiary 1 of the counterparty 1 and the second iteration is the beneficiary 2 of the counterparty 2. In case of single occurance of Beneficiary, RelationshipRecord should be provided.
	 */
	PartyIdentification248Choice__4 getBnfcry();
	/**
	 * According to jurisdictional requirements, identification of the entity with the legal obligation or responsibility to report.
	 */
	OrganisationIdentification15Choice__1 getNttyRspnsblForRpt();

	/*********************** Build Methods  ***********************/
	TradeCounterpartyReport20__1 build();
	
	TradeCounterpartyReport20__1.TradeCounterpartyReport20__1Builder toBuilder();
	
	static TradeCounterpartyReport20__1.TradeCounterpartyReport20__1Builder builder() {
		return new TradeCounterpartyReport20__1.TradeCounterpartyReport20__1BuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends TradeCounterpartyReport20__1> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends TradeCounterpartyReport20__1> getType() {
		return TradeCounterpartyReport20__1.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("rptgCtrPty"), processor, Counterparty45__1.class, getRptgCtrPty());
		processRosetta(path.newSubPath("othrCtrPty"), processor, Counterparty46__1.class, getOthrCtrPty());
		processRosetta(path.newSubPath("brkr"), processor, OrganisationIdentification15Choice__3.class, getBrkr());
		processRosetta(path.newSubPath("submitgAgt"), processor, OrganisationIdentification15Choice__4.class, getSubmitgAgt());
		processRosetta(path.newSubPath("clrMmb"), processor, PartyIdentification248Choice__3.class, getClrMmb());
		processRosetta(path.newSubPath("bnfcry"), processor, PartyIdentification248Choice__4.class, getBnfcry());
		processRosetta(path.newSubPath("nttyRspnsblForRpt"), processor, OrganisationIdentification15Choice__1.class, getNttyRspnsblForRpt());
	}
	

	/*********************** Builder Interface  ***********************/
	interface TradeCounterpartyReport20__1Builder extends TradeCounterpartyReport20__1, RosettaModelObjectBuilder {
		Counterparty45__1.Counterparty45__1Builder getOrCreateRptgCtrPty();
		@Override
		Counterparty45__1.Counterparty45__1Builder getRptgCtrPty();
		Counterparty46__1.Counterparty46__1Builder getOrCreateOthrCtrPty();
		@Override
		Counterparty46__1.Counterparty46__1Builder getOthrCtrPty();
		OrganisationIdentification15Choice__3.OrganisationIdentification15Choice__3Builder getOrCreateBrkr();
		@Override
		OrganisationIdentification15Choice__3.OrganisationIdentification15Choice__3Builder getBrkr();
		OrganisationIdentification15Choice__4.OrganisationIdentification15Choice__4Builder getOrCreateSubmitgAgt();
		@Override
		OrganisationIdentification15Choice__4.OrganisationIdentification15Choice__4Builder getSubmitgAgt();
		PartyIdentification248Choice__3.PartyIdentification248Choice__3Builder getOrCreateClrMmb();
		@Override
		PartyIdentification248Choice__3.PartyIdentification248Choice__3Builder getClrMmb();
		PartyIdentification248Choice__4.PartyIdentification248Choice__4Builder getOrCreateBnfcry();
		@Override
		PartyIdentification248Choice__4.PartyIdentification248Choice__4Builder getBnfcry();
		OrganisationIdentification15Choice__1.OrganisationIdentification15Choice__1Builder getOrCreateNttyRspnsblForRpt();
		@Override
		OrganisationIdentification15Choice__1.OrganisationIdentification15Choice__1Builder getNttyRspnsblForRpt();
		TradeCounterpartyReport20__1.TradeCounterpartyReport20__1Builder setRptgCtrPty(Counterparty45__1 rptgCtrPty);
		TradeCounterpartyReport20__1.TradeCounterpartyReport20__1Builder setOthrCtrPty(Counterparty46__1 othrCtrPty);
		TradeCounterpartyReport20__1.TradeCounterpartyReport20__1Builder setBrkr(OrganisationIdentification15Choice__3 brkr);
		TradeCounterpartyReport20__1.TradeCounterpartyReport20__1Builder setSubmitgAgt(OrganisationIdentification15Choice__4 submitgAgt);
		TradeCounterpartyReport20__1.TradeCounterpartyReport20__1Builder setClrMmb(PartyIdentification248Choice__3 clrMmb);
		TradeCounterpartyReport20__1.TradeCounterpartyReport20__1Builder setBnfcry(PartyIdentification248Choice__4 bnfcry);
		TradeCounterpartyReport20__1.TradeCounterpartyReport20__1Builder setNttyRspnsblForRpt(OrganisationIdentification15Choice__1 nttyRspnsblForRpt);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("rptgCtrPty"), processor, Counterparty45__1.Counterparty45__1Builder.class, getRptgCtrPty());
			processRosetta(path.newSubPath("othrCtrPty"), processor, Counterparty46__1.Counterparty46__1Builder.class, getOthrCtrPty());
			processRosetta(path.newSubPath("brkr"), processor, OrganisationIdentification15Choice__3.OrganisationIdentification15Choice__3Builder.class, getBrkr());
			processRosetta(path.newSubPath("submitgAgt"), processor, OrganisationIdentification15Choice__4.OrganisationIdentification15Choice__4Builder.class, getSubmitgAgt());
			processRosetta(path.newSubPath("clrMmb"), processor, PartyIdentification248Choice__3.PartyIdentification248Choice__3Builder.class, getClrMmb());
			processRosetta(path.newSubPath("bnfcry"), processor, PartyIdentification248Choice__4.PartyIdentification248Choice__4Builder.class, getBnfcry());
			processRosetta(path.newSubPath("nttyRspnsblForRpt"), processor, OrganisationIdentification15Choice__1.OrganisationIdentification15Choice__1Builder.class, getNttyRspnsblForRpt());
		}
		

		TradeCounterpartyReport20__1.TradeCounterpartyReport20__1Builder prune();
	}

	/*********************** Immutable Implementation of TradeCounterpartyReport20__1  ***********************/
	class TradeCounterpartyReport20__1Impl implements TradeCounterpartyReport20__1 {
		private final Counterparty45__1 rptgCtrPty;
		private final Counterparty46__1 othrCtrPty;
		private final OrganisationIdentification15Choice__3 brkr;
		private final OrganisationIdentification15Choice__4 submitgAgt;
		private final PartyIdentification248Choice__3 clrMmb;
		private final PartyIdentification248Choice__4 bnfcry;
		private final OrganisationIdentification15Choice__1 nttyRspnsblForRpt;
		
		protected TradeCounterpartyReport20__1Impl(TradeCounterpartyReport20__1.TradeCounterpartyReport20__1Builder builder) {
			this.rptgCtrPty = ofNullable(builder.getRptgCtrPty()).map(f->f.build()).orElse(null);
			this.othrCtrPty = ofNullable(builder.getOthrCtrPty()).map(f->f.build()).orElse(null);
			this.brkr = ofNullable(builder.getBrkr()).map(f->f.build()).orElse(null);
			this.submitgAgt = ofNullable(builder.getSubmitgAgt()).map(f->f.build()).orElse(null);
			this.clrMmb = ofNullable(builder.getClrMmb()).map(f->f.build()).orElse(null);
			this.bnfcry = ofNullable(builder.getBnfcry()).map(f->f.build()).orElse(null);
			this.nttyRspnsblForRpt = ofNullable(builder.getNttyRspnsblForRpt()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("rptgCtrPty")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("rptgCtrPty")
		public Counterparty45__1 getRptgCtrPty() {
			return rptgCtrPty;
		}
		
		@Override
		@RosettaAttribute("othrCtrPty")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("othrCtrPty")
		public Counterparty46__1 getOthrCtrPty() {
			return othrCtrPty;
		}
		
		@Override
		@RosettaAttribute("brkr")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("brkr")
		public OrganisationIdentification15Choice__3 getBrkr() {
			return brkr;
		}
		
		@Override
		@RosettaAttribute("submitgAgt")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("submitgAgt")
		public OrganisationIdentification15Choice__4 getSubmitgAgt() {
			return submitgAgt;
		}
		
		@Override
		@RosettaAttribute("clrMmb")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("clrMmb")
		public PartyIdentification248Choice__3 getClrMmb() {
			return clrMmb;
		}
		
		@Override
		@RosettaAttribute("bnfcry")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("bnfcry")
		public PartyIdentification248Choice__4 getBnfcry() {
			return bnfcry;
		}
		
		@Override
		@RosettaAttribute("nttyRspnsblForRpt")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("nttyRspnsblForRpt")
		public OrganisationIdentification15Choice__1 getNttyRspnsblForRpt() {
			return nttyRspnsblForRpt;
		}
		
		@Override
		public TradeCounterpartyReport20__1 build() {
			return this;
		}
		
		@Override
		public TradeCounterpartyReport20__1.TradeCounterpartyReport20__1Builder toBuilder() {
			TradeCounterpartyReport20__1.TradeCounterpartyReport20__1Builder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(TradeCounterpartyReport20__1.TradeCounterpartyReport20__1Builder builder) {
			ofNullable(getRptgCtrPty()).ifPresent(builder::setRptgCtrPty);
			ofNullable(getOthrCtrPty()).ifPresent(builder::setOthrCtrPty);
			ofNullable(getBrkr()).ifPresent(builder::setBrkr);
			ofNullable(getSubmitgAgt()).ifPresent(builder::setSubmitgAgt);
			ofNullable(getClrMmb()).ifPresent(builder::setClrMmb);
			ofNullable(getBnfcry()).ifPresent(builder::setBnfcry);
			ofNullable(getNttyRspnsblForRpt()).ifPresent(builder::setNttyRspnsblForRpt);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			TradeCounterpartyReport20__1 _that = getType().cast(o);
		
			if (!Objects.equals(rptgCtrPty, _that.getRptgCtrPty())) return false;
			if (!Objects.equals(othrCtrPty, _that.getOthrCtrPty())) return false;
			if (!Objects.equals(brkr, _that.getBrkr())) return false;
			if (!Objects.equals(submitgAgt, _that.getSubmitgAgt())) return false;
			if (!Objects.equals(clrMmb, _that.getClrMmb())) return false;
			if (!Objects.equals(bnfcry, _that.getBnfcry())) return false;
			if (!Objects.equals(nttyRspnsblForRpt, _that.getNttyRspnsblForRpt())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (rptgCtrPty != null ? rptgCtrPty.hashCode() : 0);
			_result = 31 * _result + (othrCtrPty != null ? othrCtrPty.hashCode() : 0);
			_result = 31 * _result + (brkr != null ? brkr.hashCode() : 0);
			_result = 31 * _result + (submitgAgt != null ? submitgAgt.hashCode() : 0);
			_result = 31 * _result + (clrMmb != null ? clrMmb.hashCode() : 0);
			_result = 31 * _result + (bnfcry != null ? bnfcry.hashCode() : 0);
			_result = 31 * _result + (nttyRspnsblForRpt != null ? nttyRspnsblForRpt.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "TradeCounterpartyReport20__1 {" +
				"rptgCtrPty=" + this.rptgCtrPty + ", " +
				"othrCtrPty=" + this.othrCtrPty + ", " +
				"brkr=" + this.brkr + ", " +
				"submitgAgt=" + this.submitgAgt + ", " +
				"clrMmb=" + this.clrMmb + ", " +
				"bnfcry=" + this.bnfcry + ", " +
				"nttyRspnsblForRpt=" + this.nttyRspnsblForRpt +
			'}';
		}
	}

	/*********************** Builder Implementation of TradeCounterpartyReport20__1  ***********************/
	class TradeCounterpartyReport20__1BuilderImpl implements TradeCounterpartyReport20__1.TradeCounterpartyReport20__1Builder {
	
		protected Counterparty45__1.Counterparty45__1Builder rptgCtrPty;
		protected Counterparty46__1.Counterparty46__1Builder othrCtrPty;
		protected OrganisationIdentification15Choice__3.OrganisationIdentification15Choice__3Builder brkr;
		protected OrganisationIdentification15Choice__4.OrganisationIdentification15Choice__4Builder submitgAgt;
		protected PartyIdentification248Choice__3.PartyIdentification248Choice__3Builder clrMmb;
		protected PartyIdentification248Choice__4.PartyIdentification248Choice__4Builder bnfcry;
		protected OrganisationIdentification15Choice__1.OrganisationIdentification15Choice__1Builder nttyRspnsblForRpt;
		
		@Override
		@RosettaAttribute("rptgCtrPty")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("rptgCtrPty")
		public Counterparty45__1.Counterparty45__1Builder getRptgCtrPty() {
			return rptgCtrPty;
		}
		
		@Override
		public Counterparty45__1.Counterparty45__1Builder getOrCreateRptgCtrPty() {
			Counterparty45__1.Counterparty45__1Builder result;
			if (rptgCtrPty!=null) {
				result = rptgCtrPty;
			}
			else {
				result = rptgCtrPty = Counterparty45__1.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("othrCtrPty")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("othrCtrPty")
		public Counterparty46__1.Counterparty46__1Builder getOthrCtrPty() {
			return othrCtrPty;
		}
		
		@Override
		public Counterparty46__1.Counterparty46__1Builder getOrCreateOthrCtrPty() {
			Counterparty46__1.Counterparty46__1Builder result;
			if (othrCtrPty!=null) {
				result = othrCtrPty;
			}
			else {
				result = othrCtrPty = Counterparty46__1.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("brkr")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("brkr")
		public OrganisationIdentification15Choice__3.OrganisationIdentification15Choice__3Builder getBrkr() {
			return brkr;
		}
		
		@Override
		public OrganisationIdentification15Choice__3.OrganisationIdentification15Choice__3Builder getOrCreateBrkr() {
			OrganisationIdentification15Choice__3.OrganisationIdentification15Choice__3Builder result;
			if (brkr!=null) {
				result = brkr;
			}
			else {
				result = brkr = OrganisationIdentification15Choice__3.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("submitgAgt")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("submitgAgt")
		public OrganisationIdentification15Choice__4.OrganisationIdentification15Choice__4Builder getSubmitgAgt() {
			return submitgAgt;
		}
		
		@Override
		public OrganisationIdentification15Choice__4.OrganisationIdentification15Choice__4Builder getOrCreateSubmitgAgt() {
			OrganisationIdentification15Choice__4.OrganisationIdentification15Choice__4Builder result;
			if (submitgAgt!=null) {
				result = submitgAgt;
			}
			else {
				result = submitgAgt = OrganisationIdentification15Choice__4.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("clrMmb")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("clrMmb")
		public PartyIdentification248Choice__3.PartyIdentification248Choice__3Builder getClrMmb() {
			return clrMmb;
		}
		
		@Override
		public PartyIdentification248Choice__3.PartyIdentification248Choice__3Builder getOrCreateClrMmb() {
			PartyIdentification248Choice__3.PartyIdentification248Choice__3Builder result;
			if (clrMmb!=null) {
				result = clrMmb;
			}
			else {
				result = clrMmb = PartyIdentification248Choice__3.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("bnfcry")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("bnfcry")
		public PartyIdentification248Choice__4.PartyIdentification248Choice__4Builder getBnfcry() {
			return bnfcry;
		}
		
		@Override
		public PartyIdentification248Choice__4.PartyIdentification248Choice__4Builder getOrCreateBnfcry() {
			PartyIdentification248Choice__4.PartyIdentification248Choice__4Builder result;
			if (bnfcry!=null) {
				result = bnfcry;
			}
			else {
				result = bnfcry = PartyIdentification248Choice__4.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("nttyRspnsblForRpt")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("nttyRspnsblForRpt")
		public OrganisationIdentification15Choice__1.OrganisationIdentification15Choice__1Builder getNttyRspnsblForRpt() {
			return nttyRspnsblForRpt;
		}
		
		@Override
		public OrganisationIdentification15Choice__1.OrganisationIdentification15Choice__1Builder getOrCreateNttyRspnsblForRpt() {
			OrganisationIdentification15Choice__1.OrganisationIdentification15Choice__1Builder result;
			if (nttyRspnsblForRpt!=null) {
				result = nttyRspnsblForRpt;
			}
			else {
				result = nttyRspnsblForRpt = OrganisationIdentification15Choice__1.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("rptgCtrPty")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("rptgCtrPty")
		@Override
		public TradeCounterpartyReport20__1.TradeCounterpartyReport20__1Builder setRptgCtrPty(Counterparty45__1 _rptgCtrPty) {
			this.rptgCtrPty = _rptgCtrPty == null ? null : _rptgCtrPty.toBuilder();
			return this;
		}
		
		@RosettaAttribute("othrCtrPty")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("othrCtrPty")
		@Override
		public TradeCounterpartyReport20__1.TradeCounterpartyReport20__1Builder setOthrCtrPty(Counterparty46__1 _othrCtrPty) {
			this.othrCtrPty = _othrCtrPty == null ? null : _othrCtrPty.toBuilder();
			return this;
		}
		
		@RosettaAttribute("brkr")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("brkr")
		@Override
		public TradeCounterpartyReport20__1.TradeCounterpartyReport20__1Builder setBrkr(OrganisationIdentification15Choice__3 _brkr) {
			this.brkr = _brkr == null ? null : _brkr.toBuilder();
			return this;
		}
		
		@RosettaAttribute("submitgAgt")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("submitgAgt")
		@Override
		public TradeCounterpartyReport20__1.TradeCounterpartyReport20__1Builder setSubmitgAgt(OrganisationIdentification15Choice__4 _submitgAgt) {
			this.submitgAgt = _submitgAgt == null ? null : _submitgAgt.toBuilder();
			return this;
		}
		
		@RosettaAttribute("clrMmb")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("clrMmb")
		@Override
		public TradeCounterpartyReport20__1.TradeCounterpartyReport20__1Builder setClrMmb(PartyIdentification248Choice__3 _clrMmb) {
			this.clrMmb = _clrMmb == null ? null : _clrMmb.toBuilder();
			return this;
		}
		
		@RosettaAttribute("bnfcry")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("bnfcry")
		@Override
		public TradeCounterpartyReport20__1.TradeCounterpartyReport20__1Builder setBnfcry(PartyIdentification248Choice__4 _bnfcry) {
			this.bnfcry = _bnfcry == null ? null : _bnfcry.toBuilder();
			return this;
		}
		
		@RosettaAttribute("nttyRspnsblForRpt")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("nttyRspnsblForRpt")
		@Override
		public TradeCounterpartyReport20__1.TradeCounterpartyReport20__1Builder setNttyRspnsblForRpt(OrganisationIdentification15Choice__1 _nttyRspnsblForRpt) {
			this.nttyRspnsblForRpt = _nttyRspnsblForRpt == null ? null : _nttyRspnsblForRpt.toBuilder();
			return this;
		}
		
		@Override
		public TradeCounterpartyReport20__1 build() {
			return new TradeCounterpartyReport20__1.TradeCounterpartyReport20__1Impl(this);
		}
		
		@Override
		public TradeCounterpartyReport20__1.TradeCounterpartyReport20__1Builder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public TradeCounterpartyReport20__1.TradeCounterpartyReport20__1Builder prune() {
			if (rptgCtrPty!=null && !rptgCtrPty.prune().hasData()) rptgCtrPty = null;
			if (othrCtrPty!=null && !othrCtrPty.prune().hasData()) othrCtrPty = null;
			if (brkr!=null && !brkr.prune().hasData()) brkr = null;
			if (submitgAgt!=null && !submitgAgt.prune().hasData()) submitgAgt = null;
			if (clrMmb!=null && !clrMmb.prune().hasData()) clrMmb = null;
			if (bnfcry!=null && !bnfcry.prune().hasData()) bnfcry = null;
			if (nttyRspnsblForRpt!=null && !nttyRspnsblForRpt.prune().hasData()) nttyRspnsblForRpt = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getRptgCtrPty()!=null && getRptgCtrPty().hasData()) return true;
			if (getOthrCtrPty()!=null && getOthrCtrPty().hasData()) return true;
			if (getBrkr()!=null && getBrkr().hasData()) return true;
			if (getSubmitgAgt()!=null && getSubmitgAgt().hasData()) return true;
			if (getClrMmb()!=null && getClrMmb().hasData()) return true;
			if (getBnfcry()!=null && getBnfcry().hasData()) return true;
			if (getNttyRspnsblForRpt()!=null && getNttyRspnsblForRpt().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public TradeCounterpartyReport20__1.TradeCounterpartyReport20__1Builder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			TradeCounterpartyReport20__1.TradeCounterpartyReport20__1Builder o = (TradeCounterpartyReport20__1.TradeCounterpartyReport20__1Builder) other;
			
			merger.mergeRosetta(getRptgCtrPty(), o.getRptgCtrPty(), this::setRptgCtrPty);
			merger.mergeRosetta(getOthrCtrPty(), o.getOthrCtrPty(), this::setOthrCtrPty);
			merger.mergeRosetta(getBrkr(), o.getBrkr(), this::setBrkr);
			merger.mergeRosetta(getSubmitgAgt(), o.getSubmitgAgt(), this::setSubmitgAgt);
			merger.mergeRosetta(getClrMmb(), o.getClrMmb(), this::setClrMmb);
			merger.mergeRosetta(getBnfcry(), o.getBnfcry(), this::setBnfcry);
			merger.mergeRosetta(getNttyRspnsblForRpt(), o.getNttyRspnsblForRpt(), this::setNttyRspnsblForRpt);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			TradeCounterpartyReport20__1 _that = getType().cast(o);
		
			if (!Objects.equals(rptgCtrPty, _that.getRptgCtrPty())) return false;
			if (!Objects.equals(othrCtrPty, _that.getOthrCtrPty())) return false;
			if (!Objects.equals(brkr, _that.getBrkr())) return false;
			if (!Objects.equals(submitgAgt, _that.getSubmitgAgt())) return false;
			if (!Objects.equals(clrMmb, _that.getClrMmb())) return false;
			if (!Objects.equals(bnfcry, _that.getBnfcry())) return false;
			if (!Objects.equals(nttyRspnsblForRpt, _that.getNttyRspnsblForRpt())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (rptgCtrPty != null ? rptgCtrPty.hashCode() : 0);
			_result = 31 * _result + (othrCtrPty != null ? othrCtrPty.hashCode() : 0);
			_result = 31 * _result + (brkr != null ? brkr.hashCode() : 0);
			_result = 31 * _result + (submitgAgt != null ? submitgAgt.hashCode() : 0);
			_result = 31 * _result + (clrMmb != null ? clrMmb.hashCode() : 0);
			_result = 31 * _result + (bnfcry != null ? bnfcry.hashCode() : 0);
			_result = 31 * _result + (nttyRspnsblForRpt != null ? nttyRspnsblForRpt.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "TradeCounterpartyReport20__1Builder {" +
				"rptgCtrPty=" + this.rptgCtrPty + ", " +
				"othrCtrPty=" + this.othrCtrPty + ", " +
				"brkr=" + this.brkr + ", " +
				"submitgAgt=" + this.submitgAgt + ", " +
				"clrMmb=" + this.clrMmb + ", " +
				"bnfcry=" + this.bnfcry + ", " +
				"nttyRspnsblForRpt=" + this.nttyRspnsblForRpt +
			'}';
		}
	}
}

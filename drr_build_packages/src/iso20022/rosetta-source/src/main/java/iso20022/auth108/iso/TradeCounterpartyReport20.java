package iso20022.auth108.iso;

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
import iso20022.auth108.iso.meta.TradeCounterpartyReport20Meta;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * Information related to parties in the contract.
 * @version ${project.version}
 */
@RosettaDataType(value="TradeCounterpartyReport20", builder=TradeCounterpartyReport20.TradeCounterpartyReport20BuilderImpl.class, version="${project.version}")
@RuneDataType(value="TradeCounterpartyReport20", model="iso20022", builder=TradeCounterpartyReport20.TradeCounterpartyReport20BuilderImpl.class, version="${project.version}")
public interface TradeCounterpartyReport20 extends RosettaModelObject {

	TradeCounterpartyReport20Meta metaData = new TradeCounterpartyReport20Meta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Identification of the counterparty to a derivative transaction who is fulfilling its reporting obligation in the present report.
	 */
	Counterparty45 getRptgCtrPty();
	/**
	 * Identification of the other counterparty to a derivative transaction.
	 */
	Counterparty46 getOthrCtrPty();
	/**
	 * Identification of the entity [party] acting as an intermediary which [who] arranges the transaction for the reporting counterparty (“arranging broker”).
	 */
	OrganisationIdentification15Choice getBrkr();
	/**
	 * Identification of the party that ultimately submits the report to the trade repository.
	 */
	OrganisationIdentification15Choice getSubmitgAgt();
	/**
	 * Identifies the clearing member through which a derivative transaction is cleared at a central counterparty (CCP).  The element applies to transactions under the agency clearing model and the principal clearing model.
	 */
	PartyIdentification248Choice getClrMmb();
	/**
	 * Identification of the beneficiary of a derivative transaction, that is a party that is subject to the rights and obligations arising from the contract.      Usage: In case of two occurances of beneficiary, the first iteration should always be the beneficiary 1 of the counterparty 1 and the second iteration is the beneficiary 2 of the counterparty 2. In case of single occurance of Beneficiary, RelationshipRecord should be provided.
	 */
	List<? extends PartyIdentification248Choice> getBnfcry();
	/**
	 * According to jurisdictional requirements, identification of the entity with the legal obligation or responsibility to report.
	 */
	OrganisationIdentification15Choice getNttyRspnsblForRpt();
	/**
	 * Identification of the entity that executed the transaction on behalf of the counterparty, and binds the counterparty to the terms of the transaction, but is not a broker.    Usage: In case of two occurances of ExecutionAgent, the first iteration should always be the execution agent 1 of the counterparty 1 and the second iteration is the execution agent 2 of the counterparty 2. In case of single occurance of ExecutionAgent, RelationshipRecord should be provided.
	 */
	List<? extends OrganisationIdentification15Choice> getExctnAgt();
	/**
	 * Specifies the relationship record between two parties part of the transaction.
	 */
	List<? extends TradeCounterpartyRelationshipRecord1> getRltshRcrd();

	/*********************** Build Methods  ***********************/
	TradeCounterpartyReport20 build();
	
	TradeCounterpartyReport20.TradeCounterpartyReport20Builder toBuilder();
	
	static TradeCounterpartyReport20.TradeCounterpartyReport20Builder builder() {
		return new TradeCounterpartyReport20.TradeCounterpartyReport20BuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends TradeCounterpartyReport20> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends TradeCounterpartyReport20> getType() {
		return TradeCounterpartyReport20.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("rptgCtrPty"), processor, Counterparty45.class, getRptgCtrPty());
		processRosetta(path.newSubPath("othrCtrPty"), processor, Counterparty46.class, getOthrCtrPty());
		processRosetta(path.newSubPath("brkr"), processor, OrganisationIdentification15Choice.class, getBrkr());
		processRosetta(path.newSubPath("submitgAgt"), processor, OrganisationIdentification15Choice.class, getSubmitgAgt());
		processRosetta(path.newSubPath("clrMmb"), processor, PartyIdentification248Choice.class, getClrMmb());
		processRosetta(path.newSubPath("bnfcry"), processor, PartyIdentification248Choice.class, getBnfcry());
		processRosetta(path.newSubPath("nttyRspnsblForRpt"), processor, OrganisationIdentification15Choice.class, getNttyRspnsblForRpt());
		processRosetta(path.newSubPath("exctnAgt"), processor, OrganisationIdentification15Choice.class, getExctnAgt());
		processRosetta(path.newSubPath("rltshRcrd"), processor, TradeCounterpartyRelationshipRecord1.class, getRltshRcrd());
	}
	

	/*********************** Builder Interface  ***********************/
	interface TradeCounterpartyReport20Builder extends TradeCounterpartyReport20, RosettaModelObjectBuilder {
		Counterparty45.Counterparty45Builder getOrCreateRptgCtrPty();
		@Override
		Counterparty45.Counterparty45Builder getRptgCtrPty();
		Counterparty46.Counterparty46Builder getOrCreateOthrCtrPty();
		@Override
		Counterparty46.Counterparty46Builder getOthrCtrPty();
		OrganisationIdentification15Choice.OrganisationIdentification15ChoiceBuilder getOrCreateBrkr();
		@Override
		OrganisationIdentification15Choice.OrganisationIdentification15ChoiceBuilder getBrkr();
		OrganisationIdentification15Choice.OrganisationIdentification15ChoiceBuilder getOrCreateSubmitgAgt();
		@Override
		OrganisationIdentification15Choice.OrganisationIdentification15ChoiceBuilder getSubmitgAgt();
		PartyIdentification248Choice.PartyIdentification248ChoiceBuilder getOrCreateClrMmb();
		@Override
		PartyIdentification248Choice.PartyIdentification248ChoiceBuilder getClrMmb();
		PartyIdentification248Choice.PartyIdentification248ChoiceBuilder getOrCreateBnfcry(int index);
		@Override
		List<? extends PartyIdentification248Choice.PartyIdentification248ChoiceBuilder> getBnfcry();
		OrganisationIdentification15Choice.OrganisationIdentification15ChoiceBuilder getOrCreateNttyRspnsblForRpt();
		@Override
		OrganisationIdentification15Choice.OrganisationIdentification15ChoiceBuilder getNttyRspnsblForRpt();
		OrganisationIdentification15Choice.OrganisationIdentification15ChoiceBuilder getOrCreateExctnAgt(int index);
		@Override
		List<? extends OrganisationIdentification15Choice.OrganisationIdentification15ChoiceBuilder> getExctnAgt();
		TradeCounterpartyRelationshipRecord1.TradeCounterpartyRelationshipRecord1Builder getOrCreateRltshRcrd(int index);
		@Override
		List<? extends TradeCounterpartyRelationshipRecord1.TradeCounterpartyRelationshipRecord1Builder> getRltshRcrd();
		TradeCounterpartyReport20.TradeCounterpartyReport20Builder setRptgCtrPty(Counterparty45 rptgCtrPty);
		TradeCounterpartyReport20.TradeCounterpartyReport20Builder setOthrCtrPty(Counterparty46 othrCtrPty);
		TradeCounterpartyReport20.TradeCounterpartyReport20Builder setBrkr(OrganisationIdentification15Choice brkr);
		TradeCounterpartyReport20.TradeCounterpartyReport20Builder setSubmitgAgt(OrganisationIdentification15Choice submitgAgt);
		TradeCounterpartyReport20.TradeCounterpartyReport20Builder setClrMmb(PartyIdentification248Choice clrMmb);
		TradeCounterpartyReport20.TradeCounterpartyReport20Builder addBnfcry(PartyIdentification248Choice bnfcry);
		TradeCounterpartyReport20.TradeCounterpartyReport20Builder addBnfcry(PartyIdentification248Choice bnfcry, int idx);
		TradeCounterpartyReport20.TradeCounterpartyReport20Builder addBnfcry(List<? extends PartyIdentification248Choice> bnfcry);
		TradeCounterpartyReport20.TradeCounterpartyReport20Builder setBnfcry(List<? extends PartyIdentification248Choice> bnfcry);
		TradeCounterpartyReport20.TradeCounterpartyReport20Builder setNttyRspnsblForRpt(OrganisationIdentification15Choice nttyRspnsblForRpt);
		TradeCounterpartyReport20.TradeCounterpartyReport20Builder addExctnAgt(OrganisationIdentification15Choice exctnAgt);
		TradeCounterpartyReport20.TradeCounterpartyReport20Builder addExctnAgt(OrganisationIdentification15Choice exctnAgt, int idx);
		TradeCounterpartyReport20.TradeCounterpartyReport20Builder addExctnAgt(List<? extends OrganisationIdentification15Choice> exctnAgt);
		TradeCounterpartyReport20.TradeCounterpartyReport20Builder setExctnAgt(List<? extends OrganisationIdentification15Choice> exctnAgt);
		TradeCounterpartyReport20.TradeCounterpartyReport20Builder addRltshRcrd(TradeCounterpartyRelationshipRecord1 rltshRcrd);
		TradeCounterpartyReport20.TradeCounterpartyReport20Builder addRltshRcrd(TradeCounterpartyRelationshipRecord1 rltshRcrd, int idx);
		TradeCounterpartyReport20.TradeCounterpartyReport20Builder addRltshRcrd(List<? extends TradeCounterpartyRelationshipRecord1> rltshRcrd);
		TradeCounterpartyReport20.TradeCounterpartyReport20Builder setRltshRcrd(List<? extends TradeCounterpartyRelationshipRecord1> rltshRcrd);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("rptgCtrPty"), processor, Counterparty45.Counterparty45Builder.class, getRptgCtrPty());
			processRosetta(path.newSubPath("othrCtrPty"), processor, Counterparty46.Counterparty46Builder.class, getOthrCtrPty());
			processRosetta(path.newSubPath("brkr"), processor, OrganisationIdentification15Choice.OrganisationIdentification15ChoiceBuilder.class, getBrkr());
			processRosetta(path.newSubPath("submitgAgt"), processor, OrganisationIdentification15Choice.OrganisationIdentification15ChoiceBuilder.class, getSubmitgAgt());
			processRosetta(path.newSubPath("clrMmb"), processor, PartyIdentification248Choice.PartyIdentification248ChoiceBuilder.class, getClrMmb());
			processRosetta(path.newSubPath("bnfcry"), processor, PartyIdentification248Choice.PartyIdentification248ChoiceBuilder.class, getBnfcry());
			processRosetta(path.newSubPath("nttyRspnsblForRpt"), processor, OrganisationIdentification15Choice.OrganisationIdentification15ChoiceBuilder.class, getNttyRspnsblForRpt());
			processRosetta(path.newSubPath("exctnAgt"), processor, OrganisationIdentification15Choice.OrganisationIdentification15ChoiceBuilder.class, getExctnAgt());
			processRosetta(path.newSubPath("rltshRcrd"), processor, TradeCounterpartyRelationshipRecord1.TradeCounterpartyRelationshipRecord1Builder.class, getRltshRcrd());
		}
		

		TradeCounterpartyReport20.TradeCounterpartyReport20Builder prune();
	}

	/*********************** Immutable Implementation of TradeCounterpartyReport20  ***********************/
	class TradeCounterpartyReport20Impl implements TradeCounterpartyReport20 {
		private final Counterparty45 rptgCtrPty;
		private final Counterparty46 othrCtrPty;
		private final OrganisationIdentification15Choice brkr;
		private final OrganisationIdentification15Choice submitgAgt;
		private final PartyIdentification248Choice clrMmb;
		private final List<? extends PartyIdentification248Choice> bnfcry;
		private final OrganisationIdentification15Choice nttyRspnsblForRpt;
		private final List<? extends OrganisationIdentification15Choice> exctnAgt;
		private final List<? extends TradeCounterpartyRelationshipRecord1> rltshRcrd;
		
		protected TradeCounterpartyReport20Impl(TradeCounterpartyReport20.TradeCounterpartyReport20Builder builder) {
			this.rptgCtrPty = ofNullable(builder.getRptgCtrPty()).map(f->f.build()).orElse(null);
			this.othrCtrPty = ofNullable(builder.getOthrCtrPty()).map(f->f.build()).orElse(null);
			this.brkr = ofNullable(builder.getBrkr()).map(f->f.build()).orElse(null);
			this.submitgAgt = ofNullable(builder.getSubmitgAgt()).map(f->f.build()).orElse(null);
			this.clrMmb = ofNullable(builder.getClrMmb()).map(f->f.build()).orElse(null);
			this.bnfcry = ofNullable(builder.getBnfcry()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.nttyRspnsblForRpt = ofNullable(builder.getNttyRspnsblForRpt()).map(f->f.build()).orElse(null);
			this.exctnAgt = ofNullable(builder.getExctnAgt()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.rltshRcrd = ofNullable(builder.getRltshRcrd()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		@RosettaAttribute("rptgCtrPty")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("rptgCtrPty")
		public Counterparty45 getRptgCtrPty() {
			return rptgCtrPty;
		}
		
		@Override
		@RosettaAttribute("othrCtrPty")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("othrCtrPty")
		public Counterparty46 getOthrCtrPty() {
			return othrCtrPty;
		}
		
		@Override
		@RosettaAttribute("brkr")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("brkr")
		public OrganisationIdentification15Choice getBrkr() {
			return brkr;
		}
		
		@Override
		@RosettaAttribute("submitgAgt")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("submitgAgt")
		public OrganisationIdentification15Choice getSubmitgAgt() {
			return submitgAgt;
		}
		
		@Override
		@RosettaAttribute("clrMmb")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("clrMmb")
		public PartyIdentification248Choice getClrMmb() {
			return clrMmb;
		}
		
		@Override
		@RosettaAttribute("bnfcry")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("bnfcry")
		public List<? extends PartyIdentification248Choice> getBnfcry() {
			return bnfcry;
		}
		
		@Override
		@RosettaAttribute("nttyRspnsblForRpt")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("nttyRspnsblForRpt")
		public OrganisationIdentification15Choice getNttyRspnsblForRpt() {
			return nttyRspnsblForRpt;
		}
		
		@Override
		@RosettaAttribute("exctnAgt")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("exctnAgt")
		public List<? extends OrganisationIdentification15Choice> getExctnAgt() {
			return exctnAgt;
		}
		
		@Override
		@RosettaAttribute("rltshRcrd")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("rltshRcrd")
		public List<? extends TradeCounterpartyRelationshipRecord1> getRltshRcrd() {
			return rltshRcrd;
		}
		
		@Override
		public TradeCounterpartyReport20 build() {
			return this;
		}
		
		@Override
		public TradeCounterpartyReport20.TradeCounterpartyReport20Builder toBuilder() {
			TradeCounterpartyReport20.TradeCounterpartyReport20Builder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(TradeCounterpartyReport20.TradeCounterpartyReport20Builder builder) {
			ofNullable(getRptgCtrPty()).ifPresent(builder::setRptgCtrPty);
			ofNullable(getOthrCtrPty()).ifPresent(builder::setOthrCtrPty);
			ofNullable(getBrkr()).ifPresent(builder::setBrkr);
			ofNullable(getSubmitgAgt()).ifPresent(builder::setSubmitgAgt);
			ofNullable(getClrMmb()).ifPresent(builder::setClrMmb);
			ofNullable(getBnfcry()).ifPresent(builder::setBnfcry);
			ofNullable(getNttyRspnsblForRpt()).ifPresent(builder::setNttyRspnsblForRpt);
			ofNullable(getExctnAgt()).ifPresent(builder::setExctnAgt);
			ofNullable(getRltshRcrd()).ifPresent(builder::setRltshRcrd);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			TradeCounterpartyReport20 _that = getType().cast(o);
		
			if (!Objects.equals(rptgCtrPty, _that.getRptgCtrPty())) return false;
			if (!Objects.equals(othrCtrPty, _that.getOthrCtrPty())) return false;
			if (!Objects.equals(brkr, _that.getBrkr())) return false;
			if (!Objects.equals(submitgAgt, _that.getSubmitgAgt())) return false;
			if (!Objects.equals(clrMmb, _that.getClrMmb())) return false;
			if (!ListEquals.listEquals(bnfcry, _that.getBnfcry())) return false;
			if (!Objects.equals(nttyRspnsblForRpt, _that.getNttyRspnsblForRpt())) return false;
			if (!ListEquals.listEquals(exctnAgt, _that.getExctnAgt())) return false;
			if (!ListEquals.listEquals(rltshRcrd, _that.getRltshRcrd())) return false;
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
			_result = 31 * _result + (exctnAgt != null ? exctnAgt.hashCode() : 0);
			_result = 31 * _result + (rltshRcrd != null ? rltshRcrd.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "TradeCounterpartyReport20 {" +
				"rptgCtrPty=" + this.rptgCtrPty + ", " +
				"othrCtrPty=" + this.othrCtrPty + ", " +
				"brkr=" + this.brkr + ", " +
				"submitgAgt=" + this.submitgAgt + ", " +
				"clrMmb=" + this.clrMmb + ", " +
				"bnfcry=" + this.bnfcry + ", " +
				"nttyRspnsblForRpt=" + this.nttyRspnsblForRpt + ", " +
				"exctnAgt=" + this.exctnAgt + ", " +
				"rltshRcrd=" + this.rltshRcrd +
			'}';
		}
	}

	/*********************** Builder Implementation of TradeCounterpartyReport20  ***********************/
	class TradeCounterpartyReport20BuilderImpl implements TradeCounterpartyReport20.TradeCounterpartyReport20Builder {
	
		protected Counterparty45.Counterparty45Builder rptgCtrPty;
		protected Counterparty46.Counterparty46Builder othrCtrPty;
		protected OrganisationIdentification15Choice.OrganisationIdentification15ChoiceBuilder brkr;
		protected OrganisationIdentification15Choice.OrganisationIdentification15ChoiceBuilder submitgAgt;
		protected PartyIdentification248Choice.PartyIdentification248ChoiceBuilder clrMmb;
		protected List<PartyIdentification248Choice.PartyIdentification248ChoiceBuilder> bnfcry = new ArrayList<>();
		protected OrganisationIdentification15Choice.OrganisationIdentification15ChoiceBuilder nttyRspnsblForRpt;
		protected List<OrganisationIdentification15Choice.OrganisationIdentification15ChoiceBuilder> exctnAgt = new ArrayList<>();
		protected List<TradeCounterpartyRelationshipRecord1.TradeCounterpartyRelationshipRecord1Builder> rltshRcrd = new ArrayList<>();
		
		@Override
		@RosettaAttribute("rptgCtrPty")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("rptgCtrPty")
		public Counterparty45.Counterparty45Builder getRptgCtrPty() {
			return rptgCtrPty;
		}
		
		@Override
		public Counterparty45.Counterparty45Builder getOrCreateRptgCtrPty() {
			Counterparty45.Counterparty45Builder result;
			if (rptgCtrPty!=null) {
				result = rptgCtrPty;
			}
			else {
				result = rptgCtrPty = Counterparty45.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("othrCtrPty")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("othrCtrPty")
		public Counterparty46.Counterparty46Builder getOthrCtrPty() {
			return othrCtrPty;
		}
		
		@Override
		public Counterparty46.Counterparty46Builder getOrCreateOthrCtrPty() {
			Counterparty46.Counterparty46Builder result;
			if (othrCtrPty!=null) {
				result = othrCtrPty;
			}
			else {
				result = othrCtrPty = Counterparty46.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("brkr")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("brkr")
		public OrganisationIdentification15Choice.OrganisationIdentification15ChoiceBuilder getBrkr() {
			return brkr;
		}
		
		@Override
		public OrganisationIdentification15Choice.OrganisationIdentification15ChoiceBuilder getOrCreateBrkr() {
			OrganisationIdentification15Choice.OrganisationIdentification15ChoiceBuilder result;
			if (brkr!=null) {
				result = brkr;
			}
			else {
				result = brkr = OrganisationIdentification15Choice.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("submitgAgt")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("submitgAgt")
		public OrganisationIdentification15Choice.OrganisationIdentification15ChoiceBuilder getSubmitgAgt() {
			return submitgAgt;
		}
		
		@Override
		public OrganisationIdentification15Choice.OrganisationIdentification15ChoiceBuilder getOrCreateSubmitgAgt() {
			OrganisationIdentification15Choice.OrganisationIdentification15ChoiceBuilder result;
			if (submitgAgt!=null) {
				result = submitgAgt;
			}
			else {
				result = submitgAgt = OrganisationIdentification15Choice.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("clrMmb")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("clrMmb")
		public PartyIdentification248Choice.PartyIdentification248ChoiceBuilder getClrMmb() {
			return clrMmb;
		}
		
		@Override
		public PartyIdentification248Choice.PartyIdentification248ChoiceBuilder getOrCreateClrMmb() {
			PartyIdentification248Choice.PartyIdentification248ChoiceBuilder result;
			if (clrMmb!=null) {
				result = clrMmb;
			}
			else {
				result = clrMmb = PartyIdentification248Choice.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("bnfcry")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("bnfcry")
		public List<? extends PartyIdentification248Choice.PartyIdentification248ChoiceBuilder> getBnfcry() {
			return bnfcry;
		}
		
		@Override
		public PartyIdentification248Choice.PartyIdentification248ChoiceBuilder getOrCreateBnfcry(int index) {
			if (bnfcry==null) {
				this.bnfcry = new ArrayList<>();
			}
			return getIndex(bnfcry, index, () -> {
						PartyIdentification248Choice.PartyIdentification248ChoiceBuilder newBnfcry = PartyIdentification248Choice.builder();
						return newBnfcry;
					});
		}
		
		@Override
		@RosettaAttribute("nttyRspnsblForRpt")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("nttyRspnsblForRpt")
		public OrganisationIdentification15Choice.OrganisationIdentification15ChoiceBuilder getNttyRspnsblForRpt() {
			return nttyRspnsblForRpt;
		}
		
		@Override
		public OrganisationIdentification15Choice.OrganisationIdentification15ChoiceBuilder getOrCreateNttyRspnsblForRpt() {
			OrganisationIdentification15Choice.OrganisationIdentification15ChoiceBuilder result;
			if (nttyRspnsblForRpt!=null) {
				result = nttyRspnsblForRpt;
			}
			else {
				result = nttyRspnsblForRpt = OrganisationIdentification15Choice.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("exctnAgt")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("exctnAgt")
		public List<? extends OrganisationIdentification15Choice.OrganisationIdentification15ChoiceBuilder> getExctnAgt() {
			return exctnAgt;
		}
		
		@Override
		public OrganisationIdentification15Choice.OrganisationIdentification15ChoiceBuilder getOrCreateExctnAgt(int index) {
			if (exctnAgt==null) {
				this.exctnAgt = new ArrayList<>();
			}
			return getIndex(exctnAgt, index, () -> {
						OrganisationIdentification15Choice.OrganisationIdentification15ChoiceBuilder newExctnAgt = OrganisationIdentification15Choice.builder();
						return newExctnAgt;
					});
		}
		
		@Override
		@RosettaAttribute("rltshRcrd")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("rltshRcrd")
		public List<? extends TradeCounterpartyRelationshipRecord1.TradeCounterpartyRelationshipRecord1Builder> getRltshRcrd() {
			return rltshRcrd;
		}
		
		@Override
		public TradeCounterpartyRelationshipRecord1.TradeCounterpartyRelationshipRecord1Builder getOrCreateRltshRcrd(int index) {
			if (rltshRcrd==null) {
				this.rltshRcrd = new ArrayList<>();
			}
			return getIndex(rltshRcrd, index, () -> {
						TradeCounterpartyRelationshipRecord1.TradeCounterpartyRelationshipRecord1Builder newRltshRcrd = TradeCounterpartyRelationshipRecord1.builder();
						return newRltshRcrd;
					});
		}
		
		@RosettaAttribute("rptgCtrPty")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("rptgCtrPty")
		@Override
		public TradeCounterpartyReport20.TradeCounterpartyReport20Builder setRptgCtrPty(Counterparty45 _rptgCtrPty) {
			this.rptgCtrPty = _rptgCtrPty == null ? null : _rptgCtrPty.toBuilder();
			return this;
		}
		
		@RosettaAttribute("othrCtrPty")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("othrCtrPty")
		@Override
		public TradeCounterpartyReport20.TradeCounterpartyReport20Builder setOthrCtrPty(Counterparty46 _othrCtrPty) {
			this.othrCtrPty = _othrCtrPty == null ? null : _othrCtrPty.toBuilder();
			return this;
		}
		
		@RosettaAttribute("brkr")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("brkr")
		@Override
		public TradeCounterpartyReport20.TradeCounterpartyReport20Builder setBrkr(OrganisationIdentification15Choice _brkr) {
			this.brkr = _brkr == null ? null : _brkr.toBuilder();
			return this;
		}
		
		@RosettaAttribute("submitgAgt")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("submitgAgt")
		@Override
		public TradeCounterpartyReport20.TradeCounterpartyReport20Builder setSubmitgAgt(OrganisationIdentification15Choice _submitgAgt) {
			this.submitgAgt = _submitgAgt == null ? null : _submitgAgt.toBuilder();
			return this;
		}
		
		@RosettaAttribute("clrMmb")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("clrMmb")
		@Override
		public TradeCounterpartyReport20.TradeCounterpartyReport20Builder setClrMmb(PartyIdentification248Choice _clrMmb) {
			this.clrMmb = _clrMmb == null ? null : _clrMmb.toBuilder();
			return this;
		}
		
		@RosettaAttribute("bnfcry")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("bnfcry")
		@Override
		public TradeCounterpartyReport20.TradeCounterpartyReport20Builder addBnfcry(PartyIdentification248Choice _bnfcry) {
			if (_bnfcry != null) {
				this.bnfcry.add(_bnfcry.toBuilder());
			}
			return this;
		}
		
		@Override
		public TradeCounterpartyReport20.TradeCounterpartyReport20Builder addBnfcry(PartyIdentification248Choice _bnfcry, int idx) {
			getIndex(this.bnfcry, idx, () -> _bnfcry.toBuilder());
			return this;
		}
		
		@Override
		public TradeCounterpartyReport20.TradeCounterpartyReport20Builder addBnfcry(List<? extends PartyIdentification248Choice> bnfcrys) {
			if (bnfcrys != null) {
				for (final PartyIdentification248Choice toAdd : bnfcrys) {
					this.bnfcry.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("bnfcry")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("bnfcry")
		@Override
		public TradeCounterpartyReport20.TradeCounterpartyReport20Builder setBnfcry(List<? extends PartyIdentification248Choice> bnfcrys) {
			if (bnfcrys == null) {
				this.bnfcry = new ArrayList<>();
			} else {
				this.bnfcry = bnfcrys.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("nttyRspnsblForRpt")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("nttyRspnsblForRpt")
		@Override
		public TradeCounterpartyReport20.TradeCounterpartyReport20Builder setNttyRspnsblForRpt(OrganisationIdentification15Choice _nttyRspnsblForRpt) {
			this.nttyRspnsblForRpt = _nttyRspnsblForRpt == null ? null : _nttyRspnsblForRpt.toBuilder();
			return this;
		}
		
		@RosettaAttribute("exctnAgt")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("exctnAgt")
		@Override
		public TradeCounterpartyReport20.TradeCounterpartyReport20Builder addExctnAgt(OrganisationIdentification15Choice _exctnAgt) {
			if (_exctnAgt != null) {
				this.exctnAgt.add(_exctnAgt.toBuilder());
			}
			return this;
		}
		
		@Override
		public TradeCounterpartyReport20.TradeCounterpartyReport20Builder addExctnAgt(OrganisationIdentification15Choice _exctnAgt, int idx) {
			getIndex(this.exctnAgt, idx, () -> _exctnAgt.toBuilder());
			return this;
		}
		
		@Override
		public TradeCounterpartyReport20.TradeCounterpartyReport20Builder addExctnAgt(List<? extends OrganisationIdentification15Choice> exctnAgts) {
			if (exctnAgts != null) {
				for (final OrganisationIdentification15Choice toAdd : exctnAgts) {
					this.exctnAgt.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("exctnAgt")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("exctnAgt")
		@Override
		public TradeCounterpartyReport20.TradeCounterpartyReport20Builder setExctnAgt(List<? extends OrganisationIdentification15Choice> exctnAgts) {
			if (exctnAgts == null) {
				this.exctnAgt = new ArrayList<>();
			} else {
				this.exctnAgt = exctnAgts.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("rltshRcrd")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("rltshRcrd")
		@Override
		public TradeCounterpartyReport20.TradeCounterpartyReport20Builder addRltshRcrd(TradeCounterpartyRelationshipRecord1 _rltshRcrd) {
			if (_rltshRcrd != null) {
				this.rltshRcrd.add(_rltshRcrd.toBuilder());
			}
			return this;
		}
		
		@Override
		public TradeCounterpartyReport20.TradeCounterpartyReport20Builder addRltshRcrd(TradeCounterpartyRelationshipRecord1 _rltshRcrd, int idx) {
			getIndex(this.rltshRcrd, idx, () -> _rltshRcrd.toBuilder());
			return this;
		}
		
		@Override
		public TradeCounterpartyReport20.TradeCounterpartyReport20Builder addRltshRcrd(List<? extends TradeCounterpartyRelationshipRecord1> rltshRcrds) {
			if (rltshRcrds != null) {
				for (final TradeCounterpartyRelationshipRecord1 toAdd : rltshRcrds) {
					this.rltshRcrd.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("rltshRcrd")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("rltshRcrd")
		@Override
		public TradeCounterpartyReport20.TradeCounterpartyReport20Builder setRltshRcrd(List<? extends TradeCounterpartyRelationshipRecord1> rltshRcrds) {
			if (rltshRcrds == null) {
				this.rltshRcrd = new ArrayList<>();
			} else {
				this.rltshRcrd = rltshRcrds.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		public TradeCounterpartyReport20 build() {
			return new TradeCounterpartyReport20.TradeCounterpartyReport20Impl(this);
		}
		
		@Override
		public TradeCounterpartyReport20.TradeCounterpartyReport20Builder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public TradeCounterpartyReport20.TradeCounterpartyReport20Builder prune() {
			if (rptgCtrPty!=null && !rptgCtrPty.prune().hasData()) rptgCtrPty = null;
			if (othrCtrPty!=null && !othrCtrPty.prune().hasData()) othrCtrPty = null;
			if (brkr!=null && !brkr.prune().hasData()) brkr = null;
			if (submitgAgt!=null && !submitgAgt.prune().hasData()) submitgAgt = null;
			if (clrMmb!=null && !clrMmb.prune().hasData()) clrMmb = null;
			bnfcry = bnfcry.stream().filter(b->b!=null).<PartyIdentification248Choice.PartyIdentification248ChoiceBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			if (nttyRspnsblForRpt!=null && !nttyRspnsblForRpt.prune().hasData()) nttyRspnsblForRpt = null;
			exctnAgt = exctnAgt.stream().filter(b->b!=null).<OrganisationIdentification15Choice.OrganisationIdentification15ChoiceBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			rltshRcrd = rltshRcrd.stream().filter(b->b!=null).<TradeCounterpartyRelationshipRecord1.TradeCounterpartyRelationshipRecord1Builder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getRptgCtrPty()!=null && getRptgCtrPty().hasData()) return true;
			if (getOthrCtrPty()!=null && getOthrCtrPty().hasData()) return true;
			if (getBrkr()!=null && getBrkr().hasData()) return true;
			if (getSubmitgAgt()!=null && getSubmitgAgt().hasData()) return true;
			if (getClrMmb()!=null && getClrMmb().hasData()) return true;
			if (getBnfcry()!=null && getBnfcry().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getNttyRspnsblForRpt()!=null && getNttyRspnsblForRpt().hasData()) return true;
			if (getExctnAgt()!=null && getExctnAgt().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getRltshRcrd()!=null && getRltshRcrd().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public TradeCounterpartyReport20.TradeCounterpartyReport20Builder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			TradeCounterpartyReport20.TradeCounterpartyReport20Builder o = (TradeCounterpartyReport20.TradeCounterpartyReport20Builder) other;
			
			merger.mergeRosetta(getRptgCtrPty(), o.getRptgCtrPty(), this::setRptgCtrPty);
			merger.mergeRosetta(getOthrCtrPty(), o.getOthrCtrPty(), this::setOthrCtrPty);
			merger.mergeRosetta(getBrkr(), o.getBrkr(), this::setBrkr);
			merger.mergeRosetta(getSubmitgAgt(), o.getSubmitgAgt(), this::setSubmitgAgt);
			merger.mergeRosetta(getClrMmb(), o.getClrMmb(), this::setClrMmb);
			merger.mergeRosetta(getBnfcry(), o.getBnfcry(), this::getOrCreateBnfcry);
			merger.mergeRosetta(getNttyRspnsblForRpt(), o.getNttyRspnsblForRpt(), this::setNttyRspnsblForRpt);
			merger.mergeRosetta(getExctnAgt(), o.getExctnAgt(), this::getOrCreateExctnAgt);
			merger.mergeRosetta(getRltshRcrd(), o.getRltshRcrd(), this::getOrCreateRltshRcrd);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			TradeCounterpartyReport20 _that = getType().cast(o);
		
			if (!Objects.equals(rptgCtrPty, _that.getRptgCtrPty())) return false;
			if (!Objects.equals(othrCtrPty, _that.getOthrCtrPty())) return false;
			if (!Objects.equals(brkr, _that.getBrkr())) return false;
			if (!Objects.equals(submitgAgt, _that.getSubmitgAgt())) return false;
			if (!Objects.equals(clrMmb, _that.getClrMmb())) return false;
			if (!ListEquals.listEquals(bnfcry, _that.getBnfcry())) return false;
			if (!Objects.equals(nttyRspnsblForRpt, _that.getNttyRspnsblForRpt())) return false;
			if (!ListEquals.listEquals(exctnAgt, _that.getExctnAgt())) return false;
			if (!ListEquals.listEquals(rltshRcrd, _that.getRltshRcrd())) return false;
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
			_result = 31 * _result + (exctnAgt != null ? exctnAgt.hashCode() : 0);
			_result = 31 * _result + (rltshRcrd != null ? rltshRcrd.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "TradeCounterpartyReport20Builder {" +
				"rptgCtrPty=" + this.rptgCtrPty + ", " +
				"othrCtrPty=" + this.othrCtrPty + ", " +
				"brkr=" + this.brkr + ", " +
				"submitgAgt=" + this.submitgAgt + ", " +
				"clrMmb=" + this.clrMmb + ", " +
				"bnfcry=" + this.bnfcry + ", " +
				"nttyRspnsblForRpt=" + this.nttyRspnsblForRpt + ", " +
				"exctnAgt=" + this.exctnAgt + ", " +
				"rltshRcrd=" + this.rltshRcrd +
			'}';
		}
	}
}

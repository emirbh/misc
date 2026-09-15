package iso20022.auth108.esma;

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
import iso20022.auth108.esma.meta.TradeCounterpartyReport20__1Meta;
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
	 * Identification of the party that ultimately submits the report to the trade repository.
	 */
	OrganisationIdentification15Choice__1 getSubmitgAgt();
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
		processRosetta(path.newSubPath("submitgAgt"), processor, OrganisationIdentification15Choice__1.class, getSubmitgAgt());
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
		OrganisationIdentification15Choice__1.OrganisationIdentification15Choice__1Builder getOrCreateSubmitgAgt();
		@Override
		OrganisationIdentification15Choice__1.OrganisationIdentification15Choice__1Builder getSubmitgAgt();
		OrganisationIdentification15Choice__1.OrganisationIdentification15Choice__1Builder getOrCreateNttyRspnsblForRpt();
		@Override
		OrganisationIdentification15Choice__1.OrganisationIdentification15Choice__1Builder getNttyRspnsblForRpt();
		TradeCounterpartyReport20__1.TradeCounterpartyReport20__1Builder setRptgCtrPty(Counterparty45__1 rptgCtrPty);
		TradeCounterpartyReport20__1.TradeCounterpartyReport20__1Builder setOthrCtrPty(Counterparty46__1 othrCtrPty);
		TradeCounterpartyReport20__1.TradeCounterpartyReport20__1Builder setSubmitgAgt(OrganisationIdentification15Choice__1 submitgAgt);
		TradeCounterpartyReport20__1.TradeCounterpartyReport20__1Builder setNttyRspnsblForRpt(OrganisationIdentification15Choice__1 nttyRspnsblForRpt);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("rptgCtrPty"), processor, Counterparty45__1.Counterparty45__1Builder.class, getRptgCtrPty());
			processRosetta(path.newSubPath("othrCtrPty"), processor, Counterparty46__1.Counterparty46__1Builder.class, getOthrCtrPty());
			processRosetta(path.newSubPath("submitgAgt"), processor, OrganisationIdentification15Choice__1.OrganisationIdentification15Choice__1Builder.class, getSubmitgAgt());
			processRosetta(path.newSubPath("nttyRspnsblForRpt"), processor, OrganisationIdentification15Choice__1.OrganisationIdentification15Choice__1Builder.class, getNttyRspnsblForRpt());
		}
		

		TradeCounterpartyReport20__1.TradeCounterpartyReport20__1Builder prune();
	}

	/*********************** Immutable Implementation of TradeCounterpartyReport20__1  ***********************/
	class TradeCounterpartyReport20__1Impl implements TradeCounterpartyReport20__1 {
		private final Counterparty45__1 rptgCtrPty;
		private final Counterparty46__1 othrCtrPty;
		private final OrganisationIdentification15Choice__1 submitgAgt;
		private final OrganisationIdentification15Choice__1 nttyRspnsblForRpt;
		
		protected TradeCounterpartyReport20__1Impl(TradeCounterpartyReport20__1.TradeCounterpartyReport20__1Builder builder) {
			this.rptgCtrPty = ofNullable(builder.getRptgCtrPty()).map(f->f.build()).orElse(null);
			this.othrCtrPty = ofNullable(builder.getOthrCtrPty()).map(f->f.build()).orElse(null);
			this.submitgAgt = ofNullable(builder.getSubmitgAgt()).map(f->f.build()).orElse(null);
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
		@RosettaAttribute("submitgAgt")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("submitgAgt")
		public OrganisationIdentification15Choice__1 getSubmitgAgt() {
			return submitgAgt;
		}
		
		@Override
		@RosettaAttribute("nttyRspnsblForRpt")
		@Accessor(AccessorType.GETTER)
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
			ofNullable(getSubmitgAgt()).ifPresent(builder::setSubmitgAgt);
			ofNullable(getNttyRspnsblForRpt()).ifPresent(builder::setNttyRspnsblForRpt);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			TradeCounterpartyReport20__1 _that = getType().cast(o);
		
			if (!Objects.equals(rptgCtrPty, _that.getRptgCtrPty())) return false;
			if (!Objects.equals(othrCtrPty, _that.getOthrCtrPty())) return false;
			if (!Objects.equals(submitgAgt, _that.getSubmitgAgt())) return false;
			if (!Objects.equals(nttyRspnsblForRpt, _that.getNttyRspnsblForRpt())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (rptgCtrPty != null ? rptgCtrPty.hashCode() : 0);
			_result = 31 * _result + (othrCtrPty != null ? othrCtrPty.hashCode() : 0);
			_result = 31 * _result + (submitgAgt != null ? submitgAgt.hashCode() : 0);
			_result = 31 * _result + (nttyRspnsblForRpt != null ? nttyRspnsblForRpt.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "TradeCounterpartyReport20__1 {" +
				"rptgCtrPty=" + this.rptgCtrPty + ", " +
				"othrCtrPty=" + this.othrCtrPty + ", " +
				"submitgAgt=" + this.submitgAgt + ", " +
				"nttyRspnsblForRpt=" + this.nttyRspnsblForRpt +
			'}';
		}
	}

	/*********************** Builder Implementation of TradeCounterpartyReport20__1  ***********************/
	class TradeCounterpartyReport20__1BuilderImpl implements TradeCounterpartyReport20__1.TradeCounterpartyReport20__1Builder {
	
		protected Counterparty45__1.Counterparty45__1Builder rptgCtrPty;
		protected Counterparty46__1.Counterparty46__1Builder othrCtrPty;
		protected OrganisationIdentification15Choice__1.OrganisationIdentification15Choice__1Builder submitgAgt;
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
		@RosettaAttribute("submitgAgt")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("submitgAgt")
		public OrganisationIdentification15Choice__1.OrganisationIdentification15Choice__1Builder getSubmitgAgt() {
			return submitgAgt;
		}
		
		@Override
		public OrganisationIdentification15Choice__1.OrganisationIdentification15Choice__1Builder getOrCreateSubmitgAgt() {
			OrganisationIdentification15Choice__1.OrganisationIdentification15Choice__1Builder result;
			if (submitgAgt!=null) {
				result = submitgAgt;
			}
			else {
				result = submitgAgt = OrganisationIdentification15Choice__1.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("nttyRspnsblForRpt")
		@Accessor(AccessorType.GETTER)
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
		
		@RosettaAttribute("submitgAgt")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("submitgAgt")
		@Override
		public TradeCounterpartyReport20__1.TradeCounterpartyReport20__1Builder setSubmitgAgt(OrganisationIdentification15Choice__1 _submitgAgt) {
			this.submitgAgt = _submitgAgt == null ? null : _submitgAgt.toBuilder();
			return this;
		}
		
		@RosettaAttribute("nttyRspnsblForRpt")
		@Accessor(AccessorType.SETTER)
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
			if (submitgAgt!=null && !submitgAgt.prune().hasData()) submitgAgt = null;
			if (nttyRspnsblForRpt!=null && !nttyRspnsblForRpt.prune().hasData()) nttyRspnsblForRpt = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getRptgCtrPty()!=null && getRptgCtrPty().hasData()) return true;
			if (getOthrCtrPty()!=null && getOthrCtrPty().hasData()) return true;
			if (getSubmitgAgt()!=null && getSubmitgAgt().hasData()) return true;
			if (getNttyRspnsblForRpt()!=null && getNttyRspnsblForRpt().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public TradeCounterpartyReport20__1.TradeCounterpartyReport20__1Builder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			TradeCounterpartyReport20__1.TradeCounterpartyReport20__1Builder o = (TradeCounterpartyReport20__1.TradeCounterpartyReport20__1Builder) other;
			
			merger.mergeRosetta(getRptgCtrPty(), o.getRptgCtrPty(), this::setRptgCtrPty);
			merger.mergeRosetta(getOthrCtrPty(), o.getOthrCtrPty(), this::setOthrCtrPty);
			merger.mergeRosetta(getSubmitgAgt(), o.getSubmitgAgt(), this::setSubmitgAgt);
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
			if (!Objects.equals(submitgAgt, _that.getSubmitgAgt())) return false;
			if (!Objects.equals(nttyRspnsblForRpt, _that.getNttyRspnsblForRpt())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (rptgCtrPty != null ? rptgCtrPty.hashCode() : 0);
			_result = 31 * _result + (othrCtrPty != null ? othrCtrPty.hashCode() : 0);
			_result = 31 * _result + (submitgAgt != null ? submitgAgt.hashCode() : 0);
			_result = 31 * _result + (nttyRspnsblForRpt != null ? nttyRspnsblForRpt.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "TradeCounterpartyReport20__1Builder {" +
				"rptgCtrPty=" + this.rptgCtrPty + ", " +
				"othrCtrPty=" + this.othrCtrPty + ", " +
				"submitgAgt=" + this.submitgAgt + ", " +
				"nttyRspnsblForRpt=" + this.nttyRspnsblForRpt +
			'}';
		}
	}
}

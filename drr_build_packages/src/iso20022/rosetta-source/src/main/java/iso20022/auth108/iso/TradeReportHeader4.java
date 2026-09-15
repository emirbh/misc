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
import com.rosetta.model.lib.records.Date;
import com.rosetta.util.ListEquals;
import iso20022.auth108.iso.meta.TradeReportHeader4Meta;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.Consumer;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * Provides the details of the header for a trade transaction query message.
 * @version ${project.version}
 */
@RosettaDataType(value="TradeReportHeader4", builder=TradeReportHeader4.TradeReportHeader4BuilderImpl.class, version="${project.version}")
@RuneDataType(value="TradeReportHeader4", model="iso20022", builder=TradeReportHeader4.TradeReportHeader4BuilderImpl.class, version="${project.version}")
public interface TradeReportHeader4 extends RosettaModelObject {

	TradeReportHeader4Meta metaData = new TradeReportHeader4Meta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Indicates the as-at day for which the report was produced.
	 */
	Date getRptExctnDt();
	/**
	 * Page number of the message (within the report) and continuation indicator to indicate that the report is to continue or that the message is the last page of the report.
	 */
	Pagination1 getMsgPgntn();
	/**
	 * Indicates the number of records in the page.
	 */
	Long getNbRcrds();
	/**
	 * Specifies the competent authority that requires reporting of the transaction.
	 */
	List<String> getCmptntAuthrty();
	/**
	 * Identifies the new trade repository to which the derivative is transfered to.
	 */
	OrganisationIdentification15Choice getNewTradRpstryIdr();
	/**
	 * Underlying reason for reporting the derivative transaction.
	 */
	List<String> getRptgPurp();

	/*********************** Build Methods  ***********************/
	TradeReportHeader4 build();
	
	TradeReportHeader4.TradeReportHeader4Builder toBuilder();
	
	static TradeReportHeader4.TradeReportHeader4Builder builder() {
		return new TradeReportHeader4.TradeReportHeader4BuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends TradeReportHeader4> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends TradeReportHeader4> getType() {
		return TradeReportHeader4.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("rptExctnDt"), Date.class, getRptExctnDt(), this);
		processRosetta(path.newSubPath("msgPgntn"), processor, Pagination1.class, getMsgPgntn());
		processor.processBasic(path.newSubPath("nbRcrds"), Long.class, getNbRcrds(), this);
		processor.processBasic(path.newSubPath("cmptntAuthrty"), String.class, getCmptntAuthrty(), this);
		processRosetta(path.newSubPath("newTradRpstryIdr"), processor, OrganisationIdentification15Choice.class, getNewTradRpstryIdr());
		processor.processBasic(path.newSubPath("rptgPurp"), String.class, getRptgPurp(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface TradeReportHeader4Builder extends TradeReportHeader4, RosettaModelObjectBuilder {
		Pagination1.Pagination1Builder getOrCreateMsgPgntn();
		@Override
		Pagination1.Pagination1Builder getMsgPgntn();
		OrganisationIdentification15Choice.OrganisationIdentification15ChoiceBuilder getOrCreateNewTradRpstryIdr();
		@Override
		OrganisationIdentification15Choice.OrganisationIdentification15ChoiceBuilder getNewTradRpstryIdr();
		TradeReportHeader4.TradeReportHeader4Builder setRptExctnDt(Date rptExctnDt);
		TradeReportHeader4.TradeReportHeader4Builder setMsgPgntn(Pagination1 msgPgntn);
		TradeReportHeader4.TradeReportHeader4Builder setNbRcrds(Long nbRcrds);
		TradeReportHeader4.TradeReportHeader4Builder addCmptntAuthrty(String cmptntAuthrty);
		TradeReportHeader4.TradeReportHeader4Builder addCmptntAuthrty(String cmptntAuthrty, int idx);
		TradeReportHeader4.TradeReportHeader4Builder addCmptntAuthrty(List<String> cmptntAuthrty);
		TradeReportHeader4.TradeReportHeader4Builder setCmptntAuthrty(List<String> cmptntAuthrty);
		TradeReportHeader4.TradeReportHeader4Builder setNewTradRpstryIdr(OrganisationIdentification15Choice newTradRpstryIdr);
		TradeReportHeader4.TradeReportHeader4Builder addRptgPurp(String rptgPurp);
		TradeReportHeader4.TradeReportHeader4Builder addRptgPurp(String rptgPurp, int idx);
		TradeReportHeader4.TradeReportHeader4Builder addRptgPurp(List<String> rptgPurp);
		TradeReportHeader4.TradeReportHeader4Builder setRptgPurp(List<String> rptgPurp);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("rptExctnDt"), Date.class, getRptExctnDt(), this);
			processRosetta(path.newSubPath("msgPgntn"), processor, Pagination1.Pagination1Builder.class, getMsgPgntn());
			processor.processBasic(path.newSubPath("nbRcrds"), Long.class, getNbRcrds(), this);
			processor.processBasic(path.newSubPath("cmptntAuthrty"), String.class, getCmptntAuthrty(), this);
			processRosetta(path.newSubPath("newTradRpstryIdr"), processor, OrganisationIdentification15Choice.OrganisationIdentification15ChoiceBuilder.class, getNewTradRpstryIdr());
			processor.processBasic(path.newSubPath("rptgPurp"), String.class, getRptgPurp(), this);
		}
		

		TradeReportHeader4.TradeReportHeader4Builder prune();
	}

	/*********************** Immutable Implementation of TradeReportHeader4  ***********************/
	class TradeReportHeader4Impl implements TradeReportHeader4 {
		private final Date rptExctnDt;
		private final Pagination1 msgPgntn;
		private final Long nbRcrds;
		private final List<String> cmptntAuthrty;
		private final OrganisationIdentification15Choice newTradRpstryIdr;
		private final List<String> rptgPurp;
		
		protected TradeReportHeader4Impl(TradeReportHeader4.TradeReportHeader4Builder builder) {
			this.rptExctnDt = builder.getRptExctnDt();
			this.msgPgntn = ofNullable(builder.getMsgPgntn()).map(f->f.build()).orElse(null);
			this.nbRcrds = builder.getNbRcrds();
			this.cmptntAuthrty = ofNullable(builder.getCmptntAuthrty()).filter(_l->!_l.isEmpty()).map(ImmutableList::copyOf).orElse(null);
			this.newTradRpstryIdr = ofNullable(builder.getNewTradRpstryIdr()).map(f->f.build()).orElse(null);
			this.rptgPurp = ofNullable(builder.getRptgPurp()).filter(_l->!_l.isEmpty()).map(ImmutableList::copyOf).orElse(null);
		}
		
		@Override
		@RosettaAttribute("rptExctnDt")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("rptExctnDt")
		public Date getRptExctnDt() {
			return rptExctnDt;
		}
		
		@Override
		@RosettaAttribute("msgPgntn")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("msgPgntn")
		public Pagination1 getMsgPgntn() {
			return msgPgntn;
		}
		
		@Override
		@RosettaAttribute("nbRcrds")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("nbRcrds")
		public Long getNbRcrds() {
			return nbRcrds;
		}
		
		@Override
		@RosettaAttribute("cmptntAuthrty")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("cmptntAuthrty")
		public List<String> getCmptntAuthrty() {
			return cmptntAuthrty;
		}
		
		@Override
		@RosettaAttribute("newTradRpstryIdr")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("newTradRpstryIdr")
		public OrganisationIdentification15Choice getNewTradRpstryIdr() {
			return newTradRpstryIdr;
		}
		
		@Override
		@RosettaAttribute("rptgPurp")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("rptgPurp")
		public List<String> getRptgPurp() {
			return rptgPurp;
		}
		
		@Override
		public TradeReportHeader4 build() {
			return this;
		}
		
		@Override
		public TradeReportHeader4.TradeReportHeader4Builder toBuilder() {
			TradeReportHeader4.TradeReportHeader4Builder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(TradeReportHeader4.TradeReportHeader4Builder builder) {
			ofNullable(getRptExctnDt()).ifPresent(builder::setRptExctnDt);
			ofNullable(getMsgPgntn()).ifPresent(builder::setMsgPgntn);
			ofNullable(getNbRcrds()).ifPresent(builder::setNbRcrds);
			ofNullable(getCmptntAuthrty()).ifPresent(builder::setCmptntAuthrty);
			ofNullable(getNewTradRpstryIdr()).ifPresent(builder::setNewTradRpstryIdr);
			ofNullable(getRptgPurp()).ifPresent(builder::setRptgPurp);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			TradeReportHeader4 _that = getType().cast(o);
		
			if (!Objects.equals(rptExctnDt, _that.getRptExctnDt())) return false;
			if (!Objects.equals(msgPgntn, _that.getMsgPgntn())) return false;
			if (!Objects.equals(nbRcrds, _that.getNbRcrds())) return false;
			if (!ListEquals.listEquals(cmptntAuthrty, _that.getCmptntAuthrty())) return false;
			if (!Objects.equals(newTradRpstryIdr, _that.getNewTradRpstryIdr())) return false;
			if (!ListEquals.listEquals(rptgPurp, _that.getRptgPurp())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (rptExctnDt != null ? rptExctnDt.hashCode() : 0);
			_result = 31 * _result + (msgPgntn != null ? msgPgntn.hashCode() : 0);
			_result = 31 * _result + (nbRcrds != null ? nbRcrds.hashCode() : 0);
			_result = 31 * _result + (cmptntAuthrty != null ? cmptntAuthrty.hashCode() : 0);
			_result = 31 * _result + (newTradRpstryIdr != null ? newTradRpstryIdr.hashCode() : 0);
			_result = 31 * _result + (rptgPurp != null ? rptgPurp.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "TradeReportHeader4 {" +
				"rptExctnDt=" + this.rptExctnDt + ", " +
				"msgPgntn=" + this.msgPgntn + ", " +
				"nbRcrds=" + this.nbRcrds + ", " +
				"cmptntAuthrty=" + this.cmptntAuthrty + ", " +
				"newTradRpstryIdr=" + this.newTradRpstryIdr + ", " +
				"rptgPurp=" + this.rptgPurp +
			'}';
		}
	}

	/*********************** Builder Implementation of TradeReportHeader4  ***********************/
	class TradeReportHeader4BuilderImpl implements TradeReportHeader4.TradeReportHeader4Builder {
	
		protected Date rptExctnDt;
		protected Pagination1.Pagination1Builder msgPgntn;
		protected Long nbRcrds;
		protected List<String> cmptntAuthrty = new ArrayList<>();
		protected OrganisationIdentification15Choice.OrganisationIdentification15ChoiceBuilder newTradRpstryIdr;
		protected List<String> rptgPurp = new ArrayList<>();
		
		@Override
		@RosettaAttribute("rptExctnDt")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("rptExctnDt")
		public Date getRptExctnDt() {
			return rptExctnDt;
		}
		
		@Override
		@RosettaAttribute("msgPgntn")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("msgPgntn")
		public Pagination1.Pagination1Builder getMsgPgntn() {
			return msgPgntn;
		}
		
		@Override
		public Pagination1.Pagination1Builder getOrCreateMsgPgntn() {
			Pagination1.Pagination1Builder result;
			if (msgPgntn!=null) {
				result = msgPgntn;
			}
			else {
				result = msgPgntn = Pagination1.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("nbRcrds")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("nbRcrds")
		public Long getNbRcrds() {
			return nbRcrds;
		}
		
		@Override
		@RosettaAttribute("cmptntAuthrty")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("cmptntAuthrty")
		public List<String> getCmptntAuthrty() {
			return cmptntAuthrty;
		}
		
		@Override
		@RosettaAttribute("newTradRpstryIdr")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("newTradRpstryIdr")
		public OrganisationIdentification15Choice.OrganisationIdentification15ChoiceBuilder getNewTradRpstryIdr() {
			return newTradRpstryIdr;
		}
		
		@Override
		public OrganisationIdentification15Choice.OrganisationIdentification15ChoiceBuilder getOrCreateNewTradRpstryIdr() {
			OrganisationIdentification15Choice.OrganisationIdentification15ChoiceBuilder result;
			if (newTradRpstryIdr!=null) {
				result = newTradRpstryIdr;
			}
			else {
				result = newTradRpstryIdr = OrganisationIdentification15Choice.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("rptgPurp")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("rptgPurp")
		public List<String> getRptgPurp() {
			return rptgPurp;
		}
		
		@RosettaAttribute("rptExctnDt")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("rptExctnDt")
		@Override
		public TradeReportHeader4.TradeReportHeader4Builder setRptExctnDt(Date _rptExctnDt) {
			this.rptExctnDt = _rptExctnDt == null ? null : _rptExctnDt;
			return this;
		}
		
		@RosettaAttribute("msgPgntn")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("msgPgntn")
		@Override
		public TradeReportHeader4.TradeReportHeader4Builder setMsgPgntn(Pagination1 _msgPgntn) {
			this.msgPgntn = _msgPgntn == null ? null : _msgPgntn.toBuilder();
			return this;
		}
		
		@RosettaAttribute("nbRcrds")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("nbRcrds")
		@Override
		public TradeReportHeader4.TradeReportHeader4Builder setNbRcrds(Long _nbRcrds) {
			this.nbRcrds = _nbRcrds == null ? null : _nbRcrds;
			return this;
		}
		
		@RosettaAttribute("cmptntAuthrty")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("cmptntAuthrty")
		@Override
		public TradeReportHeader4.TradeReportHeader4Builder addCmptntAuthrty(String _cmptntAuthrty) {
			if (_cmptntAuthrty != null) {
				this.cmptntAuthrty.add(_cmptntAuthrty);
			}
			return this;
		}
		
		@Override
		public TradeReportHeader4.TradeReportHeader4Builder addCmptntAuthrty(String _cmptntAuthrty, int idx) {
			getIndex(this.cmptntAuthrty, idx, () -> _cmptntAuthrty);
			return this;
		}
		
		@Override
		public TradeReportHeader4.TradeReportHeader4Builder addCmptntAuthrty(List<String> cmptntAuthrtys) {
			if (cmptntAuthrtys != null) {
				for (final String toAdd : cmptntAuthrtys) {
					this.cmptntAuthrty.add(toAdd);
				}
			}
			return this;
		}
		
		@RosettaAttribute("cmptntAuthrty")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("cmptntAuthrty")
		@Override
		public TradeReportHeader4.TradeReportHeader4Builder setCmptntAuthrty(List<String> cmptntAuthrtys) {
			if (cmptntAuthrtys == null) {
				this.cmptntAuthrty = new ArrayList<>();
			} else {
				this.cmptntAuthrty = cmptntAuthrtys.stream()
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("newTradRpstryIdr")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("newTradRpstryIdr")
		@Override
		public TradeReportHeader4.TradeReportHeader4Builder setNewTradRpstryIdr(OrganisationIdentification15Choice _newTradRpstryIdr) {
			this.newTradRpstryIdr = _newTradRpstryIdr == null ? null : _newTradRpstryIdr.toBuilder();
			return this;
		}
		
		@RosettaAttribute("rptgPurp")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("rptgPurp")
		@Override
		public TradeReportHeader4.TradeReportHeader4Builder addRptgPurp(String _rptgPurp) {
			if (_rptgPurp != null) {
				this.rptgPurp.add(_rptgPurp);
			}
			return this;
		}
		
		@Override
		public TradeReportHeader4.TradeReportHeader4Builder addRptgPurp(String _rptgPurp, int idx) {
			getIndex(this.rptgPurp, idx, () -> _rptgPurp);
			return this;
		}
		
		@Override
		public TradeReportHeader4.TradeReportHeader4Builder addRptgPurp(List<String> rptgPurps) {
			if (rptgPurps != null) {
				for (final String toAdd : rptgPurps) {
					this.rptgPurp.add(toAdd);
				}
			}
			return this;
		}
		
		@RosettaAttribute("rptgPurp")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("rptgPurp")
		@Override
		public TradeReportHeader4.TradeReportHeader4Builder setRptgPurp(List<String> rptgPurps) {
			if (rptgPurps == null) {
				this.rptgPurp = new ArrayList<>();
			} else {
				this.rptgPurp = rptgPurps.stream()
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		public TradeReportHeader4 build() {
			return new TradeReportHeader4.TradeReportHeader4Impl(this);
		}
		
		@Override
		public TradeReportHeader4.TradeReportHeader4Builder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public TradeReportHeader4.TradeReportHeader4Builder prune() {
			if (msgPgntn!=null && !msgPgntn.prune().hasData()) msgPgntn = null;
			if (newTradRpstryIdr!=null && !newTradRpstryIdr.prune().hasData()) newTradRpstryIdr = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getRptExctnDt()!=null) return true;
			if (getMsgPgntn()!=null && getMsgPgntn().hasData()) return true;
			if (getNbRcrds()!=null) return true;
			if (getCmptntAuthrty()!=null && !getCmptntAuthrty().isEmpty()) return true;
			if (getNewTradRpstryIdr()!=null && getNewTradRpstryIdr().hasData()) return true;
			if (getRptgPurp()!=null && !getRptgPurp().isEmpty()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public TradeReportHeader4.TradeReportHeader4Builder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			TradeReportHeader4.TradeReportHeader4Builder o = (TradeReportHeader4.TradeReportHeader4Builder) other;
			
			merger.mergeRosetta(getMsgPgntn(), o.getMsgPgntn(), this::setMsgPgntn);
			merger.mergeRosetta(getNewTradRpstryIdr(), o.getNewTradRpstryIdr(), this::setNewTradRpstryIdr);
			
			merger.mergeBasic(getRptExctnDt(), o.getRptExctnDt(), this::setRptExctnDt);
			merger.mergeBasic(getNbRcrds(), o.getNbRcrds(), this::setNbRcrds);
			merger.mergeBasic(getCmptntAuthrty(), o.getCmptntAuthrty(), (Consumer<String>) this::addCmptntAuthrty);
			merger.mergeBasic(getRptgPurp(), o.getRptgPurp(), (Consumer<String>) this::addRptgPurp);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			TradeReportHeader4 _that = getType().cast(o);
		
			if (!Objects.equals(rptExctnDt, _that.getRptExctnDt())) return false;
			if (!Objects.equals(msgPgntn, _that.getMsgPgntn())) return false;
			if (!Objects.equals(nbRcrds, _that.getNbRcrds())) return false;
			if (!ListEquals.listEquals(cmptntAuthrty, _that.getCmptntAuthrty())) return false;
			if (!Objects.equals(newTradRpstryIdr, _that.getNewTradRpstryIdr())) return false;
			if (!ListEquals.listEquals(rptgPurp, _that.getRptgPurp())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (rptExctnDt != null ? rptExctnDt.hashCode() : 0);
			_result = 31 * _result + (msgPgntn != null ? msgPgntn.hashCode() : 0);
			_result = 31 * _result + (nbRcrds != null ? nbRcrds.hashCode() : 0);
			_result = 31 * _result + (cmptntAuthrty != null ? cmptntAuthrty.hashCode() : 0);
			_result = 31 * _result + (newTradRpstryIdr != null ? newTradRpstryIdr.hashCode() : 0);
			_result = 31 * _result + (rptgPurp != null ? rptgPurp.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "TradeReportHeader4Builder {" +
				"rptExctnDt=" + this.rptExctnDt + ", " +
				"msgPgntn=" + this.msgPgntn + ", " +
				"nbRcrds=" + this.nbRcrds + ", " +
				"cmptntAuthrty=" + this.cmptntAuthrty + ", " +
				"newTradRpstryIdr=" + this.newTradRpstryIdr + ", " +
				"rptgPurp=" + this.rptgPurp +
			'}';
		}
	}
}

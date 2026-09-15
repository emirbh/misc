package iso20022.auth030.mas;

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
import iso20022.auth030.mas.meta.TradeCounterpartyReport20__3Meta;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * @version ${project.version}
 */
@RosettaDataType(value="TradeCounterpartyReport20__3", builder=TradeCounterpartyReport20__3.TradeCounterpartyReport20__3BuilderImpl.class, version="${project.version}")
@RuneDataType(value="TradeCounterpartyReport20__3", model="iso20022", builder=TradeCounterpartyReport20__3.TradeCounterpartyReport20__3BuilderImpl.class, version="${project.version}")
public interface TradeCounterpartyReport20__3 extends RosettaModelObject {

	TradeCounterpartyReport20__3Meta metaData = new TradeCounterpartyReport20__3Meta();

	/*********************** Getter Methods  ***********************/
	Counterparty45__2 getRptgCtrPty();
	Counterparty46__2 getOthrCtrPty();
	OrganisationIdentification15Choice__1 getSubmitgAgt();
	OrganisationIdentification15Choice__1 getNttyRspnsblForRpt();
	List<? extends OrganisationIdentification15Choice__3> getExctnAgt();

	/*********************** Build Methods  ***********************/
	TradeCounterpartyReport20__3 build();
	
	TradeCounterpartyReport20__3.TradeCounterpartyReport20__3Builder toBuilder();
	
	static TradeCounterpartyReport20__3.TradeCounterpartyReport20__3Builder builder() {
		return new TradeCounterpartyReport20__3.TradeCounterpartyReport20__3BuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends TradeCounterpartyReport20__3> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends TradeCounterpartyReport20__3> getType() {
		return TradeCounterpartyReport20__3.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("rptgCtrPty"), processor, Counterparty45__2.class, getRptgCtrPty());
		processRosetta(path.newSubPath("othrCtrPty"), processor, Counterparty46__2.class, getOthrCtrPty());
		processRosetta(path.newSubPath("submitgAgt"), processor, OrganisationIdentification15Choice__1.class, getSubmitgAgt());
		processRosetta(path.newSubPath("nttyRspnsblForRpt"), processor, OrganisationIdentification15Choice__1.class, getNttyRspnsblForRpt());
		processRosetta(path.newSubPath("exctnAgt"), processor, OrganisationIdentification15Choice__3.class, getExctnAgt());
	}
	

	/*********************** Builder Interface  ***********************/
	interface TradeCounterpartyReport20__3Builder extends TradeCounterpartyReport20__3, RosettaModelObjectBuilder {
		Counterparty45__2.Counterparty45__2Builder getOrCreateRptgCtrPty();
		@Override
		Counterparty45__2.Counterparty45__2Builder getRptgCtrPty();
		Counterparty46__2.Counterparty46__2Builder getOrCreateOthrCtrPty();
		@Override
		Counterparty46__2.Counterparty46__2Builder getOthrCtrPty();
		OrganisationIdentification15Choice__1.OrganisationIdentification15Choice__1Builder getOrCreateSubmitgAgt();
		@Override
		OrganisationIdentification15Choice__1.OrganisationIdentification15Choice__1Builder getSubmitgAgt();
		OrganisationIdentification15Choice__1.OrganisationIdentification15Choice__1Builder getOrCreateNttyRspnsblForRpt();
		@Override
		OrganisationIdentification15Choice__1.OrganisationIdentification15Choice__1Builder getNttyRspnsblForRpt();
		OrganisationIdentification15Choice__3.OrganisationIdentification15Choice__3Builder getOrCreateExctnAgt(int index);
		@Override
		List<? extends OrganisationIdentification15Choice__3.OrganisationIdentification15Choice__3Builder> getExctnAgt();
		TradeCounterpartyReport20__3.TradeCounterpartyReport20__3Builder setRptgCtrPty(Counterparty45__2 rptgCtrPty);
		TradeCounterpartyReport20__3.TradeCounterpartyReport20__3Builder setOthrCtrPty(Counterparty46__2 othrCtrPty);
		TradeCounterpartyReport20__3.TradeCounterpartyReport20__3Builder setSubmitgAgt(OrganisationIdentification15Choice__1 submitgAgt);
		TradeCounterpartyReport20__3.TradeCounterpartyReport20__3Builder setNttyRspnsblForRpt(OrganisationIdentification15Choice__1 nttyRspnsblForRpt);
		TradeCounterpartyReport20__3.TradeCounterpartyReport20__3Builder addExctnAgt(OrganisationIdentification15Choice__3 exctnAgt);
		TradeCounterpartyReport20__3.TradeCounterpartyReport20__3Builder addExctnAgt(OrganisationIdentification15Choice__3 exctnAgt, int idx);
		TradeCounterpartyReport20__3.TradeCounterpartyReport20__3Builder addExctnAgt(List<? extends OrganisationIdentification15Choice__3> exctnAgt);
		TradeCounterpartyReport20__3.TradeCounterpartyReport20__3Builder setExctnAgt(List<? extends OrganisationIdentification15Choice__3> exctnAgt);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("rptgCtrPty"), processor, Counterparty45__2.Counterparty45__2Builder.class, getRptgCtrPty());
			processRosetta(path.newSubPath("othrCtrPty"), processor, Counterparty46__2.Counterparty46__2Builder.class, getOthrCtrPty());
			processRosetta(path.newSubPath("submitgAgt"), processor, OrganisationIdentification15Choice__1.OrganisationIdentification15Choice__1Builder.class, getSubmitgAgt());
			processRosetta(path.newSubPath("nttyRspnsblForRpt"), processor, OrganisationIdentification15Choice__1.OrganisationIdentification15Choice__1Builder.class, getNttyRspnsblForRpt());
			processRosetta(path.newSubPath("exctnAgt"), processor, OrganisationIdentification15Choice__3.OrganisationIdentification15Choice__3Builder.class, getExctnAgt());
		}
		

		TradeCounterpartyReport20__3.TradeCounterpartyReport20__3Builder prune();
	}

	/*********************** Immutable Implementation of TradeCounterpartyReport20__3  ***********************/
	class TradeCounterpartyReport20__3Impl implements TradeCounterpartyReport20__3 {
		private final Counterparty45__2 rptgCtrPty;
		private final Counterparty46__2 othrCtrPty;
		private final OrganisationIdentification15Choice__1 submitgAgt;
		private final OrganisationIdentification15Choice__1 nttyRspnsblForRpt;
		private final List<? extends OrganisationIdentification15Choice__3> exctnAgt;
		
		protected TradeCounterpartyReport20__3Impl(TradeCounterpartyReport20__3.TradeCounterpartyReport20__3Builder builder) {
			this.rptgCtrPty = ofNullable(builder.getRptgCtrPty()).map(f->f.build()).orElse(null);
			this.othrCtrPty = ofNullable(builder.getOthrCtrPty()).map(f->f.build()).orElse(null);
			this.submitgAgt = ofNullable(builder.getSubmitgAgt()).map(f->f.build()).orElse(null);
			this.nttyRspnsblForRpt = ofNullable(builder.getNttyRspnsblForRpt()).map(f->f.build()).orElse(null);
			this.exctnAgt = ofNullable(builder.getExctnAgt()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		@RosettaAttribute("rptgCtrPty")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("rptgCtrPty")
		public Counterparty45__2 getRptgCtrPty() {
			return rptgCtrPty;
		}
		
		@Override
		@RosettaAttribute("othrCtrPty")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("othrCtrPty")
		public Counterparty46__2 getOthrCtrPty() {
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
		@Required
		@RuneAttribute("nttyRspnsblForRpt")
		public OrganisationIdentification15Choice__1 getNttyRspnsblForRpt() {
			return nttyRspnsblForRpt;
		}
		
		@Override
		@RosettaAttribute("exctnAgt")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("exctnAgt")
		public List<? extends OrganisationIdentification15Choice__3> getExctnAgt() {
			return exctnAgt;
		}
		
		@Override
		public TradeCounterpartyReport20__3 build() {
			return this;
		}
		
		@Override
		public TradeCounterpartyReport20__3.TradeCounterpartyReport20__3Builder toBuilder() {
			TradeCounterpartyReport20__3.TradeCounterpartyReport20__3Builder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(TradeCounterpartyReport20__3.TradeCounterpartyReport20__3Builder builder) {
			ofNullable(getRptgCtrPty()).ifPresent(builder::setRptgCtrPty);
			ofNullable(getOthrCtrPty()).ifPresent(builder::setOthrCtrPty);
			ofNullable(getSubmitgAgt()).ifPresent(builder::setSubmitgAgt);
			ofNullable(getNttyRspnsblForRpt()).ifPresent(builder::setNttyRspnsblForRpt);
			ofNullable(getExctnAgt()).ifPresent(builder::setExctnAgt);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			TradeCounterpartyReport20__3 _that = getType().cast(o);
		
			if (!Objects.equals(rptgCtrPty, _that.getRptgCtrPty())) return false;
			if (!Objects.equals(othrCtrPty, _that.getOthrCtrPty())) return false;
			if (!Objects.equals(submitgAgt, _that.getSubmitgAgt())) return false;
			if (!Objects.equals(nttyRspnsblForRpt, _that.getNttyRspnsblForRpt())) return false;
			if (!ListEquals.listEquals(exctnAgt, _that.getExctnAgt())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (rptgCtrPty != null ? rptgCtrPty.hashCode() : 0);
			_result = 31 * _result + (othrCtrPty != null ? othrCtrPty.hashCode() : 0);
			_result = 31 * _result + (submitgAgt != null ? submitgAgt.hashCode() : 0);
			_result = 31 * _result + (nttyRspnsblForRpt != null ? nttyRspnsblForRpt.hashCode() : 0);
			_result = 31 * _result + (exctnAgt != null ? exctnAgt.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "TradeCounterpartyReport20__3 {" +
				"rptgCtrPty=" + this.rptgCtrPty + ", " +
				"othrCtrPty=" + this.othrCtrPty + ", " +
				"submitgAgt=" + this.submitgAgt + ", " +
				"nttyRspnsblForRpt=" + this.nttyRspnsblForRpt + ", " +
				"exctnAgt=" + this.exctnAgt +
			'}';
		}
	}

	/*********************** Builder Implementation of TradeCounterpartyReport20__3  ***********************/
	class TradeCounterpartyReport20__3BuilderImpl implements TradeCounterpartyReport20__3.TradeCounterpartyReport20__3Builder {
	
		protected Counterparty45__2.Counterparty45__2Builder rptgCtrPty;
		protected Counterparty46__2.Counterparty46__2Builder othrCtrPty;
		protected OrganisationIdentification15Choice__1.OrganisationIdentification15Choice__1Builder submitgAgt;
		protected OrganisationIdentification15Choice__1.OrganisationIdentification15Choice__1Builder nttyRspnsblForRpt;
		protected List<OrganisationIdentification15Choice__3.OrganisationIdentification15Choice__3Builder> exctnAgt = new ArrayList<>();
		
		@Override
		@RosettaAttribute("rptgCtrPty")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("rptgCtrPty")
		public Counterparty45__2.Counterparty45__2Builder getRptgCtrPty() {
			return rptgCtrPty;
		}
		
		@Override
		public Counterparty45__2.Counterparty45__2Builder getOrCreateRptgCtrPty() {
			Counterparty45__2.Counterparty45__2Builder result;
			if (rptgCtrPty!=null) {
				result = rptgCtrPty;
			}
			else {
				result = rptgCtrPty = Counterparty45__2.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("othrCtrPty")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("othrCtrPty")
		public Counterparty46__2.Counterparty46__2Builder getOthrCtrPty() {
			return othrCtrPty;
		}
		
		@Override
		public Counterparty46__2.Counterparty46__2Builder getOrCreateOthrCtrPty() {
			Counterparty46__2.Counterparty46__2Builder result;
			if (othrCtrPty!=null) {
				result = othrCtrPty;
			}
			else {
				result = othrCtrPty = Counterparty46__2.builder();
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
		
		@Override
		@RosettaAttribute("exctnAgt")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("exctnAgt")
		public List<? extends OrganisationIdentification15Choice__3.OrganisationIdentification15Choice__3Builder> getExctnAgt() {
			return exctnAgt;
		}
		
		@Override
		public OrganisationIdentification15Choice__3.OrganisationIdentification15Choice__3Builder getOrCreateExctnAgt(int index) {
			if (exctnAgt==null) {
				this.exctnAgt = new ArrayList<>();
			}
			return getIndex(exctnAgt, index, () -> {
						OrganisationIdentification15Choice__3.OrganisationIdentification15Choice__3Builder newExctnAgt = OrganisationIdentification15Choice__3.builder();
						return newExctnAgt;
					});
		}
		
		@RosettaAttribute("rptgCtrPty")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("rptgCtrPty")
		@Override
		public TradeCounterpartyReport20__3.TradeCounterpartyReport20__3Builder setRptgCtrPty(Counterparty45__2 _rptgCtrPty) {
			this.rptgCtrPty = _rptgCtrPty == null ? null : _rptgCtrPty.toBuilder();
			return this;
		}
		
		@RosettaAttribute("othrCtrPty")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("othrCtrPty")
		@Override
		public TradeCounterpartyReport20__3.TradeCounterpartyReport20__3Builder setOthrCtrPty(Counterparty46__2 _othrCtrPty) {
			this.othrCtrPty = _othrCtrPty == null ? null : _othrCtrPty.toBuilder();
			return this;
		}
		
		@RosettaAttribute("submitgAgt")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("submitgAgt")
		@Override
		public TradeCounterpartyReport20__3.TradeCounterpartyReport20__3Builder setSubmitgAgt(OrganisationIdentification15Choice__1 _submitgAgt) {
			this.submitgAgt = _submitgAgt == null ? null : _submitgAgt.toBuilder();
			return this;
		}
		
		@RosettaAttribute("nttyRspnsblForRpt")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("nttyRspnsblForRpt")
		@Override
		public TradeCounterpartyReport20__3.TradeCounterpartyReport20__3Builder setNttyRspnsblForRpt(OrganisationIdentification15Choice__1 _nttyRspnsblForRpt) {
			this.nttyRspnsblForRpt = _nttyRspnsblForRpt == null ? null : _nttyRspnsblForRpt.toBuilder();
			return this;
		}
		
		@RosettaAttribute("exctnAgt")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("exctnAgt")
		@Override
		public TradeCounterpartyReport20__3.TradeCounterpartyReport20__3Builder addExctnAgt(OrganisationIdentification15Choice__3 _exctnAgt) {
			if (_exctnAgt != null) {
				this.exctnAgt.add(_exctnAgt.toBuilder());
			}
			return this;
		}
		
		@Override
		public TradeCounterpartyReport20__3.TradeCounterpartyReport20__3Builder addExctnAgt(OrganisationIdentification15Choice__3 _exctnAgt, int idx) {
			getIndex(this.exctnAgt, idx, () -> _exctnAgt.toBuilder());
			return this;
		}
		
		@Override
		public TradeCounterpartyReport20__3.TradeCounterpartyReport20__3Builder addExctnAgt(List<? extends OrganisationIdentification15Choice__3> exctnAgts) {
			if (exctnAgts != null) {
				for (final OrganisationIdentification15Choice__3 toAdd : exctnAgts) {
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
		public TradeCounterpartyReport20__3.TradeCounterpartyReport20__3Builder setExctnAgt(List<? extends OrganisationIdentification15Choice__3> exctnAgts) {
			if (exctnAgts == null) {
				this.exctnAgt = new ArrayList<>();
			} else {
				this.exctnAgt = exctnAgts.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		public TradeCounterpartyReport20__3 build() {
			return new TradeCounterpartyReport20__3.TradeCounterpartyReport20__3Impl(this);
		}
		
		@Override
		public TradeCounterpartyReport20__3.TradeCounterpartyReport20__3Builder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public TradeCounterpartyReport20__3.TradeCounterpartyReport20__3Builder prune() {
			if (rptgCtrPty!=null && !rptgCtrPty.prune().hasData()) rptgCtrPty = null;
			if (othrCtrPty!=null && !othrCtrPty.prune().hasData()) othrCtrPty = null;
			if (submitgAgt!=null && !submitgAgt.prune().hasData()) submitgAgt = null;
			if (nttyRspnsblForRpt!=null && !nttyRspnsblForRpt.prune().hasData()) nttyRspnsblForRpt = null;
			exctnAgt = exctnAgt.stream().filter(b->b!=null).<OrganisationIdentification15Choice__3.OrganisationIdentification15Choice__3Builder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getRptgCtrPty()!=null && getRptgCtrPty().hasData()) return true;
			if (getOthrCtrPty()!=null && getOthrCtrPty().hasData()) return true;
			if (getSubmitgAgt()!=null && getSubmitgAgt().hasData()) return true;
			if (getNttyRspnsblForRpt()!=null && getNttyRspnsblForRpt().hasData()) return true;
			if (getExctnAgt()!=null && getExctnAgt().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public TradeCounterpartyReport20__3.TradeCounterpartyReport20__3Builder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			TradeCounterpartyReport20__3.TradeCounterpartyReport20__3Builder o = (TradeCounterpartyReport20__3.TradeCounterpartyReport20__3Builder) other;
			
			merger.mergeRosetta(getRptgCtrPty(), o.getRptgCtrPty(), this::setRptgCtrPty);
			merger.mergeRosetta(getOthrCtrPty(), o.getOthrCtrPty(), this::setOthrCtrPty);
			merger.mergeRosetta(getSubmitgAgt(), o.getSubmitgAgt(), this::setSubmitgAgt);
			merger.mergeRosetta(getNttyRspnsblForRpt(), o.getNttyRspnsblForRpt(), this::setNttyRspnsblForRpt);
			merger.mergeRosetta(getExctnAgt(), o.getExctnAgt(), this::getOrCreateExctnAgt);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			TradeCounterpartyReport20__3 _that = getType().cast(o);
		
			if (!Objects.equals(rptgCtrPty, _that.getRptgCtrPty())) return false;
			if (!Objects.equals(othrCtrPty, _that.getOthrCtrPty())) return false;
			if (!Objects.equals(submitgAgt, _that.getSubmitgAgt())) return false;
			if (!Objects.equals(nttyRspnsblForRpt, _that.getNttyRspnsblForRpt())) return false;
			if (!ListEquals.listEquals(exctnAgt, _that.getExctnAgt())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (rptgCtrPty != null ? rptgCtrPty.hashCode() : 0);
			_result = 31 * _result + (othrCtrPty != null ? othrCtrPty.hashCode() : 0);
			_result = 31 * _result + (submitgAgt != null ? submitgAgt.hashCode() : 0);
			_result = 31 * _result + (nttyRspnsblForRpt != null ? nttyRspnsblForRpt.hashCode() : 0);
			_result = 31 * _result + (exctnAgt != null ? exctnAgt.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "TradeCounterpartyReport20__3Builder {" +
				"rptgCtrPty=" + this.rptgCtrPty + ", " +
				"othrCtrPty=" + this.othrCtrPty + ", " +
				"submitgAgt=" + this.submitgAgt + ", " +
				"nttyRspnsblForRpt=" + this.nttyRspnsblForRpt + ", " +
				"exctnAgt=" + this.exctnAgt +
			'}';
		}
	}
}

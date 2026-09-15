package iso20022.auth108.fca;

import com.google.common.collect.ImmutableList;
import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.Accessor;
import com.rosetta.model.lib.annotations.AccessorType;
import com.rosetta.model.lib.annotations.Multi;
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
import iso20022.auth108.fca.meta.TradeData55Choice__1Meta;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * Set of data concerning the reporting trade.
 * @version ${project.version}
 */
@RosettaDataType(value="TradeData55Choice__1", builder=TradeData55Choice__1.TradeData55Choice__1BuilderImpl.class, version="${project.version}")
@RuneDataType(value="TradeData55Choice__1", model="iso20022", builder=TradeData55Choice__1.TradeData55Choice__1BuilderImpl.class, version="${project.version}")
public interface TradeData55Choice__1 extends RosettaModelObject {

	TradeData55Choice__1Meta metaData = new TradeData55Choice__1Meta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Where no reporting data are available, this field should be set so that a valid reference data file can be submitted to the competent authority as per submission requirements.
	 */
	ReportPeriodActivity1Code getDataSetActn();
	/**
	 * Information concerning the reporting at transaction level.
	 */
	List<? extends TradeReport31Choice__1> getRpt();

	/*********************** Build Methods  ***********************/
	TradeData55Choice__1 build();
	
	TradeData55Choice__1.TradeData55Choice__1Builder toBuilder();
	
	static TradeData55Choice__1.TradeData55Choice__1Builder builder() {
		return new TradeData55Choice__1.TradeData55Choice__1BuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends TradeData55Choice__1> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends TradeData55Choice__1> getType() {
		return TradeData55Choice__1.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("dataSetActn"), ReportPeriodActivity1Code.class, getDataSetActn(), this);
		processRosetta(path.newSubPath("rpt"), processor, TradeReport31Choice__1.class, getRpt());
	}
	

	/*********************** Builder Interface  ***********************/
	interface TradeData55Choice__1Builder extends TradeData55Choice__1, RosettaModelObjectBuilder {
		TradeReport31Choice__1.TradeReport31Choice__1Builder getOrCreateRpt(int index);
		@Override
		List<? extends TradeReport31Choice__1.TradeReport31Choice__1Builder> getRpt();
		TradeData55Choice__1.TradeData55Choice__1Builder setDataSetActn(ReportPeriodActivity1Code dataSetActn);
		TradeData55Choice__1.TradeData55Choice__1Builder addRpt(TradeReport31Choice__1 rpt);
		TradeData55Choice__1.TradeData55Choice__1Builder addRpt(TradeReport31Choice__1 rpt, int idx);
		TradeData55Choice__1.TradeData55Choice__1Builder addRpt(List<? extends TradeReport31Choice__1> rpt);
		TradeData55Choice__1.TradeData55Choice__1Builder setRpt(List<? extends TradeReport31Choice__1> rpt);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("dataSetActn"), ReportPeriodActivity1Code.class, getDataSetActn(), this);
			processRosetta(path.newSubPath("rpt"), processor, TradeReport31Choice__1.TradeReport31Choice__1Builder.class, getRpt());
		}
		

		TradeData55Choice__1.TradeData55Choice__1Builder prune();
	}

	/*********************** Immutable Implementation of TradeData55Choice__1  ***********************/
	class TradeData55Choice__1Impl implements TradeData55Choice__1 {
		private final ReportPeriodActivity1Code dataSetActn;
		private final List<? extends TradeReport31Choice__1> rpt;
		
		protected TradeData55Choice__1Impl(TradeData55Choice__1.TradeData55Choice__1Builder builder) {
			this.dataSetActn = builder.getDataSetActn();
			this.rpt = ofNullable(builder.getRpt()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		@RosettaAttribute("dataSetActn")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("dataSetActn")
		public ReportPeriodActivity1Code getDataSetActn() {
			return dataSetActn;
		}
		
		@Override
		@RosettaAttribute("rpt")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("rpt")
		public List<? extends TradeReport31Choice__1> getRpt() {
			return rpt;
		}
		
		@Override
		public TradeData55Choice__1 build() {
			return this;
		}
		
		@Override
		public TradeData55Choice__1.TradeData55Choice__1Builder toBuilder() {
			TradeData55Choice__1.TradeData55Choice__1Builder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(TradeData55Choice__1.TradeData55Choice__1Builder builder) {
			ofNullable(getDataSetActn()).ifPresent(builder::setDataSetActn);
			ofNullable(getRpt()).ifPresent(builder::setRpt);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			TradeData55Choice__1 _that = getType().cast(o);
		
			if (!Objects.equals(dataSetActn, _that.getDataSetActn())) return false;
			if (!ListEquals.listEquals(rpt, _that.getRpt())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (dataSetActn != null ? dataSetActn.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (rpt != null ? rpt.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "TradeData55Choice__1 {" +
				"dataSetActn=" + this.dataSetActn + ", " +
				"rpt=" + this.rpt +
			'}';
		}
	}

	/*********************** Builder Implementation of TradeData55Choice__1  ***********************/
	class TradeData55Choice__1BuilderImpl implements TradeData55Choice__1.TradeData55Choice__1Builder {
	
		protected ReportPeriodActivity1Code dataSetActn;
		protected List<TradeReport31Choice__1.TradeReport31Choice__1Builder> rpt = new ArrayList<>();
		
		@Override
		@RosettaAttribute("dataSetActn")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("dataSetActn")
		public ReportPeriodActivity1Code getDataSetActn() {
			return dataSetActn;
		}
		
		@Override
		@RosettaAttribute("rpt")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("rpt")
		public List<? extends TradeReport31Choice__1.TradeReport31Choice__1Builder> getRpt() {
			return rpt;
		}
		
		@Override
		public TradeReport31Choice__1.TradeReport31Choice__1Builder getOrCreateRpt(int index) {
			if (rpt==null) {
				this.rpt = new ArrayList<>();
			}
			return getIndex(rpt, index, () -> {
						TradeReport31Choice__1.TradeReport31Choice__1Builder newRpt = TradeReport31Choice__1.builder();
						return newRpt;
					});
		}
		
		@RosettaAttribute("dataSetActn")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("dataSetActn")
		@Override
		public TradeData55Choice__1.TradeData55Choice__1Builder setDataSetActn(ReportPeriodActivity1Code _dataSetActn) {
			this.dataSetActn = _dataSetActn == null ? null : _dataSetActn;
			return this;
		}
		
		@RosettaAttribute("rpt")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("rpt")
		@Override
		public TradeData55Choice__1.TradeData55Choice__1Builder addRpt(TradeReport31Choice__1 _rpt) {
			if (_rpt != null) {
				this.rpt.add(_rpt.toBuilder());
			}
			return this;
		}
		
		@Override
		public TradeData55Choice__1.TradeData55Choice__1Builder addRpt(TradeReport31Choice__1 _rpt, int idx) {
			getIndex(this.rpt, idx, () -> _rpt.toBuilder());
			return this;
		}
		
		@Override
		public TradeData55Choice__1.TradeData55Choice__1Builder addRpt(List<? extends TradeReport31Choice__1> rpts) {
			if (rpts != null) {
				for (final TradeReport31Choice__1 toAdd : rpts) {
					this.rpt.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("rpt")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("rpt")
		@Override
		public TradeData55Choice__1.TradeData55Choice__1Builder setRpt(List<? extends TradeReport31Choice__1> rpts) {
			if (rpts == null) {
				this.rpt = new ArrayList<>();
			} else {
				this.rpt = rpts.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		public TradeData55Choice__1 build() {
			return new TradeData55Choice__1.TradeData55Choice__1Impl(this);
		}
		
		@Override
		public TradeData55Choice__1.TradeData55Choice__1Builder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public TradeData55Choice__1.TradeData55Choice__1Builder prune() {
			rpt = rpt.stream().filter(b->b!=null).<TradeReport31Choice__1.TradeReport31Choice__1Builder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getDataSetActn()!=null) return true;
			if (getRpt()!=null && getRpt().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public TradeData55Choice__1.TradeData55Choice__1Builder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			TradeData55Choice__1.TradeData55Choice__1Builder o = (TradeData55Choice__1.TradeData55Choice__1Builder) other;
			
			merger.mergeRosetta(getRpt(), o.getRpt(), this::getOrCreateRpt);
			
			merger.mergeBasic(getDataSetActn(), o.getDataSetActn(), this::setDataSetActn);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			TradeData55Choice__1 _that = getType().cast(o);
		
			if (!Objects.equals(dataSetActn, _that.getDataSetActn())) return false;
			if (!ListEquals.listEquals(rpt, _that.getRpt())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (dataSetActn != null ? dataSetActn.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (rpt != null ? rpt.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "TradeData55Choice__1Builder {" +
				"dataSetActn=" + this.dataSetActn + ", " +
				"rpt=" + this.rpt +
			'}';
		}
	}
}

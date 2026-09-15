package iso20022.auth030.esma;

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
import iso20022.auth030.esma.meta.TradeData57Choice__1Meta;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * Reporting of position or transaction for trade lifecycle events.
 * @version ${project.version}
 */
@RosettaDataType(value="TradeData57Choice__1", builder=TradeData57Choice__1.TradeData57Choice__1BuilderImpl.class, version="${project.version}")
@RuneDataType(value="TradeData57Choice__1", model="iso20022", builder=TradeData57Choice__1.TradeData57Choice__1BuilderImpl.class, version="${project.version}")
public interface TradeData57Choice__1 extends RosettaModelObject {

	TradeData57Choice__1Meta metaData = new TradeData57Choice__1Meta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Reporting of position or transaction for trade lifecycle events.
	 */
	List<? extends TradeReport32Choice__1> getRpt();

	/*********************** Build Methods  ***********************/
	TradeData57Choice__1 build();
	
	TradeData57Choice__1.TradeData57Choice__1Builder toBuilder();
	
	static TradeData57Choice__1.TradeData57Choice__1Builder builder() {
		return new TradeData57Choice__1.TradeData57Choice__1BuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends TradeData57Choice__1> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends TradeData57Choice__1> getType() {
		return TradeData57Choice__1.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("rpt"), processor, TradeReport32Choice__1.class, getRpt());
	}
	

	/*********************** Builder Interface  ***********************/
	interface TradeData57Choice__1Builder extends TradeData57Choice__1, RosettaModelObjectBuilder {
		TradeReport32Choice__1.TradeReport32Choice__1Builder getOrCreateRpt(int index);
		@Override
		List<? extends TradeReport32Choice__1.TradeReport32Choice__1Builder> getRpt();
		TradeData57Choice__1.TradeData57Choice__1Builder addRpt(TradeReport32Choice__1 rpt);
		TradeData57Choice__1.TradeData57Choice__1Builder addRpt(TradeReport32Choice__1 rpt, int idx);
		TradeData57Choice__1.TradeData57Choice__1Builder addRpt(List<? extends TradeReport32Choice__1> rpt);
		TradeData57Choice__1.TradeData57Choice__1Builder setRpt(List<? extends TradeReport32Choice__1> rpt);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("rpt"), processor, TradeReport32Choice__1.TradeReport32Choice__1Builder.class, getRpt());
		}
		

		TradeData57Choice__1.TradeData57Choice__1Builder prune();
	}

	/*********************** Immutable Implementation of TradeData57Choice__1  ***********************/
	class TradeData57Choice__1Impl implements TradeData57Choice__1 {
		private final List<? extends TradeReport32Choice__1> rpt;
		
		protected TradeData57Choice__1Impl(TradeData57Choice__1.TradeData57Choice__1Builder builder) {
			this.rpt = ofNullable(builder.getRpt()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		@RosettaAttribute("rpt")
		@Accessor(AccessorType.GETTER)
		@Required
		@Multi
		@RuneAttribute("rpt")
		public List<? extends TradeReport32Choice__1> getRpt() {
			return rpt;
		}
		
		@Override
		public TradeData57Choice__1 build() {
			return this;
		}
		
		@Override
		public TradeData57Choice__1.TradeData57Choice__1Builder toBuilder() {
			TradeData57Choice__1.TradeData57Choice__1Builder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(TradeData57Choice__1.TradeData57Choice__1Builder builder) {
			ofNullable(getRpt()).ifPresent(builder::setRpt);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			TradeData57Choice__1 _that = getType().cast(o);
		
			if (!ListEquals.listEquals(rpt, _that.getRpt())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (rpt != null ? rpt.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "TradeData57Choice__1 {" +
				"rpt=" + this.rpt +
			'}';
		}
	}

	/*********************** Builder Implementation of TradeData57Choice__1  ***********************/
	class TradeData57Choice__1BuilderImpl implements TradeData57Choice__1.TradeData57Choice__1Builder {
	
		protected List<TradeReport32Choice__1.TradeReport32Choice__1Builder> rpt = new ArrayList<>();
		
		@Override
		@RosettaAttribute("rpt")
		@Accessor(AccessorType.GETTER)
		@Required
		@Multi
		@RuneAttribute("rpt")
		public List<? extends TradeReport32Choice__1.TradeReport32Choice__1Builder> getRpt() {
			return rpt;
		}
		
		@Override
		public TradeReport32Choice__1.TradeReport32Choice__1Builder getOrCreateRpt(int index) {
			if (rpt==null) {
				this.rpt = new ArrayList<>();
			}
			return getIndex(rpt, index, () -> {
						TradeReport32Choice__1.TradeReport32Choice__1Builder newRpt = TradeReport32Choice__1.builder();
						return newRpt;
					});
		}
		
		@RosettaAttribute("rpt")
		@Accessor(AccessorType.ADDER)
		@Required
		@Multi
		@RuneAttribute("rpt")
		@Override
		public TradeData57Choice__1.TradeData57Choice__1Builder addRpt(TradeReport32Choice__1 _rpt) {
			if (_rpt != null) {
				this.rpt.add(_rpt.toBuilder());
			}
			return this;
		}
		
		@Override
		public TradeData57Choice__1.TradeData57Choice__1Builder addRpt(TradeReport32Choice__1 _rpt, int idx) {
			getIndex(this.rpt, idx, () -> _rpt.toBuilder());
			return this;
		}
		
		@Override
		public TradeData57Choice__1.TradeData57Choice__1Builder addRpt(List<? extends TradeReport32Choice__1> rpts) {
			if (rpts != null) {
				for (final TradeReport32Choice__1 toAdd : rpts) {
					this.rpt.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("rpt")
		@Accessor(AccessorType.SETTER)
		@Required
		@Multi
		@RuneAttribute("rpt")
		@Override
		public TradeData57Choice__1.TradeData57Choice__1Builder setRpt(List<? extends TradeReport32Choice__1> rpts) {
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
		public TradeData57Choice__1 build() {
			return new TradeData57Choice__1.TradeData57Choice__1Impl(this);
		}
		
		@Override
		public TradeData57Choice__1.TradeData57Choice__1Builder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public TradeData57Choice__1.TradeData57Choice__1Builder prune() {
			rpt = rpt.stream().filter(b->b!=null).<TradeReport32Choice__1.TradeReport32Choice__1Builder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getRpt()!=null && getRpt().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public TradeData57Choice__1.TradeData57Choice__1Builder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			TradeData57Choice__1.TradeData57Choice__1Builder o = (TradeData57Choice__1.TradeData57Choice__1Builder) other;
			
			merger.mergeRosetta(getRpt(), o.getRpt(), this::getOrCreateRpt);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			TradeData57Choice__1 _that = getType().cast(o);
		
			if (!ListEquals.listEquals(rpt, _that.getRpt())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (rpt != null ? rpt.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "TradeData57Choice__1Builder {" +
				"rpt=" + this.rpt +
			'}';
		}
	}
}

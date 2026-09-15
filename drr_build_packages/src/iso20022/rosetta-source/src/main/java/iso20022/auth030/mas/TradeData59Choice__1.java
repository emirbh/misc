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
import iso20022.auth030.mas.meta.TradeData59Choice__1Meta;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * @version ${project.version}
 */
@RosettaDataType(value="TradeData59Choice__1", builder=TradeData59Choice__1.TradeData59Choice__1BuilderImpl.class, version="${project.version}")
@RuneDataType(value="TradeData59Choice__1", model="iso20022", builder=TradeData59Choice__1.TradeData59Choice__1BuilderImpl.class, version="${project.version}")
public interface TradeData59Choice__1 extends RosettaModelObject {

	TradeData59Choice__1Meta metaData = new TradeData59Choice__1Meta();

	/*********************** Getter Methods  ***********************/
	List<? extends TradeReport33Choice__1> getRpt();

	/*********************** Build Methods  ***********************/
	TradeData59Choice__1 build();
	
	TradeData59Choice__1.TradeData59Choice__1Builder toBuilder();
	
	static TradeData59Choice__1.TradeData59Choice__1Builder builder() {
		return new TradeData59Choice__1.TradeData59Choice__1BuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends TradeData59Choice__1> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends TradeData59Choice__1> getType() {
		return TradeData59Choice__1.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("rpt"), processor, TradeReport33Choice__1.class, getRpt());
	}
	

	/*********************** Builder Interface  ***********************/
	interface TradeData59Choice__1Builder extends TradeData59Choice__1, RosettaModelObjectBuilder {
		TradeReport33Choice__1.TradeReport33Choice__1Builder getOrCreateRpt(int index);
		@Override
		List<? extends TradeReport33Choice__1.TradeReport33Choice__1Builder> getRpt();
		TradeData59Choice__1.TradeData59Choice__1Builder addRpt(TradeReport33Choice__1 rpt);
		TradeData59Choice__1.TradeData59Choice__1Builder addRpt(TradeReport33Choice__1 rpt, int idx);
		TradeData59Choice__1.TradeData59Choice__1Builder addRpt(List<? extends TradeReport33Choice__1> rpt);
		TradeData59Choice__1.TradeData59Choice__1Builder setRpt(List<? extends TradeReport33Choice__1> rpt);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("rpt"), processor, TradeReport33Choice__1.TradeReport33Choice__1Builder.class, getRpt());
		}
		

		TradeData59Choice__1.TradeData59Choice__1Builder prune();
	}

	/*********************** Immutable Implementation of TradeData59Choice__1  ***********************/
	class TradeData59Choice__1Impl implements TradeData59Choice__1 {
		private final List<? extends TradeReport33Choice__1> rpt;
		
		protected TradeData59Choice__1Impl(TradeData59Choice__1.TradeData59Choice__1Builder builder) {
			this.rpt = ofNullable(builder.getRpt()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		@RosettaAttribute("rpt")
		@Accessor(AccessorType.GETTER)
		@Required
		@Multi
		@RuneAttribute("rpt")
		public List<? extends TradeReport33Choice__1> getRpt() {
			return rpt;
		}
		
		@Override
		public TradeData59Choice__1 build() {
			return this;
		}
		
		@Override
		public TradeData59Choice__1.TradeData59Choice__1Builder toBuilder() {
			TradeData59Choice__1.TradeData59Choice__1Builder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(TradeData59Choice__1.TradeData59Choice__1Builder builder) {
			ofNullable(getRpt()).ifPresent(builder::setRpt);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			TradeData59Choice__1 _that = getType().cast(o);
		
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
			return "TradeData59Choice__1 {" +
				"rpt=" + this.rpt +
			'}';
		}
	}

	/*********************** Builder Implementation of TradeData59Choice__1  ***********************/
	class TradeData59Choice__1BuilderImpl implements TradeData59Choice__1.TradeData59Choice__1Builder {
	
		protected List<TradeReport33Choice__1.TradeReport33Choice__1Builder> rpt = new ArrayList<>();
		
		@Override
		@RosettaAttribute("rpt")
		@Accessor(AccessorType.GETTER)
		@Required
		@Multi
		@RuneAttribute("rpt")
		public List<? extends TradeReport33Choice__1.TradeReport33Choice__1Builder> getRpt() {
			return rpt;
		}
		
		@Override
		public TradeReport33Choice__1.TradeReport33Choice__1Builder getOrCreateRpt(int index) {
			if (rpt==null) {
				this.rpt = new ArrayList<>();
			}
			return getIndex(rpt, index, () -> {
						TradeReport33Choice__1.TradeReport33Choice__1Builder newRpt = TradeReport33Choice__1.builder();
						return newRpt;
					});
		}
		
		@RosettaAttribute("rpt")
		@Accessor(AccessorType.ADDER)
		@Required
		@Multi
		@RuneAttribute("rpt")
		@Override
		public TradeData59Choice__1.TradeData59Choice__1Builder addRpt(TradeReport33Choice__1 _rpt) {
			if (_rpt != null) {
				this.rpt.add(_rpt.toBuilder());
			}
			return this;
		}
		
		@Override
		public TradeData59Choice__1.TradeData59Choice__1Builder addRpt(TradeReport33Choice__1 _rpt, int idx) {
			getIndex(this.rpt, idx, () -> _rpt.toBuilder());
			return this;
		}
		
		@Override
		public TradeData59Choice__1.TradeData59Choice__1Builder addRpt(List<? extends TradeReport33Choice__1> rpts) {
			if (rpts != null) {
				for (final TradeReport33Choice__1 toAdd : rpts) {
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
		public TradeData59Choice__1.TradeData59Choice__1Builder setRpt(List<? extends TradeReport33Choice__1> rpts) {
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
		public TradeData59Choice__1 build() {
			return new TradeData59Choice__1.TradeData59Choice__1Impl(this);
		}
		
		@Override
		public TradeData59Choice__1.TradeData59Choice__1Builder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public TradeData59Choice__1.TradeData59Choice__1Builder prune() {
			rpt = rpt.stream().filter(b->b!=null).<TradeReport33Choice__1.TradeReport33Choice__1Builder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getRpt()!=null && getRpt().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public TradeData59Choice__1.TradeData59Choice__1Builder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			TradeData59Choice__1.TradeData59Choice__1Builder o = (TradeData59Choice__1.TradeData59Choice__1Builder) other;
			
			merger.mergeRosetta(getRpt(), o.getRpt(), this::getOrCreateRpt);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			TradeData59Choice__1 _that = getType().cast(o);
		
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
			return "TradeData59Choice__1Builder {" +
				"rpt=" + this.rpt +
			'}';
		}
	}
}

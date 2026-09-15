package iso20022.auth108.hkma.dtcc;

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
import iso20022.auth108.hkma.dtcc.meta.TradeData61Choice__1Meta;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * Set of data concerning the reporting trade.
 * @version ${project.version}
 */
@RosettaDataType(value="TradeData61Choice__1", builder=TradeData61Choice__1.TradeData61Choice__1BuilderImpl.class, version="${project.version}")
@RuneDataType(value="TradeData61Choice__1", model="iso20022", builder=TradeData61Choice__1.TradeData61Choice__1BuilderImpl.class, version="${project.version}")
public interface TradeData61Choice__1 extends RosettaModelObject {

	TradeData61Choice__1Meta metaData = new TradeData61Choice__1Meta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Information concerning the reporting at transaction level.
	 */
	List<? extends TradeReport34Choice__1> getRpt();

	/*********************** Build Methods  ***********************/
	TradeData61Choice__1 build();
	
	TradeData61Choice__1.TradeData61Choice__1Builder toBuilder();
	
	static TradeData61Choice__1.TradeData61Choice__1Builder builder() {
		return new TradeData61Choice__1.TradeData61Choice__1BuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends TradeData61Choice__1> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends TradeData61Choice__1> getType() {
		return TradeData61Choice__1.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("rpt"), processor, TradeReport34Choice__1.class, getRpt());
	}
	

	/*********************** Builder Interface  ***********************/
	interface TradeData61Choice__1Builder extends TradeData61Choice__1, RosettaModelObjectBuilder {
		TradeReport34Choice__1.TradeReport34Choice__1Builder getOrCreateRpt(int index);
		@Override
		List<? extends TradeReport34Choice__1.TradeReport34Choice__1Builder> getRpt();
		TradeData61Choice__1.TradeData61Choice__1Builder addRpt(TradeReport34Choice__1 rpt);
		TradeData61Choice__1.TradeData61Choice__1Builder addRpt(TradeReport34Choice__1 rpt, int idx);
		TradeData61Choice__1.TradeData61Choice__1Builder addRpt(List<? extends TradeReport34Choice__1> rpt);
		TradeData61Choice__1.TradeData61Choice__1Builder setRpt(List<? extends TradeReport34Choice__1> rpt);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("rpt"), processor, TradeReport34Choice__1.TradeReport34Choice__1Builder.class, getRpt());
		}
		

		TradeData61Choice__1.TradeData61Choice__1Builder prune();
	}

	/*********************** Immutable Implementation of TradeData61Choice__1  ***********************/
	class TradeData61Choice__1Impl implements TradeData61Choice__1 {
		private final List<? extends TradeReport34Choice__1> rpt;
		
		protected TradeData61Choice__1Impl(TradeData61Choice__1.TradeData61Choice__1Builder builder) {
			this.rpt = ofNullable(builder.getRpt()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		@RosettaAttribute("rpt")
		@Accessor(AccessorType.GETTER)
		@Required
		@Multi
		@RuneAttribute("rpt")
		public List<? extends TradeReport34Choice__1> getRpt() {
			return rpt;
		}
		
		@Override
		public TradeData61Choice__1 build() {
			return this;
		}
		
		@Override
		public TradeData61Choice__1.TradeData61Choice__1Builder toBuilder() {
			TradeData61Choice__1.TradeData61Choice__1Builder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(TradeData61Choice__1.TradeData61Choice__1Builder builder) {
			ofNullable(getRpt()).ifPresent(builder::setRpt);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			TradeData61Choice__1 _that = getType().cast(o);
		
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
			return "TradeData61Choice__1 {" +
				"rpt=" + this.rpt +
			'}';
		}
	}

	/*********************** Builder Implementation of TradeData61Choice__1  ***********************/
	class TradeData61Choice__1BuilderImpl implements TradeData61Choice__1.TradeData61Choice__1Builder {
	
		protected List<TradeReport34Choice__1.TradeReport34Choice__1Builder> rpt = new ArrayList<>();
		
		@Override
		@RosettaAttribute("rpt")
		@Accessor(AccessorType.GETTER)
		@Required
		@Multi
		@RuneAttribute("rpt")
		public List<? extends TradeReport34Choice__1.TradeReport34Choice__1Builder> getRpt() {
			return rpt;
		}
		
		@Override
		public TradeReport34Choice__1.TradeReport34Choice__1Builder getOrCreateRpt(int index) {
			if (rpt==null) {
				this.rpt = new ArrayList<>();
			}
			return getIndex(rpt, index, () -> {
						TradeReport34Choice__1.TradeReport34Choice__1Builder newRpt = TradeReport34Choice__1.builder();
						return newRpt;
					});
		}
		
		@RosettaAttribute("rpt")
		@Accessor(AccessorType.ADDER)
		@Required
		@Multi
		@RuneAttribute("rpt")
		@Override
		public TradeData61Choice__1.TradeData61Choice__1Builder addRpt(TradeReport34Choice__1 _rpt) {
			if (_rpt != null) {
				this.rpt.add(_rpt.toBuilder());
			}
			return this;
		}
		
		@Override
		public TradeData61Choice__1.TradeData61Choice__1Builder addRpt(TradeReport34Choice__1 _rpt, int idx) {
			getIndex(this.rpt, idx, () -> _rpt.toBuilder());
			return this;
		}
		
		@Override
		public TradeData61Choice__1.TradeData61Choice__1Builder addRpt(List<? extends TradeReport34Choice__1> rpts) {
			if (rpts != null) {
				for (final TradeReport34Choice__1 toAdd : rpts) {
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
		public TradeData61Choice__1.TradeData61Choice__1Builder setRpt(List<? extends TradeReport34Choice__1> rpts) {
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
		public TradeData61Choice__1 build() {
			return new TradeData61Choice__1.TradeData61Choice__1Impl(this);
		}
		
		@Override
		public TradeData61Choice__1.TradeData61Choice__1Builder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public TradeData61Choice__1.TradeData61Choice__1Builder prune() {
			rpt = rpt.stream().filter(b->b!=null).<TradeReport34Choice__1.TradeReport34Choice__1Builder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getRpt()!=null && getRpt().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public TradeData61Choice__1.TradeData61Choice__1Builder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			TradeData61Choice__1.TradeData61Choice__1Builder o = (TradeData61Choice__1.TradeData61Choice__1Builder) other;
			
			merger.mergeRosetta(getRpt(), o.getRpt(), this::getOrCreateRpt);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			TradeData61Choice__1 _that = getType().cast(o);
		
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
			return "TradeData61Choice__1Builder {" +
				"rpt=" + this.rpt +
			'}';
		}
	}
}

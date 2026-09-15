package fpml.consolidated.reg.fpmlreporting.product;

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
import fpml.consolidated.generic.TradeUnderlyer2;
import fpml.consolidated.reg.fpmlreporting.product.meta.RegulatoryReportingProductUnderlyersMeta;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "recordkeeping-5.13"
 *
 * Provision At the moment all of the underlyer information is non-CDE, as CPMI-IOSCO CDE doesn not define underlier information. Instead, it relies on the UPI to convey this information. DEPRECATED. Reason: Not used, deprecated parent element. (RPTWG decision 2024-05-30)
 *
 */
@RosettaDataType(value="RegulatoryReportingProductUnderlyers", builder=RegulatoryReportingProductUnderlyers.RegulatoryReportingProductUnderlyersBuilderImpl.class, version="2.1.1")
@RuneDataType(value="RegulatoryReportingProductUnderlyers", model="fpml", builder=RegulatoryReportingProductUnderlyers.RegulatoryReportingProductUnderlyersBuilderImpl.class, version="2.1.1")
public interface RegulatoryReportingProductUnderlyers extends RosettaModelObject {

	RegulatoryReportingProductUnderlyersMeta metaData = new RegulatoryReportingProductUnderlyersMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision 
	 *
	 */
	List<? extends TradeUnderlyer2> getUnderlyer();

	/*********************** Build Methods  ***********************/
	RegulatoryReportingProductUnderlyers build();
	
	RegulatoryReportingProductUnderlyers.RegulatoryReportingProductUnderlyersBuilder toBuilder();
	
	static RegulatoryReportingProductUnderlyers.RegulatoryReportingProductUnderlyersBuilder builder() {
		return new RegulatoryReportingProductUnderlyers.RegulatoryReportingProductUnderlyersBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends RegulatoryReportingProductUnderlyers> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends RegulatoryReportingProductUnderlyers> getType() {
		return RegulatoryReportingProductUnderlyers.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("underlyer"), processor, TradeUnderlyer2.class, getUnderlyer());
	}
	

	/*********************** Builder Interface  ***********************/
	interface RegulatoryReportingProductUnderlyersBuilder extends RegulatoryReportingProductUnderlyers, RosettaModelObjectBuilder {
		TradeUnderlyer2.TradeUnderlyer2Builder getOrCreateUnderlyer(int index);
		@Override
		List<? extends TradeUnderlyer2.TradeUnderlyer2Builder> getUnderlyer();
		RegulatoryReportingProductUnderlyers.RegulatoryReportingProductUnderlyersBuilder addUnderlyer(TradeUnderlyer2 underlyer);
		RegulatoryReportingProductUnderlyers.RegulatoryReportingProductUnderlyersBuilder addUnderlyer(TradeUnderlyer2 underlyer, int idx);
		RegulatoryReportingProductUnderlyers.RegulatoryReportingProductUnderlyersBuilder addUnderlyer(List<? extends TradeUnderlyer2> underlyer);
		RegulatoryReportingProductUnderlyers.RegulatoryReportingProductUnderlyersBuilder setUnderlyer(List<? extends TradeUnderlyer2> underlyer);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("underlyer"), processor, TradeUnderlyer2.TradeUnderlyer2Builder.class, getUnderlyer());
		}
		

		RegulatoryReportingProductUnderlyers.RegulatoryReportingProductUnderlyersBuilder prune();
	}

	/*********************** Immutable Implementation of RegulatoryReportingProductUnderlyers  ***********************/
	class RegulatoryReportingProductUnderlyersImpl implements RegulatoryReportingProductUnderlyers {
		private final List<? extends TradeUnderlyer2> underlyer;
		
		protected RegulatoryReportingProductUnderlyersImpl(RegulatoryReportingProductUnderlyers.RegulatoryReportingProductUnderlyersBuilder builder) {
			this.underlyer = ofNullable(builder.getUnderlyer()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		@RosettaAttribute("underlyer")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("underlyer")
		public List<? extends TradeUnderlyer2> getUnderlyer() {
			return underlyer;
		}
		
		@Override
		public RegulatoryReportingProductUnderlyers build() {
			return this;
		}
		
		@Override
		public RegulatoryReportingProductUnderlyers.RegulatoryReportingProductUnderlyersBuilder toBuilder() {
			RegulatoryReportingProductUnderlyers.RegulatoryReportingProductUnderlyersBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(RegulatoryReportingProductUnderlyers.RegulatoryReportingProductUnderlyersBuilder builder) {
			ofNullable(getUnderlyer()).ifPresent(builder::setUnderlyer);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			RegulatoryReportingProductUnderlyers _that = getType().cast(o);
		
			if (!ListEquals.listEquals(underlyer, _that.getUnderlyer())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (underlyer != null ? underlyer.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "RegulatoryReportingProductUnderlyers {" +
				"underlyer=" + this.underlyer +
			'}';
		}
	}

	/*********************** Builder Implementation of RegulatoryReportingProductUnderlyers  ***********************/
	class RegulatoryReportingProductUnderlyersBuilderImpl implements RegulatoryReportingProductUnderlyers.RegulatoryReportingProductUnderlyersBuilder {
	
		protected List<TradeUnderlyer2.TradeUnderlyer2Builder> underlyer = new ArrayList<>();
		
		@Override
		@RosettaAttribute("underlyer")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("underlyer")
		public List<? extends TradeUnderlyer2.TradeUnderlyer2Builder> getUnderlyer() {
			return underlyer;
		}
		
		@Override
		public TradeUnderlyer2.TradeUnderlyer2Builder getOrCreateUnderlyer(int index) {
			if (underlyer==null) {
				this.underlyer = new ArrayList<>();
			}
			return getIndex(underlyer, index, () -> {
						TradeUnderlyer2.TradeUnderlyer2Builder newUnderlyer = TradeUnderlyer2.builder();
						return newUnderlyer;
					});
		}
		
		@RosettaAttribute("underlyer")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("underlyer")
		@Override
		public RegulatoryReportingProductUnderlyers.RegulatoryReportingProductUnderlyersBuilder addUnderlyer(TradeUnderlyer2 _underlyer) {
			if (_underlyer != null) {
				this.underlyer.add(_underlyer.toBuilder());
			}
			return this;
		}
		
		@Override
		public RegulatoryReportingProductUnderlyers.RegulatoryReportingProductUnderlyersBuilder addUnderlyer(TradeUnderlyer2 _underlyer, int idx) {
			getIndex(this.underlyer, idx, () -> _underlyer.toBuilder());
			return this;
		}
		
		@Override
		public RegulatoryReportingProductUnderlyers.RegulatoryReportingProductUnderlyersBuilder addUnderlyer(List<? extends TradeUnderlyer2> underlyers) {
			if (underlyers != null) {
				for (final TradeUnderlyer2 toAdd : underlyers) {
					this.underlyer.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("underlyer")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("underlyer")
		@Override
		public RegulatoryReportingProductUnderlyers.RegulatoryReportingProductUnderlyersBuilder setUnderlyer(List<? extends TradeUnderlyer2> underlyers) {
			if (underlyers == null) {
				this.underlyer = new ArrayList<>();
			} else {
				this.underlyer = underlyers.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		public RegulatoryReportingProductUnderlyers build() {
			return new RegulatoryReportingProductUnderlyers.RegulatoryReportingProductUnderlyersImpl(this);
		}
		
		@Override
		public RegulatoryReportingProductUnderlyers.RegulatoryReportingProductUnderlyersBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public RegulatoryReportingProductUnderlyers.RegulatoryReportingProductUnderlyersBuilder prune() {
			underlyer = underlyer.stream().filter(b->b!=null).<TradeUnderlyer2.TradeUnderlyer2Builder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getUnderlyer()!=null && getUnderlyer().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public RegulatoryReportingProductUnderlyers.RegulatoryReportingProductUnderlyersBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			RegulatoryReportingProductUnderlyers.RegulatoryReportingProductUnderlyersBuilder o = (RegulatoryReportingProductUnderlyers.RegulatoryReportingProductUnderlyersBuilder) other;
			
			merger.mergeRosetta(getUnderlyer(), o.getUnderlyer(), this::getOrCreateUnderlyer);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			RegulatoryReportingProductUnderlyers _that = getType().cast(o);
		
			if (!ListEquals.listEquals(underlyer, _that.getUnderlyer())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (underlyer != null ? underlyer.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "RegulatoryReportingProductUnderlyersBuilder {" +
				"underlyer=" + this.underlyer +
			'}';
		}
	}
}

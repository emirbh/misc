package fpml.consolidated.com;

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
import fpml.consolidated.com.meta.CommodityBasketByNotionalMeta;
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
 * Provision 
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision 
 *
 */
@RosettaDataType(value="CommodityBasketByNotional", builder=CommodityBasketByNotional.CommodityBasketByNotionalBuilderImpl.class, version="2.1.1")
@RuneDataType(value="CommodityBasketByNotional", model="fpml", builder=CommodityBasketByNotional.CommodityBasketByNotionalBuilderImpl.class, version="2.1.1")
public interface CommodityBasketByNotional extends CommodityBasketBase {

	CommodityBasketByNotionalMeta metaData = new CommodityBasketByNotionalMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Indicates the role of the option buyer with regard to this underlyer.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Indicates the role of the option buyer with regard to this underlyer.
	 *
	 */
	List<? extends CommodityBasketUnderlyingByNotional> getUnderlying();

	/*********************** Build Methods  ***********************/
	CommodityBasketByNotional build();
	
	CommodityBasketByNotional.CommodityBasketByNotionalBuilder toBuilder();
	
	static CommodityBasketByNotional.CommodityBasketByNotionalBuilder builder() {
		return new CommodityBasketByNotional.CommodityBasketByNotionalBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends CommodityBasketByNotional> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends CommodityBasketByNotional> getType() {
		return CommodityBasketByNotional.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		processRosetta(path.newSubPath("underlying"), processor, CommodityBasketUnderlyingByNotional.class, getUnderlying());
	}
	

	/*********************** Builder Interface  ***********************/
	interface CommodityBasketByNotionalBuilder extends CommodityBasketByNotional, CommodityBasketBase.CommodityBasketBaseBuilder {
		CommodityBasketUnderlyingByNotional.CommodityBasketUnderlyingByNotionalBuilder getOrCreateUnderlying(int index);
		@Override
		List<? extends CommodityBasketUnderlyingByNotional.CommodityBasketUnderlyingByNotionalBuilder> getUnderlying();
		@Override
		CommodityBasketByNotional.CommodityBasketByNotionalBuilder setId(String id);
		CommodityBasketByNotional.CommodityBasketByNotionalBuilder addUnderlying(CommodityBasketUnderlyingByNotional underlying);
		CommodityBasketByNotional.CommodityBasketByNotionalBuilder addUnderlying(CommodityBasketUnderlyingByNotional underlying, int idx);
		CommodityBasketByNotional.CommodityBasketByNotionalBuilder addUnderlying(List<? extends CommodityBasketUnderlyingByNotional> underlying);
		CommodityBasketByNotional.CommodityBasketByNotionalBuilder setUnderlying(List<? extends CommodityBasketUnderlyingByNotional> underlying);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
			processRosetta(path.newSubPath("underlying"), processor, CommodityBasketUnderlyingByNotional.CommodityBasketUnderlyingByNotionalBuilder.class, getUnderlying());
		}
		

		CommodityBasketByNotional.CommodityBasketByNotionalBuilder prune();
	}

	/*********************** Immutable Implementation of CommodityBasketByNotional  ***********************/
	class CommodityBasketByNotionalImpl extends CommodityBasketBase.CommodityBasketBaseImpl implements CommodityBasketByNotional {
		private final List<? extends CommodityBasketUnderlyingByNotional> underlying;
		
		protected CommodityBasketByNotionalImpl(CommodityBasketByNotional.CommodityBasketByNotionalBuilder builder) {
			super(builder);
			this.underlying = ofNullable(builder.getUnderlying()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		@RosettaAttribute("underlying")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("underlying")
		public List<? extends CommodityBasketUnderlyingByNotional> getUnderlying() {
			return underlying;
		}
		
		@Override
		public CommodityBasketByNotional build() {
			return this;
		}
		
		@Override
		public CommodityBasketByNotional.CommodityBasketByNotionalBuilder toBuilder() {
			CommodityBasketByNotional.CommodityBasketByNotionalBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CommodityBasketByNotional.CommodityBasketByNotionalBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getUnderlying()).ifPresent(builder::setUnderlying);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			CommodityBasketByNotional _that = getType().cast(o);
		
			if (!ListEquals.listEquals(underlying, _that.getUnderlying())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (underlying != null ? underlying.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CommodityBasketByNotional {" +
				"underlying=" + this.underlying +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of CommodityBasketByNotional  ***********************/
	class CommodityBasketByNotionalBuilderImpl extends CommodityBasketBase.CommodityBasketBaseBuilderImpl implements CommodityBasketByNotional.CommodityBasketByNotionalBuilder {
	
		protected List<CommodityBasketUnderlyingByNotional.CommodityBasketUnderlyingByNotionalBuilder> underlying = new ArrayList<>();
		
		@Override
		@RosettaAttribute("underlying")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("underlying")
		public List<? extends CommodityBasketUnderlyingByNotional.CommodityBasketUnderlyingByNotionalBuilder> getUnderlying() {
			return underlying;
		}
		
		@Override
		public CommodityBasketUnderlyingByNotional.CommodityBasketUnderlyingByNotionalBuilder getOrCreateUnderlying(int index) {
			if (underlying==null) {
				this.underlying = new ArrayList<>();
			}
			return getIndex(underlying, index, () -> {
						CommodityBasketUnderlyingByNotional.CommodityBasketUnderlyingByNotionalBuilder newUnderlying = CommodityBasketUnderlyingByNotional.builder();
						return newUnderlying;
					});
		}
		
		@RosettaAttribute("id")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("id")
		@Override
		public CommodityBasketByNotional.CommodityBasketByNotionalBuilder setId(String _id) {
			this.id = _id == null ? null : _id;
			return this;
		}
		
		@RosettaAttribute("underlying")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("underlying")
		@Override
		public CommodityBasketByNotional.CommodityBasketByNotionalBuilder addUnderlying(CommodityBasketUnderlyingByNotional _underlying) {
			if (_underlying != null) {
				this.underlying.add(_underlying.toBuilder());
			}
			return this;
		}
		
		@Override
		public CommodityBasketByNotional.CommodityBasketByNotionalBuilder addUnderlying(CommodityBasketUnderlyingByNotional _underlying, int idx) {
			getIndex(this.underlying, idx, () -> _underlying.toBuilder());
			return this;
		}
		
		@Override
		public CommodityBasketByNotional.CommodityBasketByNotionalBuilder addUnderlying(List<? extends CommodityBasketUnderlyingByNotional> underlyings) {
			if (underlyings != null) {
				for (final CommodityBasketUnderlyingByNotional toAdd : underlyings) {
					this.underlying.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("underlying")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("underlying")
		@Override
		public CommodityBasketByNotional.CommodityBasketByNotionalBuilder setUnderlying(List<? extends CommodityBasketUnderlyingByNotional> underlyings) {
			if (underlyings == null) {
				this.underlying = new ArrayList<>();
			} else {
				this.underlying = underlyings.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		public CommodityBasketByNotional build() {
			return new CommodityBasketByNotional.CommodityBasketByNotionalImpl(this);
		}
		
		@Override
		public CommodityBasketByNotional.CommodityBasketByNotionalBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CommodityBasketByNotional.CommodityBasketByNotionalBuilder prune() {
			super.prune();
			underlying = underlying.stream().filter(b->b!=null).<CommodityBasketUnderlyingByNotional.CommodityBasketUnderlyingByNotionalBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getUnderlying()!=null && getUnderlying().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CommodityBasketByNotional.CommodityBasketByNotionalBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			CommodityBasketByNotional.CommodityBasketByNotionalBuilder o = (CommodityBasketByNotional.CommodityBasketByNotionalBuilder) other;
			
			merger.mergeRosetta(getUnderlying(), o.getUnderlying(), this::getOrCreateUnderlying);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			CommodityBasketByNotional _that = getType().cast(o);
		
			if (!ListEquals.listEquals(underlying, _that.getUnderlying())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (underlying != null ? underlying.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CommodityBasketByNotionalBuilder {" +
				"underlying=" + this.underlying +
			'}' + " " + super.toString();
		}
	}
}

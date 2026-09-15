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
import fpml.consolidated.com.meta.CommodityBasketByPercentageMeta;
import fpml.consolidated.shared.NotionalAmount;
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
@RosettaDataType(value="CommodityBasketByPercentage", builder=CommodityBasketByPercentage.CommodityBasketByPercentageBuilderImpl.class, version="2.1.1")
@RuneDataType(value="CommodityBasketByPercentage", model="fpml", builder=CommodityBasketByPercentage.CommodityBasketByPercentageBuilderImpl.class, version="2.1.1")
public interface CommodityBasketByPercentage extends CommodityBasketBase {

	CommodityBasketByPercentageMeta metaData = new CommodityBasketByPercentageMeta();

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
	List<? extends CommodityBasketUnderlyingByPercentage> getUnderlying();
	/**
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
	NotionalAmount getNotionalAmount();

	/*********************** Build Methods  ***********************/
	CommodityBasketByPercentage build();
	
	CommodityBasketByPercentage.CommodityBasketByPercentageBuilder toBuilder();
	
	static CommodityBasketByPercentage.CommodityBasketByPercentageBuilder builder() {
		return new CommodityBasketByPercentage.CommodityBasketByPercentageBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends CommodityBasketByPercentage> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends CommodityBasketByPercentage> getType() {
		return CommodityBasketByPercentage.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		processRosetta(path.newSubPath("underlying"), processor, CommodityBasketUnderlyingByPercentage.class, getUnderlying());
		processRosetta(path.newSubPath("notionalAmount"), processor, NotionalAmount.class, getNotionalAmount());
	}
	

	/*********************** Builder Interface  ***********************/
	interface CommodityBasketByPercentageBuilder extends CommodityBasketByPercentage, CommodityBasketBase.CommodityBasketBaseBuilder {
		CommodityBasketUnderlyingByPercentage.CommodityBasketUnderlyingByPercentageBuilder getOrCreateUnderlying(int index);
		@Override
		List<? extends CommodityBasketUnderlyingByPercentage.CommodityBasketUnderlyingByPercentageBuilder> getUnderlying();
		NotionalAmount.NotionalAmountBuilder getOrCreateNotionalAmount();
		@Override
		NotionalAmount.NotionalAmountBuilder getNotionalAmount();
		@Override
		CommodityBasketByPercentage.CommodityBasketByPercentageBuilder setId(String id);
		CommodityBasketByPercentage.CommodityBasketByPercentageBuilder addUnderlying(CommodityBasketUnderlyingByPercentage underlying);
		CommodityBasketByPercentage.CommodityBasketByPercentageBuilder addUnderlying(CommodityBasketUnderlyingByPercentage underlying, int idx);
		CommodityBasketByPercentage.CommodityBasketByPercentageBuilder addUnderlying(List<? extends CommodityBasketUnderlyingByPercentage> underlying);
		CommodityBasketByPercentage.CommodityBasketByPercentageBuilder setUnderlying(List<? extends CommodityBasketUnderlyingByPercentage> underlying);
		CommodityBasketByPercentage.CommodityBasketByPercentageBuilder setNotionalAmount(NotionalAmount notionalAmount);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
			processRosetta(path.newSubPath("underlying"), processor, CommodityBasketUnderlyingByPercentage.CommodityBasketUnderlyingByPercentageBuilder.class, getUnderlying());
			processRosetta(path.newSubPath("notionalAmount"), processor, NotionalAmount.NotionalAmountBuilder.class, getNotionalAmount());
		}
		

		CommodityBasketByPercentage.CommodityBasketByPercentageBuilder prune();
	}

	/*********************** Immutable Implementation of CommodityBasketByPercentage  ***********************/
	class CommodityBasketByPercentageImpl extends CommodityBasketBase.CommodityBasketBaseImpl implements CommodityBasketByPercentage {
		private final List<? extends CommodityBasketUnderlyingByPercentage> underlying;
		private final NotionalAmount notionalAmount;
		
		protected CommodityBasketByPercentageImpl(CommodityBasketByPercentage.CommodityBasketByPercentageBuilder builder) {
			super(builder);
			this.underlying = ofNullable(builder.getUnderlying()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.notionalAmount = ofNullable(builder.getNotionalAmount()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("underlying")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("underlying")
		public List<? extends CommodityBasketUnderlyingByPercentage> getUnderlying() {
			return underlying;
		}
		
		@Override
		@RosettaAttribute("notionalAmount")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("notionalAmount")
		public NotionalAmount getNotionalAmount() {
			return notionalAmount;
		}
		
		@Override
		public CommodityBasketByPercentage build() {
			return this;
		}
		
		@Override
		public CommodityBasketByPercentage.CommodityBasketByPercentageBuilder toBuilder() {
			CommodityBasketByPercentage.CommodityBasketByPercentageBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CommodityBasketByPercentage.CommodityBasketByPercentageBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getUnderlying()).ifPresent(builder::setUnderlying);
			ofNullable(getNotionalAmount()).ifPresent(builder::setNotionalAmount);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			CommodityBasketByPercentage _that = getType().cast(o);
		
			if (!ListEquals.listEquals(underlying, _that.getUnderlying())) return false;
			if (!Objects.equals(notionalAmount, _that.getNotionalAmount())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (underlying != null ? underlying.hashCode() : 0);
			_result = 31 * _result + (notionalAmount != null ? notionalAmount.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CommodityBasketByPercentage {" +
				"underlying=" + this.underlying + ", " +
				"notionalAmount=" + this.notionalAmount +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of CommodityBasketByPercentage  ***********************/
	class CommodityBasketByPercentageBuilderImpl extends CommodityBasketBase.CommodityBasketBaseBuilderImpl implements CommodityBasketByPercentage.CommodityBasketByPercentageBuilder {
	
		protected List<CommodityBasketUnderlyingByPercentage.CommodityBasketUnderlyingByPercentageBuilder> underlying = new ArrayList<>();
		protected NotionalAmount.NotionalAmountBuilder notionalAmount;
		
		@Override
		@RosettaAttribute("underlying")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("underlying")
		public List<? extends CommodityBasketUnderlyingByPercentage.CommodityBasketUnderlyingByPercentageBuilder> getUnderlying() {
			return underlying;
		}
		
		@Override
		public CommodityBasketUnderlyingByPercentage.CommodityBasketUnderlyingByPercentageBuilder getOrCreateUnderlying(int index) {
			if (underlying==null) {
				this.underlying = new ArrayList<>();
			}
			return getIndex(underlying, index, () -> {
						CommodityBasketUnderlyingByPercentage.CommodityBasketUnderlyingByPercentageBuilder newUnderlying = CommodityBasketUnderlyingByPercentage.builder();
						return newUnderlying;
					});
		}
		
		@Override
		@RosettaAttribute("notionalAmount")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("notionalAmount")
		public NotionalAmount.NotionalAmountBuilder getNotionalAmount() {
			return notionalAmount;
		}
		
		@Override
		public NotionalAmount.NotionalAmountBuilder getOrCreateNotionalAmount() {
			NotionalAmount.NotionalAmountBuilder result;
			if (notionalAmount!=null) {
				result = notionalAmount;
			}
			else {
				result = notionalAmount = NotionalAmount.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("id")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("id")
		@Override
		public CommodityBasketByPercentage.CommodityBasketByPercentageBuilder setId(String _id) {
			this.id = _id == null ? null : _id;
			return this;
		}
		
		@RosettaAttribute("underlying")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("underlying")
		@Override
		public CommodityBasketByPercentage.CommodityBasketByPercentageBuilder addUnderlying(CommodityBasketUnderlyingByPercentage _underlying) {
			if (_underlying != null) {
				this.underlying.add(_underlying.toBuilder());
			}
			return this;
		}
		
		@Override
		public CommodityBasketByPercentage.CommodityBasketByPercentageBuilder addUnderlying(CommodityBasketUnderlyingByPercentage _underlying, int idx) {
			getIndex(this.underlying, idx, () -> _underlying.toBuilder());
			return this;
		}
		
		@Override
		public CommodityBasketByPercentage.CommodityBasketByPercentageBuilder addUnderlying(List<? extends CommodityBasketUnderlyingByPercentage> underlyings) {
			if (underlyings != null) {
				for (final CommodityBasketUnderlyingByPercentage toAdd : underlyings) {
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
		public CommodityBasketByPercentage.CommodityBasketByPercentageBuilder setUnderlying(List<? extends CommodityBasketUnderlyingByPercentage> underlyings) {
			if (underlyings == null) {
				this.underlying = new ArrayList<>();
			} else {
				this.underlying = underlyings.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("notionalAmount")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("notionalAmount")
		@Override
		public CommodityBasketByPercentage.CommodityBasketByPercentageBuilder setNotionalAmount(NotionalAmount _notionalAmount) {
			this.notionalAmount = _notionalAmount == null ? null : _notionalAmount.toBuilder();
			return this;
		}
		
		@Override
		public CommodityBasketByPercentage build() {
			return new CommodityBasketByPercentage.CommodityBasketByPercentageImpl(this);
		}
		
		@Override
		public CommodityBasketByPercentage.CommodityBasketByPercentageBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CommodityBasketByPercentage.CommodityBasketByPercentageBuilder prune() {
			super.prune();
			underlying = underlying.stream().filter(b->b!=null).<CommodityBasketUnderlyingByPercentage.CommodityBasketUnderlyingByPercentageBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			if (notionalAmount!=null && !notionalAmount.prune().hasData()) notionalAmount = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getUnderlying()!=null && getUnderlying().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getNotionalAmount()!=null && getNotionalAmount().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CommodityBasketByPercentage.CommodityBasketByPercentageBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			CommodityBasketByPercentage.CommodityBasketByPercentageBuilder o = (CommodityBasketByPercentage.CommodityBasketByPercentageBuilder) other;
			
			merger.mergeRosetta(getUnderlying(), o.getUnderlying(), this::getOrCreateUnderlying);
			merger.mergeRosetta(getNotionalAmount(), o.getNotionalAmount(), this::setNotionalAmount);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			CommodityBasketByPercentage _that = getType().cast(o);
		
			if (!ListEquals.listEquals(underlying, _that.getUnderlying())) return false;
			if (!Objects.equals(notionalAmount, _that.getNotionalAmount())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (underlying != null ? underlying.hashCode() : 0);
			_result = 31 * _result + (notionalAmount != null ? notionalAmount.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CommodityBasketByPercentageBuilder {" +
				"underlying=" + this.underlying + ", " +
				"notionalAmount=" + this.notionalAmount +
			'}' + " " + super.toString();
		}
	}
}

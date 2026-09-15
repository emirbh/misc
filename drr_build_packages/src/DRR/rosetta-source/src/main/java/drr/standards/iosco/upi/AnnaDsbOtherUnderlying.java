package drr.standards.iosco.upi;

import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.Accessor;
import com.rosetta.model.lib.annotations.AccessorType;
import com.rosetta.model.lib.annotations.RosettaAttribute;
import com.rosetta.model.lib.annotations.RosettaDataType;
import com.rosetta.model.lib.annotations.RuneAttribute;
import com.rosetta.model.lib.annotations.RuneDataType;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.process.BuilderMerger;
import com.rosetta.model.lib.process.BuilderProcessor;
import com.rosetta.model.lib.process.Processor;
import drr.standards.iosco.upi.meta.AnnaDsbOtherUnderlyingMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 7.7.0
 */
@RosettaDataType(value="AnnaDsbOtherUnderlying", builder=AnnaDsbOtherUnderlying.AnnaDsbOtherUnderlyingBuilderImpl.class, version="7.7.0")
@RuneDataType(value="AnnaDsbOtherUnderlying", model="drr", builder=AnnaDsbOtherUnderlying.AnnaDsbOtherUnderlyingBuilderImpl.class, version="7.7.0")
public interface AnnaDsbOtherUnderlying extends RosettaModelObject {

	AnnaDsbOtherUnderlyingMeta metaData = new AnnaDsbOtherUnderlyingMeta();

	/*********************** Getter Methods  ***********************/
	AnnaDsbOtherUnderlierIDSourceEnum getOtherUnderlierIDSource();
	String getOtherUnderlierID();
	AnnaDsbEmpty getBasket();

	/*********************** Build Methods  ***********************/
	AnnaDsbOtherUnderlying build();
	
	AnnaDsbOtherUnderlying.AnnaDsbOtherUnderlyingBuilder toBuilder();
	
	static AnnaDsbOtherUnderlying.AnnaDsbOtherUnderlyingBuilder builder() {
		return new AnnaDsbOtherUnderlying.AnnaDsbOtherUnderlyingBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends AnnaDsbOtherUnderlying> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends AnnaDsbOtherUnderlying> getType() {
		return AnnaDsbOtherUnderlying.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("OtherUnderlierIDSource"), AnnaDsbOtherUnderlierIDSourceEnum.class, getOtherUnderlierIDSource(), this);
		processor.processBasic(path.newSubPath("OtherUnderlierID"), String.class, getOtherUnderlierID(), this);
		processRosetta(path.newSubPath("Basket"), processor, AnnaDsbEmpty.class, getBasket());
	}
	

	/*********************** Builder Interface  ***********************/
	interface AnnaDsbOtherUnderlyingBuilder extends AnnaDsbOtherUnderlying, RosettaModelObjectBuilder {
		AnnaDsbEmpty.AnnaDsbEmptyBuilder getOrCreateBasket();
		@Override
		AnnaDsbEmpty.AnnaDsbEmptyBuilder getBasket();
		AnnaDsbOtherUnderlying.AnnaDsbOtherUnderlyingBuilder setOtherUnderlierIDSource(AnnaDsbOtherUnderlierIDSourceEnum OtherUnderlierIDSource);
		AnnaDsbOtherUnderlying.AnnaDsbOtherUnderlyingBuilder setOtherUnderlierID(String OtherUnderlierID);
		AnnaDsbOtherUnderlying.AnnaDsbOtherUnderlyingBuilder setBasket(AnnaDsbEmpty Basket);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("OtherUnderlierIDSource"), AnnaDsbOtherUnderlierIDSourceEnum.class, getOtherUnderlierIDSource(), this);
			processor.processBasic(path.newSubPath("OtherUnderlierID"), String.class, getOtherUnderlierID(), this);
			processRosetta(path.newSubPath("Basket"), processor, AnnaDsbEmpty.AnnaDsbEmptyBuilder.class, getBasket());
		}
		

		AnnaDsbOtherUnderlying.AnnaDsbOtherUnderlyingBuilder prune();
	}

	/*********************** Immutable Implementation of AnnaDsbOtherUnderlying  ***********************/
	class AnnaDsbOtherUnderlyingImpl implements AnnaDsbOtherUnderlying {
		private final AnnaDsbOtherUnderlierIDSourceEnum otherUnderlierIDSource;
		private final String otherUnderlierID;
		private final AnnaDsbEmpty basket;
		
		protected AnnaDsbOtherUnderlyingImpl(AnnaDsbOtherUnderlying.AnnaDsbOtherUnderlyingBuilder builder) {
			this.otherUnderlierIDSource = builder.getOtherUnderlierIDSource();
			this.otherUnderlierID = builder.getOtherUnderlierID();
			this.basket = ofNullable(builder.getBasket()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("OtherUnderlierIDSource")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("OtherUnderlierIDSource")
		public AnnaDsbOtherUnderlierIDSourceEnum getOtherUnderlierIDSource() {
			return otherUnderlierIDSource;
		}
		
		@Override
		@RosettaAttribute("OtherUnderlierID")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("OtherUnderlierID")
		public String getOtherUnderlierID() {
			return otherUnderlierID;
		}
		
		@Override
		@RosettaAttribute("Basket")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("Basket")
		public AnnaDsbEmpty getBasket() {
			return basket;
		}
		
		@Override
		public AnnaDsbOtherUnderlying build() {
			return this;
		}
		
		@Override
		public AnnaDsbOtherUnderlying.AnnaDsbOtherUnderlyingBuilder toBuilder() {
			AnnaDsbOtherUnderlying.AnnaDsbOtherUnderlyingBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(AnnaDsbOtherUnderlying.AnnaDsbOtherUnderlyingBuilder builder) {
			ofNullable(getOtherUnderlierIDSource()).ifPresent(builder::setOtherUnderlierIDSource);
			ofNullable(getOtherUnderlierID()).ifPresent(builder::setOtherUnderlierID);
			ofNullable(getBasket()).ifPresent(builder::setBasket);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			AnnaDsbOtherUnderlying _that = getType().cast(o);
		
			if (!Objects.equals(otherUnderlierIDSource, _that.getOtherUnderlierIDSource())) return false;
			if (!Objects.equals(otherUnderlierID, _that.getOtherUnderlierID())) return false;
			if (!Objects.equals(basket, _that.getBasket())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (otherUnderlierIDSource != null ? otherUnderlierIDSource.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (otherUnderlierID != null ? otherUnderlierID.hashCode() : 0);
			_result = 31 * _result + (basket != null ? basket.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AnnaDsbOtherUnderlying {" +
				"OtherUnderlierIDSource=" + this.otherUnderlierIDSource + ", " +
				"OtherUnderlierID=" + this.otherUnderlierID + ", " +
				"Basket=" + this.basket +
			'}';
		}
	}

	/*********************** Builder Implementation of AnnaDsbOtherUnderlying  ***********************/
	class AnnaDsbOtherUnderlyingBuilderImpl implements AnnaDsbOtherUnderlying.AnnaDsbOtherUnderlyingBuilder {
	
		protected AnnaDsbOtherUnderlierIDSourceEnum otherUnderlierIDSource;
		protected String otherUnderlierID;
		protected AnnaDsbEmpty.AnnaDsbEmptyBuilder basket;
		
		@Override
		@RosettaAttribute("OtherUnderlierIDSource")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("OtherUnderlierIDSource")
		public AnnaDsbOtherUnderlierIDSourceEnum getOtherUnderlierIDSource() {
			return otherUnderlierIDSource;
		}
		
		@Override
		@RosettaAttribute("OtherUnderlierID")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("OtherUnderlierID")
		public String getOtherUnderlierID() {
			return otherUnderlierID;
		}
		
		@Override
		@RosettaAttribute("Basket")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("Basket")
		public AnnaDsbEmpty.AnnaDsbEmptyBuilder getBasket() {
			return basket;
		}
		
		@Override
		public AnnaDsbEmpty.AnnaDsbEmptyBuilder getOrCreateBasket() {
			AnnaDsbEmpty.AnnaDsbEmptyBuilder result;
			if (basket!=null) {
				result = basket;
			}
			else {
				result = basket = AnnaDsbEmpty.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("OtherUnderlierIDSource")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("OtherUnderlierIDSource")
		@Override
		public AnnaDsbOtherUnderlying.AnnaDsbOtherUnderlyingBuilder setOtherUnderlierIDSource(AnnaDsbOtherUnderlierIDSourceEnum _otherUnderlierIDSource) {
			this.otherUnderlierIDSource = _otherUnderlierIDSource == null ? null : _otherUnderlierIDSource;
			return this;
		}
		
		@RosettaAttribute("OtherUnderlierID")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("OtherUnderlierID")
		@Override
		public AnnaDsbOtherUnderlying.AnnaDsbOtherUnderlyingBuilder setOtherUnderlierID(String _otherUnderlierID) {
			this.otherUnderlierID = _otherUnderlierID == null ? null : _otherUnderlierID;
			return this;
		}
		
		@RosettaAttribute("Basket")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("Basket")
		@Override
		public AnnaDsbOtherUnderlying.AnnaDsbOtherUnderlyingBuilder setBasket(AnnaDsbEmpty _basket) {
			this.basket = _basket == null ? null : _basket.toBuilder();
			return this;
		}
		
		@Override
		public AnnaDsbOtherUnderlying build() {
			return new AnnaDsbOtherUnderlying.AnnaDsbOtherUnderlyingImpl(this);
		}
		
		@Override
		public AnnaDsbOtherUnderlying.AnnaDsbOtherUnderlyingBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AnnaDsbOtherUnderlying.AnnaDsbOtherUnderlyingBuilder prune() {
			if (basket!=null && !basket.prune().hasData()) basket = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getOtherUnderlierIDSource()!=null) return true;
			if (getOtherUnderlierID()!=null) return true;
			if (getBasket()!=null && getBasket().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AnnaDsbOtherUnderlying.AnnaDsbOtherUnderlyingBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			AnnaDsbOtherUnderlying.AnnaDsbOtherUnderlyingBuilder o = (AnnaDsbOtherUnderlying.AnnaDsbOtherUnderlyingBuilder) other;
			
			merger.mergeRosetta(getBasket(), o.getBasket(), this::setBasket);
			
			merger.mergeBasic(getOtherUnderlierIDSource(), o.getOtherUnderlierIDSource(), this::setOtherUnderlierIDSource);
			merger.mergeBasic(getOtherUnderlierID(), o.getOtherUnderlierID(), this::setOtherUnderlierID);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			AnnaDsbOtherUnderlying _that = getType().cast(o);
		
			if (!Objects.equals(otherUnderlierIDSource, _that.getOtherUnderlierIDSource())) return false;
			if (!Objects.equals(otherUnderlierID, _that.getOtherUnderlierID())) return false;
			if (!Objects.equals(basket, _that.getBasket())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (otherUnderlierIDSource != null ? otherUnderlierIDSource.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (otherUnderlierID != null ? otherUnderlierID.hashCode() : 0);
			_result = 31 * _result + (basket != null ? basket.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AnnaDsbOtherUnderlyingBuilder {" +
				"OtherUnderlierIDSource=" + this.otherUnderlierIDSource + ", " +
				"OtherUnderlierID=" + this.otherUnderlierID + ", " +
				"Basket=" + this.basket +
			'}';
		}
	}
}

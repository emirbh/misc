package drr.standards.iosco.upi;

import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.Accessor;
import com.rosetta.model.lib.annotations.AccessorType;
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
import drr.standards.iosco.upi.meta.AnnaDsbOtherLegUnderlierTypeMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 7.7.0
 */
@RosettaDataType(value="AnnaDsbOtherLegUnderlierType", builder=AnnaDsbOtherLegUnderlierType.AnnaDsbOtherLegUnderlierTypeBuilderImpl.class, version="7.7.0")
@RuneDataType(value="AnnaDsbOtherLegUnderlierType", model="drr", builder=AnnaDsbOtherLegUnderlierType.AnnaDsbOtherLegUnderlierTypeBuilderImpl.class, version="7.7.0")
public interface AnnaDsbOtherLegUnderlierType extends RosettaModelObject {

	AnnaDsbOtherLegUnderlierTypeMeta metaData = new AnnaDsbOtherLegUnderlierTypeMeta();

	/*********************** Getter Methods  ***********************/
	String getOtherLegUnderlierID();
	AnnaDsbOtherLegUnderlierIDSourceEnum getOtherLegUnderlierIDSource();

	/*********************** Build Methods  ***********************/
	AnnaDsbOtherLegUnderlierType build();
	
	AnnaDsbOtherLegUnderlierType.AnnaDsbOtherLegUnderlierTypeBuilder toBuilder();
	
	static AnnaDsbOtherLegUnderlierType.AnnaDsbOtherLegUnderlierTypeBuilder builder() {
		return new AnnaDsbOtherLegUnderlierType.AnnaDsbOtherLegUnderlierTypeBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends AnnaDsbOtherLegUnderlierType> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends AnnaDsbOtherLegUnderlierType> getType() {
		return AnnaDsbOtherLegUnderlierType.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("OtherLegUnderlierID"), String.class, getOtherLegUnderlierID(), this);
		processor.processBasic(path.newSubPath("OtherLegUnderlierIDSource"), AnnaDsbOtherLegUnderlierIDSourceEnum.class, getOtherLegUnderlierIDSource(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface AnnaDsbOtherLegUnderlierTypeBuilder extends AnnaDsbOtherLegUnderlierType, RosettaModelObjectBuilder {
		AnnaDsbOtherLegUnderlierType.AnnaDsbOtherLegUnderlierTypeBuilder setOtherLegUnderlierID(String OtherLegUnderlierID);
		AnnaDsbOtherLegUnderlierType.AnnaDsbOtherLegUnderlierTypeBuilder setOtherLegUnderlierIDSource(AnnaDsbOtherLegUnderlierIDSourceEnum OtherLegUnderlierIDSource);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("OtherLegUnderlierID"), String.class, getOtherLegUnderlierID(), this);
			processor.processBasic(path.newSubPath("OtherLegUnderlierIDSource"), AnnaDsbOtherLegUnderlierIDSourceEnum.class, getOtherLegUnderlierIDSource(), this);
		}
		

		AnnaDsbOtherLegUnderlierType.AnnaDsbOtherLegUnderlierTypeBuilder prune();
	}

	/*********************** Immutable Implementation of AnnaDsbOtherLegUnderlierType  ***********************/
	class AnnaDsbOtherLegUnderlierTypeImpl implements AnnaDsbOtherLegUnderlierType {
		private final String otherLegUnderlierID;
		private final AnnaDsbOtherLegUnderlierIDSourceEnum otherLegUnderlierIDSource;
		
		protected AnnaDsbOtherLegUnderlierTypeImpl(AnnaDsbOtherLegUnderlierType.AnnaDsbOtherLegUnderlierTypeBuilder builder) {
			this.otherLegUnderlierID = builder.getOtherLegUnderlierID();
			this.otherLegUnderlierIDSource = builder.getOtherLegUnderlierIDSource();
		}
		
		@Override
		@RosettaAttribute("OtherLegUnderlierID")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("OtherLegUnderlierID")
		public String getOtherLegUnderlierID() {
			return otherLegUnderlierID;
		}
		
		@Override
		@RosettaAttribute("OtherLegUnderlierIDSource")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("OtherLegUnderlierIDSource")
		public AnnaDsbOtherLegUnderlierIDSourceEnum getOtherLegUnderlierIDSource() {
			return otherLegUnderlierIDSource;
		}
		
		@Override
		public AnnaDsbOtherLegUnderlierType build() {
			return this;
		}
		
		@Override
		public AnnaDsbOtherLegUnderlierType.AnnaDsbOtherLegUnderlierTypeBuilder toBuilder() {
			AnnaDsbOtherLegUnderlierType.AnnaDsbOtherLegUnderlierTypeBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(AnnaDsbOtherLegUnderlierType.AnnaDsbOtherLegUnderlierTypeBuilder builder) {
			ofNullable(getOtherLegUnderlierID()).ifPresent(builder::setOtherLegUnderlierID);
			ofNullable(getOtherLegUnderlierIDSource()).ifPresent(builder::setOtherLegUnderlierIDSource);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			AnnaDsbOtherLegUnderlierType _that = getType().cast(o);
		
			if (!Objects.equals(otherLegUnderlierID, _that.getOtherLegUnderlierID())) return false;
			if (!Objects.equals(otherLegUnderlierIDSource, _that.getOtherLegUnderlierIDSource())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (otherLegUnderlierID != null ? otherLegUnderlierID.hashCode() : 0);
			_result = 31 * _result + (otherLegUnderlierIDSource != null ? otherLegUnderlierIDSource.getClass().getName().hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AnnaDsbOtherLegUnderlierType {" +
				"OtherLegUnderlierID=" + this.otherLegUnderlierID + ", " +
				"OtherLegUnderlierIDSource=" + this.otherLegUnderlierIDSource +
			'}';
		}
	}

	/*********************** Builder Implementation of AnnaDsbOtherLegUnderlierType  ***********************/
	class AnnaDsbOtherLegUnderlierTypeBuilderImpl implements AnnaDsbOtherLegUnderlierType.AnnaDsbOtherLegUnderlierTypeBuilder {
	
		protected String otherLegUnderlierID;
		protected AnnaDsbOtherLegUnderlierIDSourceEnum otherLegUnderlierIDSource;
		
		@Override
		@RosettaAttribute("OtherLegUnderlierID")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("OtherLegUnderlierID")
		public String getOtherLegUnderlierID() {
			return otherLegUnderlierID;
		}
		
		@Override
		@RosettaAttribute("OtherLegUnderlierIDSource")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("OtherLegUnderlierIDSource")
		public AnnaDsbOtherLegUnderlierIDSourceEnum getOtherLegUnderlierIDSource() {
			return otherLegUnderlierIDSource;
		}
		
		@RosettaAttribute("OtherLegUnderlierID")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("OtherLegUnderlierID")
		@Override
		public AnnaDsbOtherLegUnderlierType.AnnaDsbOtherLegUnderlierTypeBuilder setOtherLegUnderlierID(String _otherLegUnderlierID) {
			this.otherLegUnderlierID = _otherLegUnderlierID == null ? null : _otherLegUnderlierID;
			return this;
		}
		
		@RosettaAttribute("OtherLegUnderlierIDSource")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("OtherLegUnderlierIDSource")
		@Override
		public AnnaDsbOtherLegUnderlierType.AnnaDsbOtherLegUnderlierTypeBuilder setOtherLegUnderlierIDSource(AnnaDsbOtherLegUnderlierIDSourceEnum _otherLegUnderlierIDSource) {
			this.otherLegUnderlierIDSource = _otherLegUnderlierIDSource == null ? null : _otherLegUnderlierIDSource;
			return this;
		}
		
		@Override
		public AnnaDsbOtherLegUnderlierType build() {
			return new AnnaDsbOtherLegUnderlierType.AnnaDsbOtherLegUnderlierTypeImpl(this);
		}
		
		@Override
		public AnnaDsbOtherLegUnderlierType.AnnaDsbOtherLegUnderlierTypeBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AnnaDsbOtherLegUnderlierType.AnnaDsbOtherLegUnderlierTypeBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getOtherLegUnderlierID()!=null) return true;
			if (getOtherLegUnderlierIDSource()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AnnaDsbOtherLegUnderlierType.AnnaDsbOtherLegUnderlierTypeBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			AnnaDsbOtherLegUnderlierType.AnnaDsbOtherLegUnderlierTypeBuilder o = (AnnaDsbOtherLegUnderlierType.AnnaDsbOtherLegUnderlierTypeBuilder) other;
			
			
			merger.mergeBasic(getOtherLegUnderlierID(), o.getOtherLegUnderlierID(), this::setOtherLegUnderlierID);
			merger.mergeBasic(getOtherLegUnderlierIDSource(), o.getOtherLegUnderlierIDSource(), this::setOtherLegUnderlierIDSource);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			AnnaDsbOtherLegUnderlierType _that = getType().cast(o);
		
			if (!Objects.equals(otherLegUnderlierID, _that.getOtherLegUnderlierID())) return false;
			if (!Objects.equals(otherLegUnderlierIDSource, _that.getOtherLegUnderlierIDSource())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (otherLegUnderlierID != null ? otherLegUnderlierID.hashCode() : 0);
			_result = 31 * _result + (otherLegUnderlierIDSource != null ? otherLegUnderlierIDSource.getClass().getName().hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AnnaDsbOtherLegUnderlierTypeBuilder {" +
				"OtherLegUnderlierID=" + this.otherLegUnderlierID + ", " +
				"OtherLegUnderlierIDSource=" + this.otherLegUnderlierIDSource +
			'}';
		}
	}
}

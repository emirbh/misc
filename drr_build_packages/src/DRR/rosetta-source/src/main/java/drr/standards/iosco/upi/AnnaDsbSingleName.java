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
import drr.standards.iosco.upi.meta.AnnaDsbSingleNameMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 7.7.0
 */
@RosettaDataType(value="AnnaDsbSingleName", builder=AnnaDsbSingleName.AnnaDsbSingleNameBuilderImpl.class, version="7.7.0")
@RuneDataType(value="AnnaDsbSingleName", model="drr", builder=AnnaDsbSingleName.AnnaDsbSingleNameBuilderImpl.class, version="7.7.0")
public interface AnnaDsbSingleName extends RosettaModelObject {

	AnnaDsbSingleNameMeta metaData = new AnnaDsbSingleNameMeta();

	/*********************** Getter Methods  ***********************/
	AnnaDsbUnderlierIDSourceEnum getUnderlierIDSource();
	AnnaDsbDebtSeniorityEnum getDebtSeniority();
	String getUnderlierID();

	/*********************** Build Methods  ***********************/
	AnnaDsbSingleName build();
	
	AnnaDsbSingleName.AnnaDsbSingleNameBuilder toBuilder();
	
	static AnnaDsbSingleName.AnnaDsbSingleNameBuilder builder() {
		return new AnnaDsbSingleName.AnnaDsbSingleNameBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends AnnaDsbSingleName> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends AnnaDsbSingleName> getType() {
		return AnnaDsbSingleName.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("UnderlierIDSource"), AnnaDsbUnderlierIDSourceEnum.class, getUnderlierIDSource(), this);
		processor.processBasic(path.newSubPath("DebtSeniority"), AnnaDsbDebtSeniorityEnum.class, getDebtSeniority(), this);
		processor.processBasic(path.newSubPath("UnderlierID"), String.class, getUnderlierID(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface AnnaDsbSingleNameBuilder extends AnnaDsbSingleName, RosettaModelObjectBuilder {
		AnnaDsbSingleName.AnnaDsbSingleNameBuilder setUnderlierIDSource(AnnaDsbUnderlierIDSourceEnum UnderlierIDSource);
		AnnaDsbSingleName.AnnaDsbSingleNameBuilder setDebtSeniority(AnnaDsbDebtSeniorityEnum DebtSeniority);
		AnnaDsbSingleName.AnnaDsbSingleNameBuilder setUnderlierID(String UnderlierID);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("UnderlierIDSource"), AnnaDsbUnderlierIDSourceEnum.class, getUnderlierIDSource(), this);
			processor.processBasic(path.newSubPath("DebtSeniority"), AnnaDsbDebtSeniorityEnum.class, getDebtSeniority(), this);
			processor.processBasic(path.newSubPath("UnderlierID"), String.class, getUnderlierID(), this);
		}
		

		AnnaDsbSingleName.AnnaDsbSingleNameBuilder prune();
	}

	/*********************** Immutable Implementation of AnnaDsbSingleName  ***********************/
	class AnnaDsbSingleNameImpl implements AnnaDsbSingleName {
		private final AnnaDsbUnderlierIDSourceEnum underlierIDSource;
		private final AnnaDsbDebtSeniorityEnum debtSeniority;
		private final String underlierID;
		
		protected AnnaDsbSingleNameImpl(AnnaDsbSingleName.AnnaDsbSingleNameBuilder builder) {
			this.underlierIDSource = builder.getUnderlierIDSource();
			this.debtSeniority = builder.getDebtSeniority();
			this.underlierID = builder.getUnderlierID();
		}
		
		@Override
		@RosettaAttribute("UnderlierIDSource")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("UnderlierIDSource")
		public AnnaDsbUnderlierIDSourceEnum getUnderlierIDSource() {
			return underlierIDSource;
		}
		
		@Override
		@RosettaAttribute("DebtSeniority")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("DebtSeniority")
		public AnnaDsbDebtSeniorityEnum getDebtSeniority() {
			return debtSeniority;
		}
		
		@Override
		@RosettaAttribute("UnderlierID")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("UnderlierID")
		public String getUnderlierID() {
			return underlierID;
		}
		
		@Override
		public AnnaDsbSingleName build() {
			return this;
		}
		
		@Override
		public AnnaDsbSingleName.AnnaDsbSingleNameBuilder toBuilder() {
			AnnaDsbSingleName.AnnaDsbSingleNameBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(AnnaDsbSingleName.AnnaDsbSingleNameBuilder builder) {
			ofNullable(getUnderlierIDSource()).ifPresent(builder::setUnderlierIDSource);
			ofNullable(getDebtSeniority()).ifPresent(builder::setDebtSeniority);
			ofNullable(getUnderlierID()).ifPresent(builder::setUnderlierID);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			AnnaDsbSingleName _that = getType().cast(o);
		
			if (!Objects.equals(underlierIDSource, _that.getUnderlierIDSource())) return false;
			if (!Objects.equals(debtSeniority, _that.getDebtSeniority())) return false;
			if (!Objects.equals(underlierID, _that.getUnderlierID())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (underlierIDSource != null ? underlierIDSource.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (debtSeniority != null ? debtSeniority.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (underlierID != null ? underlierID.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AnnaDsbSingleName {" +
				"UnderlierIDSource=" + this.underlierIDSource + ", " +
				"DebtSeniority=" + this.debtSeniority + ", " +
				"UnderlierID=" + this.underlierID +
			'}';
		}
	}

	/*********************** Builder Implementation of AnnaDsbSingleName  ***********************/
	class AnnaDsbSingleNameBuilderImpl implements AnnaDsbSingleName.AnnaDsbSingleNameBuilder {
	
		protected AnnaDsbUnderlierIDSourceEnum underlierIDSource;
		protected AnnaDsbDebtSeniorityEnum debtSeniority;
		protected String underlierID;
		
		@Override
		@RosettaAttribute("UnderlierIDSource")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("UnderlierIDSource")
		public AnnaDsbUnderlierIDSourceEnum getUnderlierIDSource() {
			return underlierIDSource;
		}
		
		@Override
		@RosettaAttribute("DebtSeniority")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("DebtSeniority")
		public AnnaDsbDebtSeniorityEnum getDebtSeniority() {
			return debtSeniority;
		}
		
		@Override
		@RosettaAttribute("UnderlierID")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("UnderlierID")
		public String getUnderlierID() {
			return underlierID;
		}
		
		@RosettaAttribute("UnderlierIDSource")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("UnderlierIDSource")
		@Override
		public AnnaDsbSingleName.AnnaDsbSingleNameBuilder setUnderlierIDSource(AnnaDsbUnderlierIDSourceEnum _underlierIDSource) {
			this.underlierIDSource = _underlierIDSource == null ? null : _underlierIDSource;
			return this;
		}
		
		@RosettaAttribute("DebtSeniority")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("DebtSeniority")
		@Override
		public AnnaDsbSingleName.AnnaDsbSingleNameBuilder setDebtSeniority(AnnaDsbDebtSeniorityEnum _debtSeniority) {
			this.debtSeniority = _debtSeniority == null ? null : _debtSeniority;
			return this;
		}
		
		@RosettaAttribute("UnderlierID")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("UnderlierID")
		@Override
		public AnnaDsbSingleName.AnnaDsbSingleNameBuilder setUnderlierID(String _underlierID) {
			this.underlierID = _underlierID == null ? null : _underlierID;
			return this;
		}
		
		@Override
		public AnnaDsbSingleName build() {
			return new AnnaDsbSingleName.AnnaDsbSingleNameImpl(this);
		}
		
		@Override
		public AnnaDsbSingleName.AnnaDsbSingleNameBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AnnaDsbSingleName.AnnaDsbSingleNameBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getUnderlierIDSource()!=null) return true;
			if (getDebtSeniority()!=null) return true;
			if (getUnderlierID()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AnnaDsbSingleName.AnnaDsbSingleNameBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			AnnaDsbSingleName.AnnaDsbSingleNameBuilder o = (AnnaDsbSingleName.AnnaDsbSingleNameBuilder) other;
			
			
			merger.mergeBasic(getUnderlierIDSource(), o.getUnderlierIDSource(), this::setUnderlierIDSource);
			merger.mergeBasic(getDebtSeniority(), o.getDebtSeniority(), this::setDebtSeniority);
			merger.mergeBasic(getUnderlierID(), o.getUnderlierID(), this::setUnderlierID);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			AnnaDsbSingleName _that = getType().cast(o);
		
			if (!Objects.equals(underlierIDSource, _that.getUnderlierIDSource())) return false;
			if (!Objects.equals(debtSeniority, _that.getDebtSeniority())) return false;
			if (!Objects.equals(underlierID, _that.getUnderlierID())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (underlierIDSource != null ? underlierIDSource.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (debtSeniority != null ? debtSeniority.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (underlierID != null ? underlierID.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AnnaDsbSingleNameBuilder {" +
				"UnderlierIDSource=" + this.underlierIDSource + ", " +
				"DebtSeniority=" + this.debtSeniority + ", " +
				"UnderlierID=" + this.underlierID +
			'}';
		}
	}
}

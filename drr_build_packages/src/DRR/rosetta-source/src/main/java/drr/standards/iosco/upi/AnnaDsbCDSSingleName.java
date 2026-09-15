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
import drr.standards.iosco.upi.meta.AnnaDsbCDSSingleNameMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 7.7.0
 */
@RosettaDataType(value="AnnaDsbCDSSingleName", builder=AnnaDsbCDSSingleName.AnnaDsbCDSSingleNameBuilderImpl.class, version="7.7.0")
@RuneDataType(value="AnnaDsbCDSSingleName", model="drr", builder=AnnaDsbCDSSingleName.AnnaDsbCDSSingleNameBuilderImpl.class, version="7.7.0")
public interface AnnaDsbCDSSingleName extends RosettaModelObject {

	AnnaDsbCDSSingleNameMeta metaData = new AnnaDsbCDSSingleNameMeta();

	/*********************** Getter Methods  ***********************/
	AnnaDsbUnderlierIDSourceEnum getUnderlierIDSource();
	AnnaDsbDebtSeniorityEnum getDebtSeniority();
	String getUnderlierID();

	/*********************** Build Methods  ***********************/
	AnnaDsbCDSSingleName build();
	
	AnnaDsbCDSSingleName.AnnaDsbCDSSingleNameBuilder toBuilder();
	
	static AnnaDsbCDSSingleName.AnnaDsbCDSSingleNameBuilder builder() {
		return new AnnaDsbCDSSingleName.AnnaDsbCDSSingleNameBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends AnnaDsbCDSSingleName> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends AnnaDsbCDSSingleName> getType() {
		return AnnaDsbCDSSingleName.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("UnderlierIDSource"), AnnaDsbUnderlierIDSourceEnum.class, getUnderlierIDSource(), this);
		processor.processBasic(path.newSubPath("DebtSeniority"), AnnaDsbDebtSeniorityEnum.class, getDebtSeniority(), this);
		processor.processBasic(path.newSubPath("UnderlierID"), String.class, getUnderlierID(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface AnnaDsbCDSSingleNameBuilder extends AnnaDsbCDSSingleName, RosettaModelObjectBuilder {
		AnnaDsbCDSSingleName.AnnaDsbCDSSingleNameBuilder setUnderlierIDSource(AnnaDsbUnderlierIDSourceEnum UnderlierIDSource);
		AnnaDsbCDSSingleName.AnnaDsbCDSSingleNameBuilder setDebtSeniority(AnnaDsbDebtSeniorityEnum DebtSeniority);
		AnnaDsbCDSSingleName.AnnaDsbCDSSingleNameBuilder setUnderlierID(String UnderlierID);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("UnderlierIDSource"), AnnaDsbUnderlierIDSourceEnum.class, getUnderlierIDSource(), this);
			processor.processBasic(path.newSubPath("DebtSeniority"), AnnaDsbDebtSeniorityEnum.class, getDebtSeniority(), this);
			processor.processBasic(path.newSubPath("UnderlierID"), String.class, getUnderlierID(), this);
		}
		

		AnnaDsbCDSSingleName.AnnaDsbCDSSingleNameBuilder prune();
	}

	/*********************** Immutable Implementation of AnnaDsbCDSSingleName  ***********************/
	class AnnaDsbCDSSingleNameImpl implements AnnaDsbCDSSingleName {
		private final AnnaDsbUnderlierIDSourceEnum underlierIDSource;
		private final AnnaDsbDebtSeniorityEnum debtSeniority;
		private final String underlierID;
		
		protected AnnaDsbCDSSingleNameImpl(AnnaDsbCDSSingleName.AnnaDsbCDSSingleNameBuilder builder) {
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
		public AnnaDsbCDSSingleName build() {
			return this;
		}
		
		@Override
		public AnnaDsbCDSSingleName.AnnaDsbCDSSingleNameBuilder toBuilder() {
			AnnaDsbCDSSingleName.AnnaDsbCDSSingleNameBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(AnnaDsbCDSSingleName.AnnaDsbCDSSingleNameBuilder builder) {
			ofNullable(getUnderlierIDSource()).ifPresent(builder::setUnderlierIDSource);
			ofNullable(getDebtSeniority()).ifPresent(builder::setDebtSeniority);
			ofNullable(getUnderlierID()).ifPresent(builder::setUnderlierID);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			AnnaDsbCDSSingleName _that = getType().cast(o);
		
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
			return "AnnaDsbCDSSingleName {" +
				"UnderlierIDSource=" + this.underlierIDSource + ", " +
				"DebtSeniority=" + this.debtSeniority + ", " +
				"UnderlierID=" + this.underlierID +
			'}';
		}
	}

	/*********************** Builder Implementation of AnnaDsbCDSSingleName  ***********************/
	class AnnaDsbCDSSingleNameBuilderImpl implements AnnaDsbCDSSingleName.AnnaDsbCDSSingleNameBuilder {
	
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
		public AnnaDsbCDSSingleName.AnnaDsbCDSSingleNameBuilder setUnderlierIDSource(AnnaDsbUnderlierIDSourceEnum _underlierIDSource) {
			this.underlierIDSource = _underlierIDSource == null ? null : _underlierIDSource;
			return this;
		}
		
		@RosettaAttribute("DebtSeniority")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("DebtSeniority")
		@Override
		public AnnaDsbCDSSingleName.AnnaDsbCDSSingleNameBuilder setDebtSeniority(AnnaDsbDebtSeniorityEnum _debtSeniority) {
			this.debtSeniority = _debtSeniority == null ? null : _debtSeniority;
			return this;
		}
		
		@RosettaAttribute("UnderlierID")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("UnderlierID")
		@Override
		public AnnaDsbCDSSingleName.AnnaDsbCDSSingleNameBuilder setUnderlierID(String _underlierID) {
			this.underlierID = _underlierID == null ? null : _underlierID;
			return this;
		}
		
		@Override
		public AnnaDsbCDSSingleName build() {
			return new AnnaDsbCDSSingleName.AnnaDsbCDSSingleNameImpl(this);
		}
		
		@Override
		public AnnaDsbCDSSingleName.AnnaDsbCDSSingleNameBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AnnaDsbCDSSingleName.AnnaDsbCDSSingleNameBuilder prune() {
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
		public AnnaDsbCDSSingleName.AnnaDsbCDSSingleNameBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			AnnaDsbCDSSingleName.AnnaDsbCDSSingleNameBuilder o = (AnnaDsbCDSSingleName.AnnaDsbCDSSingleNameBuilder) other;
			
			
			merger.mergeBasic(getUnderlierIDSource(), o.getUnderlierIDSource(), this::setUnderlierIDSource);
			merger.mergeBasic(getDebtSeniority(), o.getDebtSeniority(), this::setDebtSeniority);
			merger.mergeBasic(getUnderlierID(), o.getUnderlierID(), this::setUnderlierID);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			AnnaDsbCDSSingleName _that = getType().cast(o);
		
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
			return "AnnaDsbCDSSingleNameBuilder {" +
				"UnderlierIDSource=" + this.underlierIDSource + ", " +
				"DebtSeniority=" + this.debtSeniority + ", " +
				"UnderlierID=" + this.underlierID +
			'}';
		}
	}
}

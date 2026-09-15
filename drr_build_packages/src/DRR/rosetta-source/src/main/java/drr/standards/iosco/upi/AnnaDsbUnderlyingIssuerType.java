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
import drr.standards.iosco.upi.meta.AnnaDsbUnderlyingIssuerTypeMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 7.7.0
 */
@RosettaDataType(value="AnnaDsbUnderlyingIssuerType", builder=AnnaDsbUnderlyingIssuerType.AnnaDsbUnderlyingIssuerTypeBuilderImpl.class, version="7.7.0")
@RuneDataType(value="AnnaDsbUnderlyingIssuerType", model="drr", builder=AnnaDsbUnderlyingIssuerType.AnnaDsbUnderlyingIssuerTypeBuilderImpl.class, version="7.7.0")
public interface AnnaDsbUnderlyingIssuerType extends RosettaModelObject {

	AnnaDsbUnderlyingIssuerTypeMeta metaData = new AnnaDsbUnderlyingIssuerTypeMeta();

	/*********************** Getter Methods  ***********************/
	AnnaDsbContractSpecification getSovereign();
	AnnaDsbContractSpecification getCorporate();
	AnnaDsbContractSpecification getLocal();

	/*********************** Build Methods  ***********************/
	AnnaDsbUnderlyingIssuerType build();
	
	AnnaDsbUnderlyingIssuerType.AnnaDsbUnderlyingIssuerTypeBuilder toBuilder();
	
	static AnnaDsbUnderlyingIssuerType.AnnaDsbUnderlyingIssuerTypeBuilder builder() {
		return new AnnaDsbUnderlyingIssuerType.AnnaDsbUnderlyingIssuerTypeBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends AnnaDsbUnderlyingIssuerType> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends AnnaDsbUnderlyingIssuerType> getType() {
		return AnnaDsbUnderlyingIssuerType.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("Sovereign"), processor, AnnaDsbContractSpecification.class, getSovereign());
		processRosetta(path.newSubPath("Corporate"), processor, AnnaDsbContractSpecification.class, getCorporate());
		processRosetta(path.newSubPath("Local"), processor, AnnaDsbContractSpecification.class, getLocal());
	}
	

	/*********************** Builder Interface  ***********************/
	interface AnnaDsbUnderlyingIssuerTypeBuilder extends AnnaDsbUnderlyingIssuerType, RosettaModelObjectBuilder {
		AnnaDsbContractSpecification.AnnaDsbContractSpecificationBuilder getOrCreateSovereign();
		@Override
		AnnaDsbContractSpecification.AnnaDsbContractSpecificationBuilder getSovereign();
		AnnaDsbContractSpecification.AnnaDsbContractSpecificationBuilder getOrCreateCorporate();
		@Override
		AnnaDsbContractSpecification.AnnaDsbContractSpecificationBuilder getCorporate();
		AnnaDsbContractSpecification.AnnaDsbContractSpecificationBuilder getOrCreateLocal();
		@Override
		AnnaDsbContractSpecification.AnnaDsbContractSpecificationBuilder getLocal();
		AnnaDsbUnderlyingIssuerType.AnnaDsbUnderlyingIssuerTypeBuilder setSovereign(AnnaDsbContractSpecification Sovereign);
		AnnaDsbUnderlyingIssuerType.AnnaDsbUnderlyingIssuerTypeBuilder setCorporate(AnnaDsbContractSpecification Corporate);
		AnnaDsbUnderlyingIssuerType.AnnaDsbUnderlyingIssuerTypeBuilder setLocal(AnnaDsbContractSpecification Local);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("Sovereign"), processor, AnnaDsbContractSpecification.AnnaDsbContractSpecificationBuilder.class, getSovereign());
			processRosetta(path.newSubPath("Corporate"), processor, AnnaDsbContractSpecification.AnnaDsbContractSpecificationBuilder.class, getCorporate());
			processRosetta(path.newSubPath("Local"), processor, AnnaDsbContractSpecification.AnnaDsbContractSpecificationBuilder.class, getLocal());
		}
		

		AnnaDsbUnderlyingIssuerType.AnnaDsbUnderlyingIssuerTypeBuilder prune();
	}

	/*********************** Immutable Implementation of AnnaDsbUnderlyingIssuerType  ***********************/
	class AnnaDsbUnderlyingIssuerTypeImpl implements AnnaDsbUnderlyingIssuerType {
		private final AnnaDsbContractSpecification sovereign;
		private final AnnaDsbContractSpecification corporate;
		private final AnnaDsbContractSpecification local;
		
		protected AnnaDsbUnderlyingIssuerTypeImpl(AnnaDsbUnderlyingIssuerType.AnnaDsbUnderlyingIssuerTypeBuilder builder) {
			this.sovereign = ofNullable(builder.getSovereign()).map(f->f.build()).orElse(null);
			this.corporate = ofNullable(builder.getCorporate()).map(f->f.build()).orElse(null);
			this.local = ofNullable(builder.getLocal()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("Sovereign")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("Sovereign")
		public AnnaDsbContractSpecification getSovereign() {
			return sovereign;
		}
		
		@Override
		@RosettaAttribute("Corporate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("Corporate")
		public AnnaDsbContractSpecification getCorporate() {
			return corporate;
		}
		
		@Override
		@RosettaAttribute("Local")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("Local")
		public AnnaDsbContractSpecification getLocal() {
			return local;
		}
		
		@Override
		public AnnaDsbUnderlyingIssuerType build() {
			return this;
		}
		
		@Override
		public AnnaDsbUnderlyingIssuerType.AnnaDsbUnderlyingIssuerTypeBuilder toBuilder() {
			AnnaDsbUnderlyingIssuerType.AnnaDsbUnderlyingIssuerTypeBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(AnnaDsbUnderlyingIssuerType.AnnaDsbUnderlyingIssuerTypeBuilder builder) {
			ofNullable(getSovereign()).ifPresent(builder::setSovereign);
			ofNullable(getCorporate()).ifPresent(builder::setCorporate);
			ofNullable(getLocal()).ifPresent(builder::setLocal);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			AnnaDsbUnderlyingIssuerType _that = getType().cast(o);
		
			if (!Objects.equals(sovereign, _that.getSovereign())) return false;
			if (!Objects.equals(corporate, _that.getCorporate())) return false;
			if (!Objects.equals(local, _that.getLocal())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (sovereign != null ? sovereign.hashCode() : 0);
			_result = 31 * _result + (corporate != null ? corporate.hashCode() : 0);
			_result = 31 * _result + (local != null ? local.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AnnaDsbUnderlyingIssuerType {" +
				"Sovereign=" + this.sovereign + ", " +
				"Corporate=" + this.corporate + ", " +
				"Local=" + this.local +
			'}';
		}
	}

	/*********************** Builder Implementation of AnnaDsbUnderlyingIssuerType  ***********************/
	class AnnaDsbUnderlyingIssuerTypeBuilderImpl implements AnnaDsbUnderlyingIssuerType.AnnaDsbUnderlyingIssuerTypeBuilder {
	
		protected AnnaDsbContractSpecification.AnnaDsbContractSpecificationBuilder sovereign;
		protected AnnaDsbContractSpecification.AnnaDsbContractSpecificationBuilder corporate;
		protected AnnaDsbContractSpecification.AnnaDsbContractSpecificationBuilder local;
		
		@Override
		@RosettaAttribute("Sovereign")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("Sovereign")
		public AnnaDsbContractSpecification.AnnaDsbContractSpecificationBuilder getSovereign() {
			return sovereign;
		}
		
		@Override
		public AnnaDsbContractSpecification.AnnaDsbContractSpecificationBuilder getOrCreateSovereign() {
			AnnaDsbContractSpecification.AnnaDsbContractSpecificationBuilder result;
			if (sovereign!=null) {
				result = sovereign;
			}
			else {
				result = sovereign = AnnaDsbContractSpecification.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("Corporate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("Corporate")
		public AnnaDsbContractSpecification.AnnaDsbContractSpecificationBuilder getCorporate() {
			return corporate;
		}
		
		@Override
		public AnnaDsbContractSpecification.AnnaDsbContractSpecificationBuilder getOrCreateCorporate() {
			AnnaDsbContractSpecification.AnnaDsbContractSpecificationBuilder result;
			if (corporate!=null) {
				result = corporate;
			}
			else {
				result = corporate = AnnaDsbContractSpecification.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("Local")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("Local")
		public AnnaDsbContractSpecification.AnnaDsbContractSpecificationBuilder getLocal() {
			return local;
		}
		
		@Override
		public AnnaDsbContractSpecification.AnnaDsbContractSpecificationBuilder getOrCreateLocal() {
			AnnaDsbContractSpecification.AnnaDsbContractSpecificationBuilder result;
			if (local!=null) {
				result = local;
			}
			else {
				result = local = AnnaDsbContractSpecification.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("Sovereign")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("Sovereign")
		@Override
		public AnnaDsbUnderlyingIssuerType.AnnaDsbUnderlyingIssuerTypeBuilder setSovereign(AnnaDsbContractSpecification _sovereign) {
			this.sovereign = _sovereign == null ? null : _sovereign.toBuilder();
			return this;
		}
		
		@RosettaAttribute("Corporate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("Corporate")
		@Override
		public AnnaDsbUnderlyingIssuerType.AnnaDsbUnderlyingIssuerTypeBuilder setCorporate(AnnaDsbContractSpecification _corporate) {
			this.corporate = _corporate == null ? null : _corporate.toBuilder();
			return this;
		}
		
		@RosettaAttribute("Local")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("Local")
		@Override
		public AnnaDsbUnderlyingIssuerType.AnnaDsbUnderlyingIssuerTypeBuilder setLocal(AnnaDsbContractSpecification _local) {
			this.local = _local == null ? null : _local.toBuilder();
			return this;
		}
		
		@Override
		public AnnaDsbUnderlyingIssuerType build() {
			return new AnnaDsbUnderlyingIssuerType.AnnaDsbUnderlyingIssuerTypeImpl(this);
		}
		
		@Override
		public AnnaDsbUnderlyingIssuerType.AnnaDsbUnderlyingIssuerTypeBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AnnaDsbUnderlyingIssuerType.AnnaDsbUnderlyingIssuerTypeBuilder prune() {
			if (sovereign!=null && !sovereign.prune().hasData()) sovereign = null;
			if (corporate!=null && !corporate.prune().hasData()) corporate = null;
			if (local!=null && !local.prune().hasData()) local = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getSovereign()!=null && getSovereign().hasData()) return true;
			if (getCorporate()!=null && getCorporate().hasData()) return true;
			if (getLocal()!=null && getLocal().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AnnaDsbUnderlyingIssuerType.AnnaDsbUnderlyingIssuerTypeBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			AnnaDsbUnderlyingIssuerType.AnnaDsbUnderlyingIssuerTypeBuilder o = (AnnaDsbUnderlyingIssuerType.AnnaDsbUnderlyingIssuerTypeBuilder) other;
			
			merger.mergeRosetta(getSovereign(), o.getSovereign(), this::setSovereign);
			merger.mergeRosetta(getCorporate(), o.getCorporate(), this::setCorporate);
			merger.mergeRosetta(getLocal(), o.getLocal(), this::setLocal);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			AnnaDsbUnderlyingIssuerType _that = getType().cast(o);
		
			if (!Objects.equals(sovereign, _that.getSovereign())) return false;
			if (!Objects.equals(corporate, _that.getCorporate())) return false;
			if (!Objects.equals(local, _that.getLocal())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (sovereign != null ? sovereign.hashCode() : 0);
			_result = 31 * _result + (corporate != null ? corporate.hashCode() : 0);
			_result = 31 * _result + (local != null ? local.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AnnaDsbUnderlyingIssuerTypeBuilder {" +
				"Sovereign=" + this.sovereign + ", " +
				"Corporate=" + this.corporate + ", " +
				"Local=" + this.local +
			'}';
		}
	}
}

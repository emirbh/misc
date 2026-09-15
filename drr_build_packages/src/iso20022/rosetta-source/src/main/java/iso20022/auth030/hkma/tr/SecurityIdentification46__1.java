package iso20022.auth030.hkma.tr;

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
import iso20022.auth030.hkma.tr.meta.SecurityIdentification46__1Meta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * Choice between ISIN and an alternative format for the identification of a financial instrument. ISIN is the preferred format.
 * @version ${project.version}
 */
@RosettaDataType(value="SecurityIdentification46__1", builder=SecurityIdentification46__1.SecurityIdentification46__1BuilderImpl.class, version="${project.version}")
@RuneDataType(value="SecurityIdentification46__1", model="iso20022", builder=SecurityIdentification46__1.SecurityIdentification46__1BuilderImpl.class, version="${project.version}")
public interface SecurityIdentification46__1 extends RosettaModelObject {

	SecurityIdentification46__1Meta metaData = new SecurityIdentification46__1Meta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Identification through a unique product identifier.
	 */
	UniqueProductIdentifier2Choice__1 getUnqPdctIdr();
	/**
	 * Specifies a human readable description of the product.
	 */
	String getPdctDesc();

	/*********************** Build Methods  ***********************/
	SecurityIdentification46__1 build();
	
	SecurityIdentification46__1.SecurityIdentification46__1Builder toBuilder();
	
	static SecurityIdentification46__1.SecurityIdentification46__1Builder builder() {
		return new SecurityIdentification46__1.SecurityIdentification46__1BuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends SecurityIdentification46__1> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends SecurityIdentification46__1> getType() {
		return SecurityIdentification46__1.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("unqPdctIdr"), processor, UniqueProductIdentifier2Choice__1.class, getUnqPdctIdr());
		processor.processBasic(path.newSubPath("pdctDesc"), String.class, getPdctDesc(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface SecurityIdentification46__1Builder extends SecurityIdentification46__1, RosettaModelObjectBuilder {
		UniqueProductIdentifier2Choice__1.UniqueProductIdentifier2Choice__1Builder getOrCreateUnqPdctIdr();
		@Override
		UniqueProductIdentifier2Choice__1.UniqueProductIdentifier2Choice__1Builder getUnqPdctIdr();
		SecurityIdentification46__1.SecurityIdentification46__1Builder setUnqPdctIdr(UniqueProductIdentifier2Choice__1 unqPdctIdr);
		SecurityIdentification46__1.SecurityIdentification46__1Builder setPdctDesc(String pdctDesc);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("unqPdctIdr"), processor, UniqueProductIdentifier2Choice__1.UniqueProductIdentifier2Choice__1Builder.class, getUnqPdctIdr());
			processor.processBasic(path.newSubPath("pdctDesc"), String.class, getPdctDesc(), this);
		}
		

		SecurityIdentification46__1.SecurityIdentification46__1Builder prune();
	}

	/*********************** Immutable Implementation of SecurityIdentification46__1  ***********************/
	class SecurityIdentification46__1Impl implements SecurityIdentification46__1 {
		private final UniqueProductIdentifier2Choice__1 unqPdctIdr;
		private final String pdctDesc;
		
		protected SecurityIdentification46__1Impl(SecurityIdentification46__1.SecurityIdentification46__1Builder builder) {
			this.unqPdctIdr = ofNullable(builder.getUnqPdctIdr()).map(f->f.build()).orElse(null);
			this.pdctDesc = builder.getPdctDesc();
		}
		
		@Override
		@RosettaAttribute("unqPdctIdr")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("unqPdctIdr")
		public UniqueProductIdentifier2Choice__1 getUnqPdctIdr() {
			return unqPdctIdr;
		}
		
		@Override
		@RosettaAttribute("pdctDesc")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("pdctDesc")
		public String getPdctDesc() {
			return pdctDesc;
		}
		
		@Override
		public SecurityIdentification46__1 build() {
			return this;
		}
		
		@Override
		public SecurityIdentification46__1.SecurityIdentification46__1Builder toBuilder() {
			SecurityIdentification46__1.SecurityIdentification46__1Builder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(SecurityIdentification46__1.SecurityIdentification46__1Builder builder) {
			ofNullable(getUnqPdctIdr()).ifPresent(builder::setUnqPdctIdr);
			ofNullable(getPdctDesc()).ifPresent(builder::setPdctDesc);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			SecurityIdentification46__1 _that = getType().cast(o);
		
			if (!Objects.equals(unqPdctIdr, _that.getUnqPdctIdr())) return false;
			if (!Objects.equals(pdctDesc, _that.getPdctDesc())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (unqPdctIdr != null ? unqPdctIdr.hashCode() : 0);
			_result = 31 * _result + (pdctDesc != null ? pdctDesc.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "SecurityIdentification46__1 {" +
				"unqPdctIdr=" + this.unqPdctIdr + ", " +
				"pdctDesc=" + this.pdctDesc +
			'}';
		}
	}

	/*********************** Builder Implementation of SecurityIdentification46__1  ***********************/
	class SecurityIdentification46__1BuilderImpl implements SecurityIdentification46__1.SecurityIdentification46__1Builder {
	
		protected UniqueProductIdentifier2Choice__1.UniqueProductIdentifier2Choice__1Builder unqPdctIdr;
		protected String pdctDesc;
		
		@Override
		@RosettaAttribute("unqPdctIdr")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("unqPdctIdr")
		public UniqueProductIdentifier2Choice__1.UniqueProductIdentifier2Choice__1Builder getUnqPdctIdr() {
			return unqPdctIdr;
		}
		
		@Override
		public UniqueProductIdentifier2Choice__1.UniqueProductIdentifier2Choice__1Builder getOrCreateUnqPdctIdr() {
			UniqueProductIdentifier2Choice__1.UniqueProductIdentifier2Choice__1Builder result;
			if (unqPdctIdr!=null) {
				result = unqPdctIdr;
			}
			else {
				result = unqPdctIdr = UniqueProductIdentifier2Choice__1.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("pdctDesc")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("pdctDesc")
		public String getPdctDesc() {
			return pdctDesc;
		}
		
		@RosettaAttribute("unqPdctIdr")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("unqPdctIdr")
		@Override
		public SecurityIdentification46__1.SecurityIdentification46__1Builder setUnqPdctIdr(UniqueProductIdentifier2Choice__1 _unqPdctIdr) {
			this.unqPdctIdr = _unqPdctIdr == null ? null : _unqPdctIdr.toBuilder();
			return this;
		}
		
		@RosettaAttribute("pdctDesc")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("pdctDesc")
		@Override
		public SecurityIdentification46__1.SecurityIdentification46__1Builder setPdctDesc(String _pdctDesc) {
			this.pdctDesc = _pdctDesc == null ? null : _pdctDesc;
			return this;
		}
		
		@Override
		public SecurityIdentification46__1 build() {
			return new SecurityIdentification46__1.SecurityIdentification46__1Impl(this);
		}
		
		@Override
		public SecurityIdentification46__1.SecurityIdentification46__1Builder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public SecurityIdentification46__1.SecurityIdentification46__1Builder prune() {
			if (unqPdctIdr!=null && !unqPdctIdr.prune().hasData()) unqPdctIdr = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getUnqPdctIdr()!=null && getUnqPdctIdr().hasData()) return true;
			if (getPdctDesc()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public SecurityIdentification46__1.SecurityIdentification46__1Builder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			SecurityIdentification46__1.SecurityIdentification46__1Builder o = (SecurityIdentification46__1.SecurityIdentification46__1Builder) other;
			
			merger.mergeRosetta(getUnqPdctIdr(), o.getUnqPdctIdr(), this::setUnqPdctIdr);
			
			merger.mergeBasic(getPdctDesc(), o.getPdctDesc(), this::setPdctDesc);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			SecurityIdentification46__1 _that = getType().cast(o);
		
			if (!Objects.equals(unqPdctIdr, _that.getUnqPdctIdr())) return false;
			if (!Objects.equals(pdctDesc, _that.getPdctDesc())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (unqPdctIdr != null ? unqPdctIdr.hashCode() : 0);
			_result = 31 * _result + (pdctDesc != null ? pdctDesc.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "SecurityIdentification46__1Builder {" +
				"unqPdctIdr=" + this.unqPdctIdr + ", " +
				"pdctDesc=" + this.pdctDesc +
			'}';
		}
	}
}

package iso20022.auth030.esma;

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
import iso20022.auth030.esma.meta.SecurityIdentification46__1Meta;
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
	 * International Securities Identification Number (ISIN). A numbering system designed by the United Nation&#39;s International Organisation for Standardisation (ISO). The ISIN is composed of a 2-character prefix representing the country of issue, followed by the national security number (if one exists), and a check digit. Each country has a national numbering agency that assigns ISIN numbers for securities in that country.
	 */
	String getIsin();
	/**
	 * Identification through a unique product identifier.
	 */
	UniqueProductIdentifier2Choice__1 getUnqPdctIdr();

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
		processor.processBasic(path.newSubPath("isin"), String.class, getIsin(), this);
		processRosetta(path.newSubPath("unqPdctIdr"), processor, UniqueProductIdentifier2Choice__1.class, getUnqPdctIdr());
	}
	

	/*********************** Builder Interface  ***********************/
	interface SecurityIdentification46__1Builder extends SecurityIdentification46__1, RosettaModelObjectBuilder {
		UniqueProductIdentifier2Choice__1.UniqueProductIdentifier2Choice__1Builder getOrCreateUnqPdctIdr();
		@Override
		UniqueProductIdentifier2Choice__1.UniqueProductIdentifier2Choice__1Builder getUnqPdctIdr();
		SecurityIdentification46__1.SecurityIdentification46__1Builder setIsin(String isin);
		SecurityIdentification46__1.SecurityIdentification46__1Builder setUnqPdctIdr(UniqueProductIdentifier2Choice__1 unqPdctIdr);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("isin"), String.class, getIsin(), this);
			processRosetta(path.newSubPath("unqPdctIdr"), processor, UniqueProductIdentifier2Choice__1.UniqueProductIdentifier2Choice__1Builder.class, getUnqPdctIdr());
		}
		

		SecurityIdentification46__1.SecurityIdentification46__1Builder prune();
	}

	/*********************** Immutable Implementation of SecurityIdentification46__1  ***********************/
	class SecurityIdentification46__1Impl implements SecurityIdentification46__1 {
		private final String isin;
		private final UniqueProductIdentifier2Choice__1 unqPdctIdr;
		
		protected SecurityIdentification46__1Impl(SecurityIdentification46__1.SecurityIdentification46__1Builder builder) {
			this.isin = builder.getIsin();
			this.unqPdctIdr = ofNullable(builder.getUnqPdctIdr()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("isin")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("isin")
		public String getIsin() {
			return isin;
		}
		
		@Override
		@RosettaAttribute("unqPdctIdr")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("unqPdctIdr")
		public UniqueProductIdentifier2Choice__1 getUnqPdctIdr() {
			return unqPdctIdr;
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
			ofNullable(getIsin()).ifPresent(builder::setIsin);
			ofNullable(getUnqPdctIdr()).ifPresent(builder::setUnqPdctIdr);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			SecurityIdentification46__1 _that = getType().cast(o);
		
			if (!Objects.equals(isin, _that.getIsin())) return false;
			if (!Objects.equals(unqPdctIdr, _that.getUnqPdctIdr())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (isin != null ? isin.hashCode() : 0);
			_result = 31 * _result + (unqPdctIdr != null ? unqPdctIdr.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "SecurityIdentification46__1 {" +
				"isin=" + this.isin + ", " +
				"unqPdctIdr=" + this.unqPdctIdr +
			'}';
		}
	}

	/*********************** Builder Implementation of SecurityIdentification46__1  ***********************/
	class SecurityIdentification46__1BuilderImpl implements SecurityIdentification46__1.SecurityIdentification46__1Builder {
	
		protected String isin;
		protected UniqueProductIdentifier2Choice__1.UniqueProductIdentifier2Choice__1Builder unqPdctIdr;
		
		@Override
		@RosettaAttribute("isin")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("isin")
		public String getIsin() {
			return isin;
		}
		
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
		
		@RosettaAttribute("isin")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("isin")
		@Override
		public SecurityIdentification46__1.SecurityIdentification46__1Builder setIsin(String _isin) {
			this.isin = _isin == null ? null : _isin;
			return this;
		}
		
		@RosettaAttribute("unqPdctIdr")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("unqPdctIdr")
		@Override
		public SecurityIdentification46__1.SecurityIdentification46__1Builder setUnqPdctIdr(UniqueProductIdentifier2Choice__1 _unqPdctIdr) {
			this.unqPdctIdr = _unqPdctIdr == null ? null : _unqPdctIdr.toBuilder();
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
			if (getIsin()!=null) return true;
			if (getUnqPdctIdr()!=null && getUnqPdctIdr().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public SecurityIdentification46__1.SecurityIdentification46__1Builder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			SecurityIdentification46__1.SecurityIdentification46__1Builder o = (SecurityIdentification46__1.SecurityIdentification46__1Builder) other;
			
			merger.mergeRosetta(getUnqPdctIdr(), o.getUnqPdctIdr(), this::setUnqPdctIdr);
			
			merger.mergeBasic(getIsin(), o.getIsin(), this::setIsin);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			SecurityIdentification46__1 _that = getType().cast(o);
		
			if (!Objects.equals(isin, _that.getIsin())) return false;
			if (!Objects.equals(unqPdctIdr, _that.getUnqPdctIdr())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (isin != null ? isin.hashCode() : 0);
			_result = 31 * _result + (unqPdctIdr != null ? unqPdctIdr.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "SecurityIdentification46__1Builder {" +
				"isin=" + this.isin + ", " +
				"unqPdctIdr=" + this.unqPdctIdr +
			'}';
		}
	}
}
